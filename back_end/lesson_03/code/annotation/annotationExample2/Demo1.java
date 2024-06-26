package lesson_03.code.annotation.annotationExample2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Demo1 {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Example1> example = Example1.class;

        Annotation[] annotations = example.getAnnotations();
        for (Annotation annotation : annotations){
            if (annotation instanceof JavaFileInfo javaFileInfo) {
                System.out.println("Автор: " + javaFileInfo.name());
                System.out.println("Автор: " + javaFileInfo.value());
            }
        }


        Method method = example.getMethod("printDate");

        annotations = method.getAnnotations();
        for (Annotation annotation : annotations){
            if (annotation instanceof JavaFileInfo javaFileInfo) {
                System.out.println("Автор: " + javaFileInfo.name());
                System.out.println("Автор: " + javaFileInfo.value());
            }
        }





    }
}
