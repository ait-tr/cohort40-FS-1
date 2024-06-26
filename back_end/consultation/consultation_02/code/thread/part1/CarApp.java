package code.thread.part1;

public class CarApp {
    public static void main(String[] args) {
        var ferrari = new Car("Ferrari");
        var bmw = new Car("BWM");

        ferrari.start();
        bmw.start();

        System.out.println("Method continued execution ...  Main method is executed by thread " + Thread.currentThread().getName());
    }
}
