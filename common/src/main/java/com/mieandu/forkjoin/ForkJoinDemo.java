package com.mieandu.forkjoin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class ForkJoinDemo {

    public static class ItemInfoTask extends RecursiveTask<Object>{

        // 商品ID集合
        private List<String> list;
        // 最终计算的商品大小
        private final int taskSize = 1;

        ItemInfoTask(List<String> list){
            this.list = list;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected Object compute() {
            // 计算出来的结果
            List<Object> result = new ArrayList<>();

            // 将商品数量分成4个
            if(list.size() <=  taskSize){
                // 假设每个商品信息的计算会耗费100ms
                try {
                    Thread.sleep(taskSize * 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 将计算的结果加到集合中
                result.add(Collections.singletonList(new Object()));
            }else{
                // 对于大于 taskSize 的集合分成两半再进行并行计算
                int middle = list.size() / 2;
                ItemInfoTask leftTask = new ItemInfoTask(list.subList(0,middle));
                ItemInfoTask rightTask = new ItemInfoTask(list.subList(middle,list.size()));
                // 执行子任务
                leftTask.fork();
                rightTask.fork();
                // 等待子任务完成，并得到执行结果
                List<Object> leftResult = (List<Object>) leftTask.join();
                List<Object> rightResult = (List<Object>) rightTask.join();

                result.addAll(leftResult);
                result.addAll(rightResult);
            }
            // 返回本次任务的结果
            return result;
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("商品ID");
        }
        long begin = System.nanoTime();
        // 将任务放到线程池中执行
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask result = forkJoinPool.submit(new ItemInfoTask(list));
        try {
            // 获取结果
            List x = (List) result.get();
            System.out.println(x.size());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("花费时间：" + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - begin));
        forkJoinPool.shutdown();
    }
}
