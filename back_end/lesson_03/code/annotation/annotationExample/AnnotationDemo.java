package lesson_03.code.annotation.annotationExample;

public class AnnotationDemo {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();
        testInterface(parent);
        testInterface(child);

        testAnnotation(parent);
        testAnnotation(child);

    }

    static void testInterface(MyMark markedObject){
        System.out.println("Метод testInterface завершен успешно");
    }

    static void testAnnotation(Object object){
        if (!object.getClass().isAnnotationPresent(MyAnnotation.class)){
            throw new RuntimeException("Объект не аннотирован аннотацией 'MyAnnotation'");
        } else {
            System.out.println("Метод testAnnotation завершен успешно");
        }
    }

}
