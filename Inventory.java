import java.util.ArrayList;


public class Inventory {
	private ArrayList<Item> itemsOwned = new ArrayList<Item>();
	private int currentMoney;
	
	public int getCurrentMoney() {
		return currentMoney;
	}
	public void setCurrentMoney(int inputMoney) {
			this.currentMoney = inputMoney;
		}
	public void addItem(Item marketItem) {
		itemsOwned.add(marketItem);
	}
	
	public void removeItem(Item marketItem) {
		itemsOwned.remove(marketItem);
	}
	public ArrayList<Item> getItemsOwned() {
		return itemsOwned;
	}
	public void displayItemsOwned(ArrayList<Item> itemsOwned) {
		for(Item userItem : itemsOwned) {
			System.out.println("The name of the item is " + userItem.getItemName() + "and the item effects are " + userItem.getItemEffects());
		}
	}
	public void useItem(Athlete userAthlete, Item userItem) {
		int skillBeforeUpgrade = userAthlete.getAthleteSkill();
		userAthlete.setAthleteSkill(skillBeforeUpgrade + userItem.getAttributeIncrease());
		System.out.println(userAthlete.getAthleteName() + "'s " + userItem.getItemAttribute() + " has been increased by " + userItem.getAttributeIncrease() + " from " + skillBeforeUpgrade + " to " + userAthlete.getAthleteSkill() + ".");
	}
	
	
	/*
	//This method gets the name of item, from inventory. not sure if necessary. 
	public Item getItemByName(String userInputItem, Inventory userInventory) {
	    for (Item userItem : userInventory.getItemsOwned()) {
	        if (userItem.ItemName().equals(userInputItem)) {
	            return userItem;
	        }
	    }
	    System.out.println("No item with the name: " + userInputItem + " found in the inventory.");
	    return null; // Return null if item is not found
	}	
	*/
	
}
