
public interface PurchaseOrSell {
	
	Boolean purchaseAthlete(Inventory userInventory, String marketAthleteName, Team userTeam);  //Not working atm because I have not IMPORTED class Inventory and Athlete
	void purchaseItem(Inventory userInventory, String userInputItemName);
	void sellAthlete(Inventory userInventory, String marketAthleteName, Team userTeam);
	void sellItem(Inventory userInventory, String userInputItemName);
}


	//Changing the PurchaseOrSell interface all to Boolean so we can do isSuccess of type Boolean. 
