package codeacademy.learnintermediatejava.nestedclasses;

public class Main {
	public static void main(String[] args) {
		/* Creating an instance of a fiction Book */
		Lib fiction = new Lib("book", "fiction");

		// In this way we can instantiate the nested class Book that is inside Lib
		Lib.Book book = fiction.new Book();

		book.setDescription();
		System.out.println("Fiction Book Description = " + book.getDescription());

		/* Creating an instance of a non-fiction Book */
		Lib nonFiction = new Lib("book", "nonfiction");

		// In this way we can instantiate the nested class Book that is inside Lib
		Lib.Book bookNonFiction = nonFiction.new Book();

		bookNonFiction.setDescription();
		System.out.println("Non-fiction Book Description = " + bookNonFiction.getDescription());

		/****
		 * Now we'll use a static nested class as example
		 * 
		 */
		LibStaticExample.Book bookStatic = new LibStaticExample.Book();
		bookStatic.printLibraryLocation();
		// However, this will do exactly the same but we wouln't be using the static nested class
		System.out.println(LibStaticExample.libLocation);
		

	}
}
