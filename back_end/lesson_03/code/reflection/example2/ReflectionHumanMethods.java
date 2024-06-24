package code.reflection.example2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionHumanMethods {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        //------ вариант первый - через сам класс (код класса) ------

        Class<Human> humanClass = Human.class;

        Method[] methodsAnotherSource = humanClass.getDeclaredMethods();

        ////// -------- второй вариант - через экземпляр класса -----

        Human john = new Human("John", "London");

        System.out.println(john);

        Method[] methods = john.getClass().getDeclaredMethods();

        for (Method method : methods){
            System.out.println(method);

            if (method.getName().contains("Secret")){
                System.out.println("Find private method!");
                method.setAccessible(true);
                int secretCode = (int) method.invoke(john,"Our method was broken");
                System.out.println(secretCode);
            }

        }

    }
}
