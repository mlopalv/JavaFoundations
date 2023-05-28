package codeacademy.learnintermediatejava.projecttakeoutsystem;


public class Food implements PricedItem<Integer>{

  private String name;
  private String description;
  private int price;

  public Food(String name, String description, int price){
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public void setPrice(Integer price){
    this.price = price;
  }

  public Integer getPrice(){
    return this.price;
  }

  public String toString(){
    return "Enjoy "+this.name+": "+this.description+". Cost: "+this.price;
  }

}