package lesson_01.code.c_40_1_lesson_01.src.task_02;

// Есть счётчик (целочисленный).
// Задача - в цикле увеличить значение этого счётчика
// миллион раз на единицу. Вывести значение счётчика в консоль.

public class Main {

    public static int counter;

    public static void main(String[] args) {

        for (int i = 0; i < 1_000_000; i++) {
            counter++;
        }

        System.out.println("Counter value: " + counter);
    }
}