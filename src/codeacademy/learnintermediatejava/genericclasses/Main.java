package codeacademy.learnintermediatejava.genericclasses;

public class Main {
	  
	public static void main(String[] args) {
	
		String myWord = "Hello";
	    Book myBook = new Book("My Book");
	    // Create `Container` references and print statement below...
	    // This first container is based on String class.
	    Container<String> wordContainer = new Container<>(myWord);
	    //This second container class is based on Book class
	    Container<Book> bookContainer = new Container<>(myBook);
	    //In general, I can create containers for each class that I want.

	    System.out.println(wordContainer.getData());
	    System.out.println(bookContainer.getData());
	    
	    // Now let's test out container with multiple types	    
	    Container2<Integer, Double> myContainer = new Container2<>(2, 45.98);
	    
	    System.out.println("Item1: "+ myContainer.getItem1());
	    System.out.println("Item2: "+ myContainer.getItem2());
	  
	}
}