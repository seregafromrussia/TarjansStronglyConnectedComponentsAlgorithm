package kurs.GraphComponents;

import lombok.extern.java.Log;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Log
public class Application {
    public static void main(String[] args) {
        //TODO: Delete context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
                ("applicationContext.xml");
    }
}

