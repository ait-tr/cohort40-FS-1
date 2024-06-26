package code.thread.part1;

public class ThreadExampleDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ThreadExample1 thread = new ThreadExample1();
            //System.out.println(thread);
            thread.start();
        }
    }
}
