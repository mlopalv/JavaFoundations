package codeacademy.learnintermediatejava.genericmethods;
/*
 * This class show an implementation of generic method that checks if the object coming is a Double.
 * The method signature needs to indicate is having a Object of type T as parameter and also
 * has to specify <T> before the return type.
 */
public class Main {
	  // This generic method will indicate whether the incoming parameter is of type Double
	  public static <T> boolean isDouble(T object){
	    return object instanceof Double;
	  }
	  
	  //This implementation achieves the same results as isDouble
	  public static boolean isDoubleObjImplementation(Object obj) {
		  
		  return obj instanceof Double;
	  }

	  public static void main(String[] args) {
	    String test1 = "Double";
	    double test2 = 5.8;

	    // Enter code below...  
	    boolean isTest1Double = Main.isDouble(test1);
	    boolean isTest2Double = Main.isDouble(test2);
	    
	    System.out.println(isTest1Double);
	    System.out.println(isTest2Double);
	    
	    // Test the other implementation with a regular parameter Object
	    isTest1Double = Main.isDoubleObjImplementation(test1);
	    isTest2Double = Main.isDoubleObjImplementation(test2);
	    
	    System.out.println(isTest1Double);
	    System.out.println(isTest2Double);
	    
	  }
	}