package codeacademy.learnintermediatejava.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void processAlphabetically(Queue<String> queue) {

		Queue<String> alphabeticalQueue = new PriorityQueue<>();

		for (String name : queue) {
			alphabeticalQueue.add(name);
		}
		// It can be seen that the information is polled in alphabetical order as that's
		// the way
		// PriorityQueue is implemented
		while (alphabeticalQueue.peek() != null) {
			String headElement = alphabeticalQueue.poll();
			System.out.println("Processing: " + headElement);
		}

	}
	
	/**
	 * This code shows an implementarion of Deque, that allow to add or poll information from the first element or
	 * last element of the queue.
	 * Deque is another interface that implements from Queue.  It is implemented thru the ArrayDeque concrete class.
	 * 
	 * @param integers
	 * @return
	 */
	public static Deque<Integer> separateInts(List<Integer> integers) {
		Deque<Integer> separatedDeque = new ArrayDeque<>();

		for (Integer myInt : integers) {
			if (myInt % 2 == 0) {
				separatedDeque.offerFirst(myInt);
			} else {
				separatedDeque.offerLast(myInt);
			}
		}
		return separatedDeque;
	}

	public static void main(String[] args) {

		/*
		 * A List is a collection where its elements are ordered in a sequence. Lists
		 * allow us to have duplicate elements and fine-grain control over where
		 * elements are inserted in the sequence. Like arrays, the position of a List is
		 * known as the index and is 0 based. Unlike arrays, which have a static size,
		 * Lists are dynamically sized. The ArrayList is the overall preferred
		 * implementation for most use cases but the LinkedList performs better than an
		 * ArrayList if your program mostly inserts and deletes elements.
		 */
		List<String> stringList = new ArrayList<>();
		System.out.println("--ArrayList implementation of List--");
		stringList.add("Hello ");
		stringList.add("World ");
		stringList.add("!");

		for (String element : stringList) {
			System.out.print(element);
		}
		System.out.println("");
		System.out.println("--TreeSet implementation of Set--");
		/*
		 * Another core interface provided by the collection framework is the Set
		 * interface. A Set is a collection of unique elements and all of its methods
		 * ensure this stays true. The collection framework provides different
		 * implementations of a Set (we’ll focus on a subset of them) that each have
		 * different use cases.
		 *
		 * The HashSet implementation has the best performance when retrieving or
		 * inserting elements but cannot guarantee any ordering among them.
		 *
		 * The TreeSet implementation does not perform as well on insertion and deletion
		 * of elements but does keep the elements stored in order based on their values
		 * (this can be customized).
		 *
		 * The LinkedHashSet implementation has a slightly slower performance on
		 * insertion and deletion of elements than a HashSet but keeps elements in
		 * insertion order.
		 */

		Set<String> stringSet = new TreeSet<>();
		stringSet.add("Hello ");
		stringSet.add("World ");
		// In this case we can see TreeSet doesn't allow to include duplicates. Tha's
		// why adding this "Hello" at the end
		// won't take any effect on the TreeSet.
		stringSet.add("Hello ");

		for (String element : stringSet) {
			System.out.print(element);
		}

		/*
		 * The Queue core interface in the collection framework, is a collection that
		 * stores elements that can be accessed at some later point to process (like
		 * waiting in line at the bank teller). A Queue accesses elements in a (usually)
		 * First In First Out (FIFO) manner where elements are inserted at the tail
		 * (back) of the collection and removed from the head (front).
		 * 
		 * A Queue has two types of access methods for inserting, removing, and getting
		 * but not removing the head of the Queue.
		 * 
		 * The following methods throw an exception when:
		 * 
		 * - add() - there is no space for the element - remove() - there are no
		 * elements to remove - element() - there are no elements to get - The following
		 * methods return a special value:
		 * 
		 * - offer() - false there is no space for the element - poll() - null there are
		 * no elements to remove - peek() - null there are no elements to get - The
		 * methods that return a special value should be used when working with a
		 * statically sized Queue and the exception throwing methods when using a
		 * dynamic Queue.
		 * 
		 * - Like the other collection framework interfaces, Queue has many
		 * implementations. We’ll focus on LinkedList and PriorityQueue. We’ve seen
		 * LinkedList be used as a List implementation and it’s also perfect when
		 * needing a basic Queue implementation. Being able to use a LinkedList as both
		 * a List and Queue implementation is a perfect example of the compatibility
		 * within the collection framework. The PriorityQueue ensures the top element is
		 * the smallest relative to the data type’s natural ordering (or some custom
		 * comparison algorithm you provide).
		 * 
		 */
		Queue<String> line = new LinkedList<>();
		line.add("Mike");
		line.add("Isabel");
		line.add("Jenny");

		for (String name : line) {
			System.out.println(name);
		}
		// Processing the same information with an implementation
		// of PriorityQueue, which stores the elements in order
		processAlphabetically(line);
		
		/**
		* 	The last of the core interfaces in the collection framework is the Deque interface (pronounced “Deck”). A Deque is a 
		* 	collection that allows us to manipulate elements from both the front and end of the collection.
		* 	The Deque interface has two types of methods for manipulating the front and back of the collection.
		*	
		*	The following methods throw an exception when:
		*
		*	-	addFirst(), addLast() - there is no space to add an element.
		*	-	removeFirst(), removeLast() - there is no element to remove.
		*	-	getFirst(), getLast() - there is no element to get.
		*	-	The following methods return a special value:
		*
		*	-	offerFirst(), offerLast() - false when there is no space to add an element.
		*	-	pollFirst(), pollLast() - null when there is no element to remove.
		*	-	peekFirst(), peekLast() - null when there is no element to get.
		*	A Deque has many implementations and we’ll focus on the LinkedList and ArrayDeque implementations. 
		*	The LinkedList, although not the most optimized, is flexible enough to not only be used as a List and Queue but also a 
		*	Deque. The ArrayDeque is the preferred implementation when needing to manipulate elements at the front and end of a 
		*	collection.
		* 
		*/
		List<Integer> myInts = new ArrayList<>();
	    myInts.add(9);
	    myInts.add(13);
	    myInts.add(2);
	    myInts.add(1);
	    myInts.add(11);
	    myInts.add(39);
	    myInts.add(78);
	    myInts.add(4);
	    
	    //Let's call the implementation of Deque to add even or not even numbers to an Deque implementation
	    System.out.println("--ArrayDeque implementation of Deque showing even numbers at the beginning of the queue (deque) and"
	    		+ "non even numbers to the last part of the queue (deque)--");
	    Deque<Integer> result = separateInts(myInts);
	    for(Integer i: result) {
	      System.out.println(i);
	    }

	}

}
