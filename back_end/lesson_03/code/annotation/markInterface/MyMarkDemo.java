package code.annotation.markInterface;

public class MyMarkDemo {
    public static void main(String[] args) {
        MarkedClass marked = new MarkedClass();
        NonMarkedClass nonMarked = new NonMarkedClass();

        test(marked);
        //test(nonMarked);

    }

    static void test(MyMark markedClass){
        System.out.println("Метод 'test' прошел успешно");
    }
}
