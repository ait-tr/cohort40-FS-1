package code.thread.part2;

public class CarAppWithRunnable {
    public static void main(String[] args) {
        var ferrari = new CarWithRunnable("Ferrari");
        var bmw = new CarWithRunnable("BWM");

        var ferrariThread = new Thread(ferrari,"Ferrari-Thread");
        var bmwThread = new Thread(bmw,"BMW-Thread");

        ferrariThread.start();
        bmwThread.start();

        System.out.println("Method continued execution ...  Main method is executed by thread " + Thread.currentThread().getName());
    }
}
