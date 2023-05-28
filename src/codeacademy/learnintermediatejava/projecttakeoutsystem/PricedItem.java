package codeacademy.learnintermediatejava.projecttakeoutsystem;

//Create PricedItem interface here
import java.lang.Number;


/**
* The type "T" that incoming as a parameter for this interface
* definition has an upper bounded limit that is "java.lang.Number"
* This means, the specific type that will define this inteface
* will need to be s subtype of the parent class "java.lang.Number"
*/

public interface PricedItem <T extends Number>{

public T getPrice();
public void setPrice(T price);
}