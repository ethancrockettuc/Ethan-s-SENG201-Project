public class Item {
	public String itemName;
	public String itemAttribute;
	public int attributeIncrease;
	public int itemCost;
	
	public Item(String attribute, int increase, int cost) {
		itemAttribute = attribute;
		attributeIncrease = increase;
		itemCost = cost;
	}
	
	public void useItem(Athlete userAthlete) {
		int skillBeforeUpgrade = userAthlete.athleteSkill;
		userAthlete.athleteSkill += attributeIncrease;
		System.out.println(userAthlete.athleteName + "'s " + itemAttribute + " has been increased by " + attributeIncrease + " from " + skillBeforeUpgrade + " to " + userAthlete.athleteSkill + ".");
	}
	
	
	public Item getItemByName(String userInputItem) {
	    for (Item userItem : userInventory.itemsOwned) {
	        if (userItem.itemName.equals(userInputItem)) {
	            return userItem;
	        }
	    }
	    System.out.println(" No Item with the name: "+ userInputItem " !"); // Only happens if userInputItem not matched with Item name in Inventory.
		
		
	}
}	


