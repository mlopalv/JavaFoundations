package codeacademy.learnintermediatejava.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Example1 {

    public Example1() {}

        public static void main(String[] args) {
            Pattern pattern = Pattern.compile("nap time", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher("Every morning starts with some nap time!");

            String result = matcher.replaceAll("Codecademy");

            System.out.println("Result --> "+result);

        }
}

