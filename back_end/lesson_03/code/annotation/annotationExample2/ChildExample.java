package lesson_03.code.annotation.annotationExample2;

public class ChildExample extends ParentExample{

 @Override
    public void printDate() {
        System.out.println("Печатаем как дочерний класс");
    }
}
