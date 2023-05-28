package codeacademy.learnintermediatejava;

import java.io.*;
import java.util.Scanner;

public class Introduction {
  public static void main(String[] args) {
    String name = "Mauricio";
    String hobbies = "Reading, listening to music, going to the movies and scuba diving.";
    int age = 41;
    System.out.println("My name is "+name);
    System.out.printf("I am %d years old. ", age);
    System.out.println("My hobbies are "+hobbies);
    
    System.out.println("Probando con ingreso de información dsde la consola: ");
    //jonsola
    Scanner scanner = new Scanner(System.in);
    System.out.println("What is your name: ");
    String userName = scanner.next();
    System.out.printf("Hello %s It's nice to meet you.", userName);
  }
}
