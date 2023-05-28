package codeacademy.learnintermediatejava.junit;

public class Factorial {

    public int calculateFactorial(int n) {
        int factorial=1;
        // Magic code
        for(int z=1; z<n; z++){

            factorial = factorial * (z + 1);
        }
        System.out.println("Resultado factorial ->"+factorial);
        return factorial;
    }

    public static void main(String[] args){

        Factorial factorial = new Factorial();
        factorial.calculateFactorial(1);

    }
}
