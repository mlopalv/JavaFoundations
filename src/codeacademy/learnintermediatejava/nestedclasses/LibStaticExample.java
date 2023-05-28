package codeacademy.learnintermediatejava.nestedclasses;

class LibStaticExample { 
	  String objType;
	  String objName;
	  static String libLocation = "Midfield St.";

	  public LibStaticExample(String type, String name) {
	    this.objType = type;
	    this.objName = name;
	  }

	  private String getObjName() {
	    return this.objName;
	  }

	  // inner class
	  static class Book {
	    String description;

	    public static void printLibraryLocation(){
	      System.out.println("Library location: "+libLocation);

	    }
	 
	  }
	}

	