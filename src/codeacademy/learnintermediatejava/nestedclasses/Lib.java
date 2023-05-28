package codeacademy.learnintermediatejava.nestedclasses;
/**
 * This is an example of a class having a non-static nested class inside
 * 
 * @author MAURICIO
 *
 */
class Lib {

	String objType;
	String objName;

	// Assign values using constructor
	public Lib(String type, String name) {
		this.objType = type;
		this.objName = name;
	}

	// private method
	private String getObjName() {
		return this.objName;
	}

	/*
	 * This is an example of a nested class named Book
	 * 
	 */
	class Book {

		String description;

		void setDescription() {

			if (Lib.this.objType.equals("book")) {

				if (Lib.this.getObjName().equals("nonfiction")) {

					this.description = "Factual stories/accounts based on true events.";

				} else {

					this.description = "Literature that is imaginary.";
				}

			} else {

				this.description = "Not a book!";

			}
		}

		String getDescription() {
			return this.description;
		}
	}
}
