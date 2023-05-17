
/* Update on 18/05: 
 * can we use toString() method for each loop in checkAvailablePlayers method
 * Potential issues: 
 * - 
 */
import java.util.HashMap;

public class Market implements PurchaseOrSell {
	//set public at the moment, no encapsulation has been done as only once instance created. This instance will be updated, by reassigning values. 
	public HashMap<String, Athlete> availableAthletes;
	public HashMap<String, Item> availableItems;
	
	//AthleteGenerator Class called in GameEnvironment
	
	//Constructor method for Market Class
	public Market() {
		this.availableAthletes = new HashMap<String, Athlete>();	
		this.availableItems = new HashMap<String, Item>();
	}
	
	
	//Method for finding Athlete names in hashmap different, since it's all stored in AthleteGenerator List. 
	public void checkAvailablePlayers() {
		//The hash-map stores a string for athlete name, and athlete class for value. 
		//Using the .get() method to index the hash-map key-value pairing.
	    for(String marketAthleteName: availableAthletes.keySet()) {
	        
	    	//Approach #1
	    	//System.out.println("Athlete name: " + availableAthletes.get(marketAthleteName).athleteName);
	        //System.out.println("Position: " + availableAthletes.get(marketAthleteName).athletePosition);
	        //System.out.println("Stamina: " + Integer.toString(availableAthletes.get(marketAthleteName).athleteStamina));
	        //System.out.println("Play: " + Boolean.toString(availableAthletes.get(marketAthleteName).athleteInjured));
	        //System.out.println("Cost: " + Integer.toString(availableAthletes.get(marketAthleteName).athleteCost));
	        //System.out.println("Sale price: " + Integer.toString(availableAthletes.get(marketAthleteName).athleteSalePrice));
	    	
	    	
	    	//Approach #2 using the toString()  method, outlined in Athlete Class.
	    	Athlete marketAthlete = availableAthletes.get(marketAthleteName);
	        System.out.println(marketAthlete.toString());
	        System.out.println("--------------------------------------------------------");
	    }
	    
	}	
	
	//Integer.toString() used for attributes of Item that are not String
	public void checkAvailableItems() {
		for(String marketItemName: availableItems.keySet()) {
	        System.out.println("Item name: " + availableItems.get(marketItemName).itemName);
	        System.out.println("Item attribute: " + availableItems.get(marketItemName).itemAttribute);
	        System.out.println("Item attribute increase: " + Integer.toString(availableItems.get(marketItemName).attributeIncrease));
	        System.out.println("Item cost: " + Integer.toString(availableItems.get(marketItemName).itemCost)); 
	        }
	}
	//Getters & Setter needed for marketItem, since the user inputs the String not class Item. 
	//This will influence how the rest of the method works.
	public void purchaseItem(Inventory userInventory, Item marketItem){ 
		if (userInventory.getCurrentMoney() >= availableItems.get(marketItem).itemCost && userInventory.getItemsOwned().size() < 5) {
			userInventory.addItem(marketItem);
			System.out.println("Booster Item " + marketItem.itemName + " has been purchased.");
			//we do not remove item from the market
		}
		else {
			System.out.println("You do not have enough money!");
		}
		
	} 
	//If user has enough money, athlete is added into users reserve team, and athlete is removed from market availableAthletes hashmap.
	//Getters & Setter needed for marketAthlete, since the user inputs the String not class Item.
	
	
	//This is only for the first time in the GameEnvironment, specifically for purchasing athletes onto the active team.
	public Boolean purchaseAthleteForFirstTime(Inventory userInventory, String marketAthleteName, Team userTeam, Market userMarket) {
//-----------------------------------BUG----------------------------------------------------------
		Athlete marketAthlete = new Athlete();
				marketAthlete = marketAthlete.getMarketAthleteByName(marketAthleteName, userMarket); //Using the Getter method
//----------------------------------BUG----------------------------------------------------------
		if (userInventory.getCurrentMoney() >= marketAthlete.getAthleteContractPrice() && userTeam.getActiveTeamRoster().size() <10 ) {
			System.out.println(marketAthleteName + " purchased and added to active team.");
			userTeam.getActiveTeamRoster().add(marketAthlete);
			//Remove Athlete from Market
			availableAthletes.remove(marketAthleteName);
			return true;
		}
		else {
			System.out.println("Cannot purchase athlete: " + marketAthlete.getAthleteName()); 
			return false;
		}
		
	}
	
	
	
	public Boolean purchaseAthlete(Inventory userInventory, String marketAthleteName, Team userTeam) {
		Athlete marketAthlete = getAthleteByName(marketAthleteName, userTeam); //Using the Getter method
		System.out.println("Looking at the marketAthlete variable: " + marketAthlete); //BUG
		System.out.println("printing out marketAthlete Name: " + marketAthlete.getAthleteName()); //BUG
		if (userInventory.getCurrentMoney() >= marketAthlete.getAthleteContractPrice() && userTeam.getReserveTeamRoster().size() <5 ) {
			System.out.println(marketAthleteName + " purchased and added to reserve team.");
			userTeam.getReserveTeamRoster().add(marketAthlete);
			//Remove Athlete from Market
			availableAthletes.remove(marketAthleteName);
			return true;
		}
		else {
			System.out.println("Cannot purchase athlete: " + marketAthlete.getAthleteName()); 
			return false;
		}
		
	}
	//Getters & Setter needed for userAthlete, since the user inputs the String not class Item.
	public void sellAthlete(Inventory userInventory, String userInputAthleteName, Team userTeam) { //Inputting Athlete's name, but might need athlete's other attributes
		Athlete sellingAthlete = new Athlete(); 
		Athlete userAthlete = sellingAthlete.getAthleteByName(userInputAthleteName, userTeam); //Getter method from Athlete Class
		userInventory.currentMoney = userInventory.currentMoney + userAthlete.athleteSalePrice;
		
		if (userTeam.reserveTeamRoster.contains(userInputAthleteName)) {
			userTeam.reserveTeamRoster.remove(userInputAthleteName);
			System.out.println(userInputAthleteName + " has been removed from the reserve team roster. Great choice lol.");
			userMarket.availableAthletes.put(userAthlete.athleteName, userAthlete.athleteSalePrice*2); //Update the market by moving sold athlete into market
		}
		else() {
			System.out.println(userAthleteName + " does not exist!");
		}
		
	}
	//Getters & Setter needed for UserItem, since the user inputs the String not class Item.
	//Check Inventory method has removeItem method
	public void sellItem(Inventory userInventory, String userInputItemName) {
		Item userItem = getItemByName(userInputItemName);
		userInventory.currentMoney += userItem.itemCost;
		userInventory.itemsOwned.removeItem(userItem);
		//We refresh the Items every week. So we don't put the sold item back into the market
	}	
}


