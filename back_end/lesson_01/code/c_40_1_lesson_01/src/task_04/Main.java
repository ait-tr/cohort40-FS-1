package lesson_01.code.c_40_1_lesson_01.src.task_04;

// Есть счётчик (целочисленный).
// Есть три потока.
// Каждый поток в цикле должен увеличить миллион раз
// значение счётчика на единицу. Вывести значение счётчика в консоль.

public class Main {

    private static int counter;

    public static synchronized void increment() {
        counter++;
    }

    public static void main(String[] args) {

        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread1.start();
        myThread2.start();

        for (int i = 0; i < 1_000_000; i++) {
            increment();
        }

        try {
            myThread1.join();
            myThread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter value: " + counter);
    }
}