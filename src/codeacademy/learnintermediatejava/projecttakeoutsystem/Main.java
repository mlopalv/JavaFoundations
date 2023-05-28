package codeacademy.learnintermediatejava.projecttakeoutsystem;

import java.util.Scanner;

public class Main {
	
	 public static void main(String[] args) {
		    
		 	String customerName = null;
		    int initialAmountOfMoney = 0;
		 	Scanner input = new Scanner(System.in);
		    Customer customer = null;
		 	TakeOutSimulator takeOutSimulator = null;
		    
		 	System.out.println("Hello! please enter your name: ");
		    customerName = input.next();
		    
		    System.out.println("Please enter your initial amount of money: ");
		    initialAmountOfMoney = input.nextInt();
		    
		    customer = new Customer(customerName, initialAmountOfMoney);
		    System.out.println("This is the initial amonut of money for you: "+customer.getMoney());
		        
		    takeOutSimulator = new TakeOutSimulator(customer, input);
		    
		    takeOutSimulator.startTakeOutSimulator();	    

	 }    

}
