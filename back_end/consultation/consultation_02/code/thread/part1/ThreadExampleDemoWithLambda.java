package code.thread.part1;

public class ThreadExampleDemoWithLambda {
    public static void main(String[] args) {
       Thread thread = new Thread(() -> System.out.println("Thread is running!"));
       thread.start();
    }
}
