package codeacademy.learnintermediatejava.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Example3 {
    public Example3() {}

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("\n");
        Matcher matcher = pattern.matcher("1\n2\n3\n4\n5\n6\n7\n8\n9\n10");

        int countHits = 0;
        while(matcher.find())
            countHits +=1;

        System.out.println(countHits);

        String arrayString = matcher.replaceAll(",");
        arrayString = "["+arrayString+"]";
        System.out.println(arrayString);

    }
}