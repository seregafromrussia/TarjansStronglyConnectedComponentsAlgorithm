package kurs.GraphComponents;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class Application {
    public static void main(String[] args) {
        //TODO: Delete context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
                ("applicationContext.xml");
    }
}

