package lesson_12.code.regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceExample1 {
    public static void main(String[] args) {
        String regex = "dog";
        String inputString = "The dog says meow." + " All dogs say meow!";

        System.out.println(inputString);

        String replaceString= "cat";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputString);

        String outputString = matcher.replaceAll(replaceString);
        System.out.println(outputString);


    }
}
