package codeacademy.learnintermediatejava.projecttakeoutsystem;

import java.util.Scanner;

//Create TakeOutSimulator class here

public class TakeOutSimulator {
	private Customer customer;
	private FoodMenu menu;
	private Scanner input;

	public TakeOutSimulator(Customer customer, Scanner scanner) {
		this.customer = customer;
		this.input = scanner;
		this.menu = new FoodMenu();

	}
	
	/**
	 * This is an example of a generic method implementation.  This will be called from several parts of this code and will use
	 * several types of return types according to the scenario.
	 * 
	 * 
	 * @param <T>
	 * @param userInputPrompt
	 * @param intUserInputRetriever
	 * @return
	 */
	public <T> T getOutputOnIntInput(String userInputPrompt, IntUserInputRetriever<T> intUserInputRetriever) {
		T output = null;
		boolean continueLoop = true;
		
		while (continueLoop) {
			System.out.println(userInputPrompt);

			try {

				if (input.hasNextInt()) {
					Integer userInput = input.nextInt();
					/**
					 * This is the point where the unique method of this interface is executed.  Note that this method receives an IntUserInputRetriever
					 * as parameter.  The implementation of produceOutPutOnIntUserInput as been defined previously as a lambda implementation
					 * 
					 * The output variable is of type 'T' which will depend on the type defined for IntUserInputRetriever
					 */
					output = intUserInputRetriever.produceOutputOnIntUserInput(userInput);
					//Once we have a valid output we can break the while loop.
					continueLoop = false;

				} else {
					System.out.print("The option selected has to be a number. Please try again.");
					input.next();
				}
			} catch (IllegalArgumentException e) {
				System.out.println(
						"The option selected is not valid. Please try again.");
			}
		
		}

		return output;

	}
	
	/*
	 * This method will indicate if the amount of money the customer has if greater than the lowest cost food we have in the menu.
	 * If the amount of money is lower than that, then simulation will be stopped.
	 * 
	 * Also, if the user has enough money and wants to continue with the simulation, it allows him to enter the option to continue.
	 * 
	 */
	public boolean shouldSimulate() {
		String userPrompt = "Please enter 1 to proceed with simulation or 0 to not proceed with simulation.";

		IntUserInputRetriever<Boolean> intUserInputRetriever = (i) -> {
			
			boolean proceedAndHaveEnoughMoney = false;
			
			if (i == 1 && (customer.getMoney() > menu.getLowestCostFood().getPrice())) {
				System.out.println("We can continue 'ProceedAndHaveEnoughMoney = true'");
				proceedAndHaveEnoughMoney = true;

			} else if (i == 1 || (customer.getMoney() < menu.getLowestCostFood().getPrice())) {
				System.out.println("We can't continue with the simulation as your amount of money can't afford the lowest cost foor in our restaurant.\n"
						+ "We are so sorry for that but hope to see you soon again with us. 'ProceedAndHaveEnoughMoney = false'");
				proceedAndHaveEnoughMoney = false;
			}
			return proceedAndHaveEnoughMoney;
		};

		return getOutputOnIntInput(userPrompt, intUserInputRetriever);

	}

	/**
	 * This method contains another implementation of produceOutputOnIntUserInput from interface IntUserInputRetriever.
	 * In this case it is an implementation of type Food.  
	 * 
	 * The implementation will return the foodItem selected by the customer in the menu.
	 * 
	 * 
	 * @return
	 */
	public Food getMenuSelection() {
		String userPrompt = "Choose a menu item!";

		IntUserInputRetriever<Food> intUserInputRetriever = (i) -> {
			Food foodItem = menu.getFood(i);

			if (foodItem == null) {
				System.out.println("The food selected is null. Throwing new exception.");
				throw new IllegalArgumentException();
			}
			return foodItem;
		};

		return getOutputOnIntInput(userPrompt, intUserInputRetriever);

	}
	
	/**
	 * This method contains another implementation of produceOutputOnIntUserInput from interface IntUserInputRetriever.
	 * In this case it is an implementation of type Boolean.  
	 * 
	 * The implementation will return the true if the user wants to continue shopping or false if the customer wants to checkout.
	 * 
	 * 
	 * @return
	 */
	public boolean isStillOrderingFood(){
	   
		String userPrompt = "Please enter (1) to continue shopping or (0) to checkout.";
	    

	    IntUserInputRetriever<Boolean> intUserInputRetriever = (selection) -> {
	      boolean continueShopping = false;
				if (selection == 1) {
					continueShopping = true;
					
				}else if(selection == 0){
					continueShopping = false;
	      }else{
	        throw new IllegalArgumentException();
	      }
				return continueShopping;
			};
	    return getOutputOnIntInput(userPrompt, intUserInputRetriever);
	  }

	public void checkoutCustomer(ShoppingBag<Food> shoppingBag) {
		//int remainingMoneyForCustomer = customer.getMoney() - shoppingBag.getTotalPrice();
		
		//customer.setMoney(remainingMoneyForCustomer);
		
		System.out.println("Your payment is being processed ... ");
		System.out.println("Your remaining money is: " + customer.getMoney());
		
		System.out.println("Enjoy your meal! ");

	}
	
	
	public void takeOutPrompt() {
		
		ShoppingBag<Food> shoppingBag = new ShoppingBag<>();
		int customerMoneyLeft = 0;
		Food foodItem = null;
		boolean continueLoop = true;
		
		
		while(continueLoop) {
			
			System.out.println("This is your updated balance: " + customer.getMoney());
			System.out.println(this.menu);
				
			foodItem = getMenuSelection();
			
			if(foodItem.getPrice() < customer.getMoney()) {				
				
				shoppingBag.addItem(foodItem);
				customerMoneyLeft = customer.getMoney() - foodItem.getPrice();
				customer.setMoney(customerMoneyLeft);				
			
			}else {
				
				System.out.println("Oops! Looks like you don't have enough for that. Choose another item or checkout.");
				if (!isStillOrderingFood())
					continueLoop = false;
				
			}			
			
		}
		
		checkoutCustomer(shoppingBag);		
		
	}
	
	public void startTakeOutSimulator() {
		
		System.out.println("Welcome to this great restaurant!");		
		while(shouldSimulate()) {
			System.out.println("Hello "+ customer.getName());
			takeOutPrompt();
						
		}		
	}
	
	
	
	
	
	

}