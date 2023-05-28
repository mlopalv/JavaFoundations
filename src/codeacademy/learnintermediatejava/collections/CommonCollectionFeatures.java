package codeacademy.learnintermediatejava.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author MAURICIO
 *
 * This class shows examples of using common collection features
 */
public class CommonCollectionFeatures {
	
	public static void main(String[] args) {
	    List<Integer> myList = new ArrayList<>();
	    myList.add(3);
	    myList.add(-1);
	    myList.add(57);
	    myList.add(29);

	    Set<String> mySet = new HashSet<>();
	    mySet.add("Hello");
	    mySet.add("World");

	    System.out.println("mySet max: \"" + Collections.max(mySet)+"\"");
	    System.out.println();

	    System.out.println("myList min: " + Collections.min(myList));
	    System.out.println();

	    System.out.println("Index of 57 in myList is: " + Collections.binarySearch(myList, 57));
	    System.out.println();


	    System.out.println("myList prior to reverse: ");
	    printCollection(myList);

	    System.out.println();

	    Collections.reverse(myList);
	    System.out.println("myList reversed: ");
	    printCollection(myList);

	    System.out.println();

	    System.out.println("myList prior to sort: ");
	    printCollection(myList);

	    System.out.println();

	    Collections.sort(myList);
	    System.out.println("myList after sort: ");
	    printCollection(myList);


	  }

	  public static void printCollection(Collection<?> collection){
	    Iterator<?> myItr = collection.iterator();

	    while(myItr.hasNext()){
	      System.out.println(myItr.next());
	    }
	  }

}
