package codeacademy.learnintermediatejava.lambdas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 
 * Lambda Expressions were added in Java 8.
 * A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, 
 * but they do not need a name and they can be implemented right in the body of a method.
 * 
 * Expressions are limited. They have to immediately return a value, and they cannot contain variables, 
 * assignments or statements such as if or for. In order to do more complex operations, a code block can be used with 
 * curly braces. If the lambda expression needs to return a value, then the code block should have a return statement.
 * 
 * (parameter1, parameter2) -> { code block }
 * 
 * @author MAURICIO
 *
 */

public class TestLambdas {
	
	public static void main(String[] args) {
		// Use a lambda expression in the ArrayList's forEach() method to print every item in the list
		System.out.println("");
	    System.out.println("<<---- Testing lambda being passed completely as an argument for a method ---->>:");
		
	    ArrayList<Integer> numbers = new ArrayList<Integer>();
		
	    numbers.add(5);
		numbers.add(9);
		numbers.add(8);
		numbers.add(1);
		
		numbers.forEach( (n) -> { 
									System.out.println("This is the number: "+n); 
								} 
		);
		
		/**
		 * Lambda expressions can be stored in variables if the variable's type is an interface which has only one method. 
		 * The lambda expression should have the same number of parameters and the same return type as that method. 
		 * Java has many of these kinds of interfaces built in, such as the Consumer interface (found in the java.util package) 
		 * used by lists.
		 * 
		 */
		System.out.println("");
	    System.out.println("<<---- Testing lambda expression stored in a variable ---->>:");
		
	    ArrayList<Integer> numbers2 = new ArrayList<Integer>();
	    
		numbers2.add(6);
	    numbers2.add(10);
	    numbers2.add(9);
	    numbers2.add(2);
	    
	    // The method forEach of the ArrayLyst class, receives a Consumer type object.
	    // That's why when we define the method with the variable Lambda
	    // The important thing here is to understand that the consumer Interface has a method called "accept".
	    // So, the implementation of lambda is really implementing the "accept" method of the
	    // Consumer interface. The parameter being sent in this lambda is n, which is of type T, in this case an Integer.
	    // This is the signature of "accept" method in the interface Consumer: "void accept(T t)"
	    
	    System.out.println("");
	    Consumer<Integer> method = (n) -> { 
	    									System.out.println("<<---- This is one method implemented as lambda for the"
	    											+ " 'Consumer' interface' and the 'accept' method: " + n + " ---->"); 
	    									
	    								};
	    
	    Consumer<Integer> method2 = (n) -> { 
	    									System.out.println("<---- Hello this is just another method implemented as lambda for the"
	    											+ "same 'Consumer' interface and 'accept' method: " + n + " ---->>"); 
	    									
	    								};
	    //This is a test showing that the method "accept" perform the operation that is instructed to on the given argument.
	    method.accept(numbers2.get(0));
	    
	    numbers2.forEach( method );
	    
	    numbers2.forEach( method2 );
	    
	    	        
	    /*
	     * To use a lambda expression in a method, the method should have a parameter with a single-method interface as its type. 
	     * Calling the interface's method will run the lambda expression: 
	     */
	    System.out.println("");
	    System.out.println("<<---- Testing lambdas used in a method when the interface has one single method ---->>:");
	    
	    //String function is the interface with the single method (This is what is called a Functional Interface)
	    //we can equal "exclaim" and "ask" to the lambda function because the interpreter looks for its type to be an interface
	    StringFunction exclaim = (String s) -> s + "!";
	    StringFunction ask = (String s) -> s + "?";
	    
	    //Then we can call the static method TestLambdas to execute the 
	    System.out.println(exclaim.run("Hello"));
	    System.out.println(ask.run("Hello"));
	    
	       
	   Predicate<String> s = (String prefix) -> "A".startsWith(prefix);
	   
	
	}
	


}
