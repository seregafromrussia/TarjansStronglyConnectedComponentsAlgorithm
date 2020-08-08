package kurs;

import lombok.extern.java.Log;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Log
@EnableAspectJAutoProxy
@ComponentScan()
public class Application {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(Application.class);
    }
}

