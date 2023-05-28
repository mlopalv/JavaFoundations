package codeacademy.learnintermediatejava.genericclasses;

/* 	T corresponde a una indicación que dice que esta clase es un contenedor para clases de tipo T
 	T puede ser un String, un Integer o cualquier otra clase que se pueda crear
 	Para este ejemeplo se crea la clase Book.java que luego se usa en la clase Main.java
 	Important: this generic data type classes can not use primitive data types. Instead of that, you need to use
 	Wrappers, for example, Integer, String, Double etc.
*/
public class Container<T>{
	  private T data;

	  public Container(T data){
	    this.data = data;
	  }

	  public T getData(){
	    return data;
	  }

	  public void setData(T data){
	    this.data = data;
	  }


}