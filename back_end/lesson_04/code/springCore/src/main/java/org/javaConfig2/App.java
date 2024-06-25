package org.javaConfig2;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        WeekDay weekDay = context.getBean(WeekDay.class);
        System.out.println("Today is " + weekDay.getWeekDayName());
    }
}
