package codeacademy.learnintermediatejava.projecttakeoutsystem;

import java.util.HashMap;
import java.util.Map;


public class ShoppingBag<T extends PricedItem<Integer>>{
    private Map<T, Integer> shoppingBag;

    public ShoppingBag(){
      this.shoppingBag = new HashMap<>();
    }

    /*
     * This method adds a new item to the ShoppingBag
     * If the item it's already in the bag, then we count one more and put it as the new count for that item.
     * If the item is not already in the bag, then we just the new item with a count of one (1)
     * 
     */
    public void addItem(T item){
      int countOfPricedItems=0;
      	
      	// If the pricedItem already exists in the bag
    	if(this.shoppingBag.containsKey(item)) {
    		countOfPricedItems = shoppingBag.get(item);
    		this.shoppingBag.put(item, countOfPricedItems+1);
    	
    	}else {
    		this.shoppingBag.put(item, 1);
    	}  	
    	


    }
    
    /**
     * This method iterates over the items of the bag to sum up the total price considering
     * the amount of elements per item.
     * 
     * @return
     */
    	public int getTotalPrice(){
    		int totalPrice = 0;
    		
    		for(T pricedItem:this.shoppingBag.keySet()) {
    			totalPrice =	totalPrice + (pricedItem.getPrice() * shoppingBag.get(pricedItem));
    		}
        
    		return totalPrice;       

      }

}