import java.util.ArrayList;


public class Inventory {
	public ArrayList<Item> itemsOwned = new ArrayList<Item>();
	public int currentMoney;
	
	public void checkInventory() {
		System.out.println("Here are the following items you currently own: " + itemsOwned);
		System.out.println("Here is your current balance: " + currentMoney);
	}
	
	public void addItem(Item marketItem) {
		itemsOwned.add(marketItem);
	}
	
	public void removeItem(Item marketItem) {
		itemsOwned.remove(marketItem);
	}

}
