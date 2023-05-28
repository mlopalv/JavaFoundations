package codeacademy.learnintermediatejava.projecttakeoutsystem;

import java.util.ArrayList;
import java.util.List;

// Create FoodMenu class here
public class FoodMenu{
  
	private List<Food> menu;

  public FoodMenu(){
    Food milk = new Food("Milk", "Whole milk", 5000);
    Food cereal = new Food("Cereal", "Whole cereal", 18000);
    Food beans = new Food("Beans", "Colombian beans", 12000);
    menu = new ArrayList<>();
    menu.add(milk);
    menu.add(cereal);
    menu.add(beans);


  }

  public String toString(){
    int menuIndex = 1;
    String menuToString = new String();
    
    for(Food food : menu) {
      menuToString = menuToString + menuIndex + ". "+food.toString();      
      menuIndex+=1;
      menuToString = menuToString + "\n";
    }

    return menuToString;
  }

  public Food getFood(int index){
    Food selectedFood = null;
    
    try{
        selectedFood = menu.get(index-1);
    
    }catch(IndexOutOfBoundsException e){
      System.out.println("The selected index is not available");
    }
    
    return selectedFood;
  }

  public Food getLowestCostFood(){
      int minPriceItem = 0;
      Food lowestCostFood = null;
      for(Food food: menu){
        
        if(minPriceItem == 0 || food.getPrice() < minPriceItem){
          minPriceItem = food.getPrice();
          lowestCostFood = food;
        }
      }

      return lowestCostFood;
  }

  


}
