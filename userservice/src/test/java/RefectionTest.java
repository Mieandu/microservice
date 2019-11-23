import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;

public class RefectionTest {
    public static void main(String[] args) {
        scanControlelr();
    }
                                                                                                                                                                             
    private static void scanControlelr() {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage("com.mieandu.userservice.controller"))
                .setScanners(new MethodAnnotationsScanner()));
        Set<Method> methods = reflections.getMethodsAnnotatedWith(RequestMapping.class);
        for(Method method : methods){
            RequestMapping annotation = method.getAnnotation(RequestMapping.class);
            System.out.println(Arrays.toString(annotation.value()));
        }
    }
}
