package codeacademy.learnintermediatejava.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class MapExample {
	
	public static void main(String[] args) {
	    List<Integer> myInts = new ArrayList<>();
	    Random random = new Random();

	    for(int i =0; i < 20; i++) {
	      myInts.add(random.nextInt(5));
	    }

	    Map<Integer, Integer> intCount = countNumbers(myInts);
	    
	    for(Map.Entry<Integer, Integer> entry: intCount.entrySet()) {
	      System.out.println("Integer: "+ entry.getKey()+" appears: "+ entry.getValue());
	    }
	  }

	/**
	 * This method takes a list of integers and counts its occurrence to put each count occurrence 
	 * as a value of the Map.  The key is the Integer itself
	 *   
	 * @param list
	 * @return
	 */
	public static Map<Integer, Integer> countNumbers(List<Integer> list) {
	      Map<Integer, Integer> intCount = new TreeMap<>();

	      for (Integer i:list) {
	        // Gets the integer i from the list and asks if it is there in the Map
	        Integer currentCount = intCount.get(i);
	        //If the integer is in the Map
	        if(currentCount != null){
	          // Updates the count value of that integer if the integer is already in the Map
	          int newCount = currentCount + 1;
	          intCount.put(i, newCount);
	        }else{ //If the integer is not in the Map
	          //If the integer is not yet in the Map, then it is added and count started in 1
	          intCount.put(i,1);
	        }

	      }
	      return intCount;
	  }

}
