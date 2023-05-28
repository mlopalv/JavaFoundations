package codeacademy.learnintermediatejava.collections;

import java.util.HashSet;
import java.util.Iterator;

public class UniqueNames {
	
	
	public String[] uniqueNames(String namesA[], String namesB[]) {
		
		HashSet<String> uniqueNamesSet = new HashSet<String>();
		String[] uniqueNamesArray = null;
		
		for (String s: namesA)
			uniqueNamesSet.add(s);
		
		for (String s: namesB)
			uniqueNamesSet.add(s);
		
		
		Iterator<String> uniqueNamesSetIterator = uniqueNamesSet.iterator();
		uniqueNamesArray = new String[uniqueNamesSet.size()];
		int z=0;
		
		while(uniqueNamesSetIterator.hasNext()) {			
			uniqueNamesArray[z] = uniqueNamesSetIterator.next();			
			z+=1;
		}			
		
		return uniqueNamesArray;
	}
	
	public String[] uniqueNamesToArray(String namesA[], String namesB[]) {
		
		HashSet<String> uniqueNamesSet = new HashSet<String>();
		String[] uniqueNamesArrayString = null;
				
		for (String s: namesA)
			uniqueNamesSet.add(s);
		
		for (String s: namesB)
			uniqueNamesSet.add(s);
		
		/**
		 * <A> A[] toArray(IntFunction<A[]> generator)
		 * Returns an array containing the elements of this stream, using the provided generator function to allocate the returned array, 
		 * as well as any additional arrays that might be required for a partitioned execution or for resizing.
		 * 
		 * This is a terminal operation.
		 * 
		 * API Note:
		 * The generator function takes an integer, which is the size of the desired array, and produces an array of the desired size. 
		 * This can be concisely expressed with an array constructor reference:
		 * 
		 * Person[] men = people.stream()
		 *                         .filter(p -> p.getGender() == MALE)
		 *                         .toArray(Person[]::new);
		 *
		 *
		 */
		//Apply the toArray(IntFunction<A> generator) method with an array constructor reference
		uniqueNamesArrayString = uniqueNamesSet.stream().toArray(String[]::new);
	
		
		return uniqueNamesArrayString;
	}
	
	
	
	
	public static void main(String args[]) {
		
		String namesA[] = new String[4];
		namesA[0] = "Antonia";
		namesA[1] = "Clara";
		namesA[2] = "Paula";
		namesA[3] = "Sandra";
		
		String namesB[] = new String[4];
		namesB[0] = "Maria";
		namesB[1] = "Fernanda";
		namesB[2] = "Clara";
		namesB[3] = "Antonia";
		
		UniqueNames uniqueNames = new UniqueNames();
		String[] uniqueNamesArray = uniqueNames.uniqueNamesToArray(namesA, namesB);
		
		for(String s: uniqueNamesArray) {
			System.out.println(s);
			
		}
		
	}

}
