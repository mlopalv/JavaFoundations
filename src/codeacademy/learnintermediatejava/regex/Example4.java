package codeacademy.learnintermediatejava.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Example4 {
    public Example4() {}

    public static void main(String[] args) {

        //Patron "Alternation" -> Match one or the other. Example: ab|cd will match ab or cd
        Pattern pattern = Pattern.compile("gray|grey", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Vibrant light bloomed across the gray sky, illuminating its grey haze in flashes amidst rolling hills of wispy gray clouds. Colors of gold, pink, and purple painted the horizon, the dull grey of the sky overtaken by brief moments of a quiet twilight storm.");
        int hitCounter = 0;
        while(matcher.find())
            hitCounter += 1;

        System.out.println(hitCounter);

        String result = matcher.replaceAll("grey");
        System.out.println(result);


    }
}