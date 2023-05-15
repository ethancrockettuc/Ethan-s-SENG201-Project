
public class GameRules {
	public String gameDifficulty;
	public int seasonLength;
	public int startingMoney;
	public int moneyEarned;
	public float playerChanceDrop;
	
	public void setGameDifficulty(String userInputDifficulty) {  
		gameDifficulty = userInputDifficulty; //Unsure what number we are working with for each attribute atm.
		if (gameDifficulty == "Easy") {
			seasonLength = 1;
					
		}
		if (gameDifficulty == "Medium") {
			seasonLength = 2;
				
		}
		if (gameDifficulty == "Hard") {
			seasonLength = 3;
		}
		if (gameDifficulty == "Impossible") {
			seasonLength = 4;
		}
		if (gameDifficulty == "Custom") { //Consult with Ahmick about this. This requires another method since it requires extra user inputs.
			inputSeasonLength, inputStartingMoney, inputMoneyEarned, inputplayerChanceDrop = getCustomInput()
			seasonLength = inputSeasonLength;
			startingMoney = inputStartingMoney;
			moneyEarned = inputMoneyEarned;
			playerChanceDrop = inputPlayerChanceDrop;
			System.out.println("Good luck!"); //For custom game mode
		}
		
		public String[] getCustomInput() {
			
		}

		}

}





//Player sets the game difficulty between easy, medium, hard, impossible
//Each option will immediately update all other attributes instead

//custom game mode, where the player can actually change the estSeasonlength themselves


/* current next steps
1. Decide season length by difficulty of Easy, Medium, Hard, Impossible, Custom
2. Custom mode requires user input for each. 
3. need to declare the user input data type, in python it is input(.....) but not sure what that is in java

*/


