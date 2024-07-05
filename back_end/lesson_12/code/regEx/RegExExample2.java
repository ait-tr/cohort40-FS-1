package lesson_12.code.regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExExample2 {
    public static void main(String[] args) {
        String inputString = "aab aa aabc be aaabbbc aaaaaabh";
        /// -------
        String regex = "a*b";

        // -----

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(inputString);

        int matchCounter = 0;

        while (matcher.find()) {
            matchCounter++;

            System.out.println("'" + inputString.substring(matcher.start(), matcher.end()) + "'");
            System.out.println("Start: " + matcher.start());
            System.out.println("End: " + matcher.end());
            System.out.println("Number of match: " + matchCounter);
        }

    }
}
