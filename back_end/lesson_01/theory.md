# Lesson 01

###  Многопоточность. Введение

1. **Процессы и потоки**
   - Определение и различие между процессом и потоком.
   - Процессы как независимые единицы с собственными ресурсами.
   - Потоки как подзадачи внутри процесса, использующие общие ресурсы.
   - Разница между потоками и процессами в контексте информации, использования памяти и скорости переключения.

###  **Создание и запуск потоков в Java**
   В Java потоки можно создавать двумя способами: наследуясь от класса `Thread` или реализуя интерфейс `Runnable`.

   - **Пример с наследованием от класса Thread:**

     ```java
     class MyThread extends Thread {
         public void run() {
             System.out.println("Поток запущен: " + Thread.currentThread().getName());
         }
     }

     public class Main {
         public static void main(String[] args) {
             MyThread thread = new MyThread();
             thread.start();
         }
     }
     ```

   - **Пример с реализацией интерфейса Runnable:**

     ```java
     class MyRunnable implements Runnable {
         public void run() {
             System.out.println("Поток запущен: " + Thread.currentThread().getName());
         }
     }

     public class Main {
         public static void main(String[] args) {
             Thread thread = new Thread(new MyRunnable());
             thread.start();
         }
     }
     ```

###  **Управление потоками:**
   - Метод `start()` запускает поток, в то время как вызов `run()` просто выполняет код в текущем потоке.
   - Можно устанавливать приоритеты потоков, используя метод `setPriority()`, что влияет на распределение времени процессора между потоками.
   - Потоки-демоны (`daemon threads`) — это служебные потоки, которые не препятствуют завершению работы JVM.
   - Метод `join()` позволяет одному потоку ожидать завершения работы другого потока.
   - Приостановка выполнения потока может быть реализована с помощью `Thread.sleep()`



### Метод join() в Java

#### Введение в join()
Метод `join()` в Java позволяет одному потоку ожидать завершения другого потока. Это особенно полезно в многопоточных программах, где один поток должен дождаться завершения других потоков перед продолжением выполнения. Этот метод блокирует текущий поток до тех пор, пока целевой поток, на котором был вызван `join()`, не завершится.

#### Примеры использования метода join()

##### Пример 1: Синхронизация счетчика
```java
class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}

class MyRunnable implements Runnable {
    private final Counter counter;

    public MyRunnable(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread1 = new Thread(new MyRunnable(counter));
        Thread thread2 = new Thread(new MyRunnable(counter));
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Count: " + counter.getCount());
    }
}
```
В этом примере два потока увеличивают счетчик в общем объекте `Counter`. Главный поток дожидается их завершения, используя `join()`, прежде чем выводить итоговое значение счетчика.

##### Пример 2: Подсчет суммы в потоках
```java
class MyThread extends Thread {
    private int result;

    public void run() {
        result = 0;
        for (int i = 1; i <= 10; i++) {
            result += i;
        }
    }

    public int getResult() {
        return result;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        int result = thread1.getResult() + thread2.getResult();
        System.out.println("Result: " + result);
    }
}
```
Здесь два потока вычисляют сумму чисел, а главный поток ожидает их завершения, чтобы суммировать их результаты.


## Синхронизация потоков в Java

### Проблемы многопоточности
- Последовательность выполнения действий в разных потоках может привести к неожиданным результатам.
- Параллельный доступ к общим ресурсам без должной синхронизации может вызвать гонки данных (race conditions) и привести к неправильному поведению программы.
- Взаимные блокировки и неравномерное распределение ресурсов между потоками могут снижать производительность и приводить к ошибкам.

### Синхронизация потоков
- Синхронизация в Java предоставляет механизмы для упорядочивания доступа потоков к общим ресурсам.
- Ключевое слово `synchronized` используется для определения блоков кода или методов, которые должны быть защищены от одновременного доступа нескольких потоков.

#### Методы синхронизации
1. **Модификатор `synchronized` для методов:**
   ```java
   public synchronized void method() {
       // Тело метода
   }
   ```
   Когда поток вызывает синхронизированный метод, он захватывает монитор объекта (или класса, если метод статический).

2. **Синхронизированный блок внутри методов:**
   ```java
   public void method() {
       synchronized(this) {
           // Тело синхронизированного блока
       }
   }
   ```
   Синхронизированный блок позволяет уточнить объект, монитор которого будет использован для блокировки.

### Примеры синхронизации
#### Проблема синхронизации счётчика
- Рассмотрим проблему, когда несколько потоков инкрементируют одну и ту же переменную. Без синхронизации конечное значение переменной будет непредсказуемым из-за race conditions.

#### Синхронизация с использованием `synchronized`
- Добавление `synchronized` к методу `increaseCounter` гарантирует, что каждый поток будет увеличивать счетчик последовательно, обеспечивая правильный итоговый результат.


### Избегание блокировок (Deadlocks)
- Важно проектировать многопоточные приложения таким образом, чтобы избежать взаимных блокировок, когда два или более потоков ждут ресурсы, захваченные друг другом, создавая тем самым состояние вечного ожидания.

### Рекомендации по синхронизации
- Используйте синхронизацию экономно, чтобы не снизить производительность приложения.
- При проектировании многопоточных приложений всегда учитывайте возможность возникновения состояний гонки, взаимных блокировок и других проблем многопоточности.
- Изучайте и используйте высокоуровневые абстракции и утилиты для многопоточности из пакета `java.util.concurrent`, которые могут помочь упростить разработку многопоточных приложений и сделать ее более надежной.