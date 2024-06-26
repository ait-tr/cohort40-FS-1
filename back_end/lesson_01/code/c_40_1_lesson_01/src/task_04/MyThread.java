package lesson_01.code.c_40_1_lesson_01.src.task_04;

public class MyThread extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 1_000_000; i++) {
            Main.increment();
        }
    }
}