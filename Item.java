public class Item {
	private String itemName;
	private String itemAttribute;
	private int attributeIncrease;
	private int itemCost;
	
	public Item(String attribute, int increase, int cost) {
		itemAttribute = attribute;
		attributeIncrease = increase;
		itemCost = cost;
	}
	
	public String getItemEffects() {
		return ("The item attribute is " + itemAttribute + " and it's attribute increase is " + attributeIncrease );
	}
	public String getItemName() {
		return itemName;
	}
	
	public int getAttributeIncrease() {
		return attributeIncrease;
	}
	public String getItemAttribute() {
		return itemAttribute;
	}
	
}


