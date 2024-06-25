package org.javaConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) throws InterruptedException {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Cat cat = context.getBean(Cat.class);

        Dog dog = (Dog) context.getBean("dog");

        Parrot parrot = context.getBean("parrot-kesha", Parrot.class);

        System.out.println("===========");

        System.out.println(cat.getName());
        System.out.println(dog.getName());
        System.out.println(parrot.getName());

    }
}
