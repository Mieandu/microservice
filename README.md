# microservice

#### 项目描述
该项目只是提供Spring Cloud.GreenWich的简单集成，防止大家在学习使用GreenWich版本时踩不必要的坑。

目前提供了Spring Cloud.GreenWich的部分组件，为了方便运行，默认提供了和Docker的集成，因此一些路径的配置使用了Docker自带的DNS机制（如：注册中心的地址），
>不想使用的Docker的话，可以将host改成自己的ip地址，直接运行
#### 包含组件
目前有配置中心（Config）、注册中心（Eureka）、网关（Zuul、Gateway）、认证（Auth）、应用监控（Admin）、链路监控(Zipkin)等组件。

#### 运行
##### 一.使用Docker容器运行
1. 使用Docker的同学需要先在机器上安装好Docker
2. 项目和Docker的集成使用的插件是Spotify，绑定的是Maven的package阶段，因此使用Maven的打包会自动构建docker镜像
3. 在docker目录下提供了两个compose文件:
    - docker-compose-base.yml 基础服务组件（配置中心、注册中心等）
    - docker-compose.yml 业务测试服务

可以使用如下命令运行：

    docker stack deploy -c docker-compose-base.yml base_service

> 如果使用的是最版本的IntelliJ IDEA,只配置好和Docker的关联，可以直接运行这两个文件


##### 二.使用main方式运行
1. 修改application.yml中注册中心的地址，业务类的服务同时需要更改配置中心的地址
2. 直接运行注册中心
3. 直接运行配置中心
4. 其它服务按需运行

####目录介绍

- adminserver 应用监控
- autheserver 认证服务
- common 通用工具类
- config-repo 配置文件
- contentservice 内容服务（业务）
- docker docker的compose文件
- eurekaserver 注册中心
- gatewayserver Gateway网关
- userservice 用户服务（业务）
- zipkinserver 链路监控中心
- zuulserver Zuul网关