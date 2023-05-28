package codeacademy.learnintermediatejava.genericclasses;
/*
 * This containers shows an example of a container having multiple types
 * 
 */

public class Container2<T,S> {
	private T item1;
	  private S item2;

	  public Container2(T item1, S item2) {
	    this.item1 = item1;
	    this.item2 = item2;
	  }

	  public T getItem1() {
	    return this.item1;
	  }

	  public S getItem2() {
	    return this.item2;
	  }
	

}
