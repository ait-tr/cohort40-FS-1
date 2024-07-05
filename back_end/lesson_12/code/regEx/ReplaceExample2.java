package lesson_12.code.regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceExample2 {
    public static void main(String[] args) {
        String regex = "Java";

        String inputString = "Hello Java! Hello JavaScript! JavaSE_8";

        System.out.println(inputString);

        String replaceString= "HTML";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputString);

        String outputString = matcher.replaceAll(replaceString);
        System.out.println(outputString);

        //============== 2 вариант =============

        regex = "Java\\w*";
        System.out.println("======================");
        System.out.println(inputString);
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(inputString);

        outputString = matcher.replaceAll(replaceString);
        System.out.println(outputString);


    }
}
