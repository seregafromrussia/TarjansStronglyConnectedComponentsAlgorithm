package kurs;

import lombok.extern.java.Log;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@Log
@ComponentScan("kurs")
public final class Application {
    public static void main(String[] args) {
        log.info("Stars application");
        new AnnotationConfigApplicationContext(Application.class);
        log.info("Stop application");
    }
}

