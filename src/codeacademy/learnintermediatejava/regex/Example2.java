package codeacademy.learnintermediatejava.regex;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Example2 {

    public Example2() {}

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("gr[ae]y", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Vibrant light bloomed across the gray sky, illuminating its grey haze in flashes amidst rolling hills of wispy gray clouds. Colors of gold, pink, and purple painted the horizon, the dull grey of the sky overtaken by brief moments of a quiet twilight storm.");

        String result = matcher.replaceAll("gray");
        System.out.println(result);
    }
}