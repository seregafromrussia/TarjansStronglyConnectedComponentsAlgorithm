package kurs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("kurs")
public final class Application {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(Application.class);
    }
}

