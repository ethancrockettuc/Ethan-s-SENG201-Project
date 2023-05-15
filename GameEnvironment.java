import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//Set up team, go to club (Option of market, or straight to match, or take a bye), finish match and come back to club, repeat until while loop ends
//once while loop ends, show final score? 

/* Current questions:
 * What attributes does GameEnvironment need? (based on what needs to be kept track of?)
 * Do we need a constructor for Game Environment?
 * What should the Scanner data type section have?
 * How to actually create the runGame() method
 * Check if While Loop is done correctly.
 * 
 */
public class GameEnvironment {
	//Attributes of GameEnvironment
	private int currentWeek; //an integer representing the current match week.
	private int numberOfWeeks; //an integer representing the number of weeks for the season.
	//private ClubPage userClubPage; //an object representing the club page, which contains the options for starting a match, going to the market to buy players, or taking a bye.
	private Boolean seasonFinished; //a boolean value indicating whether or not the season is finished.
	private Boolean gameRunning; 
	
	private Inventory userInventory;
	private Team userTeam;
	private Market userMarket;
	
	
    public GameEnvironment() {
    	this.currentWeek = 1;
        this.userInventory = new Inventory();
        this.userTeam = new Team("not named yet",new ArrayList<Athlete>(), new ArrayList<Athlete>());
        this.userMarket = new Market();
        this.gameRunning = true;

        //Create instance of every class e.g market, inventory, Team, Match, etc....? How and where should I istantiate this shit
        

    }
    //Scanner goes here
    public void startGame(GameEnvironment game) {
     
    	//Creating million dollars for inventory just to test shit
    	userInventory.currentMoney = 1000000;
    	
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to our game! Let's get started.");
        
        //Creating Team Name userTeam Instance of Class Team
        System.out.print("Enter your team name: ");
        String userInputTeamName = scanner.nextLine();
        userTeam.teamName = userInputTeamName;
        System.out.println("Your team name is " +userTeam.teamName);
       
        //Choosing Number of Weeks for season
        System.out.print("Enter the number of weeks you want to play (1-15) for the season: ");
        
        //Filters userInputNumWeeks to Integer, not string or anything else.
        int userInputNumWeeks;
        while (true) {
            String userInput = scanner.nextLine();
            try {
                userInputNumWeeks = Integer.parseInt(userInput);
                if (userInputNumWeeks >= 1 && userInputNumWeeks <= 15) {
                    break; // valid input, exit loop
                } 
                else {
                    System.out.println("Not valid season duration!");
                }
            } 
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer: ");
            }
        }
        numberOfWeeks = userInputNumWeeks;
        
        
        System.out.println("Perfect! Let's pick your Athletes from the available market!");
        
        System.out.println("Your activeTeamRoster is full!");
      //Autogenerator Athletes Class called, updates Market class, displays availableAthletes HashMap for Purchase
        AthleteGenerator generator = new AthleteGenerator();
        List<Athlete> athletesList = generator.generateAthletes();
        game.updateAvailableAthletes(athletesList, userMarket);
        userMarket.checkAvailablePlayers();
        
        //Next steps from here:
        //user chooses athletes from market - purchaseAthlete method must be applied here. 
        //^If statements for : If attacker, fill in first 3 slots, if atk midfielder, fill in etc...
        //^^User must choose 3 attackers, 2 atkmidfielders, 2 dfending midfielders, 2 defenders
        //^^^userInputAthleteChosen, adds into activeTeamRoster.
        
        //----------------------BUG------------------------------------
        int count = 0;
        while (count < 10) {
            System.out.println("Enter the name of the athlete you want to buy:");
            String athleteName = scanner.nextLine(); // assuming that you have already created a Scanner object called "scanner"

            // Call the purchaseAthlete method to buy the athlete
            boolean isSuccess = userMarket.purchaseAthleteForFirstTime(userInventory, athleteName, userTeam);
            
            // Check if the purchase was successful
            if (isSuccess) {
                System.out.println("You have successfully purchased " + athleteName);
                count++;
            } else {
                System.out.println("Sorry, the purchase was unsuccessful. Please try again.");
            }
        }
        //---------------BUG-------------------------------------------------
        
        System.out.println("You're ready to go!");
        scanner.nextLine();
        scanner.close();
        //While gameRunning is assigned True. This is created alongside the UML 
        
        
       //While loop starts and shows the club, Market, Match option.
        
       /* while (currentWeek <= numberOfWeeks)    
        
                      System.out.println("Enter a command (type 'help' for a list of commands):");
            switch (userInput) {
                case "help":
                    // display list of commands
                    break;
                case "inventory":
                    userInventory.checkInventory();
                    break;
                case "team":
                    userTeam.checkTeam();
                    break;
                case "market":
                    userMarket.checkMarket();
                    break;
                case "buy item":
                    System.out.println("Enter the name of the item you want to buy:");
                    String itemName = scanner.nextLine();
                    userMarket.purchaseItem(userInventory, itemName);
                    break;
                case "buy athlete":
                    System.out.println("Enter the name of the athlete you want to buy:");
                    String athleteName = scanner.nextLine();
                    Athlete marketAthlete = userMarket.getAthleteByName(athleteName);
                    userMarket.purchaseAthlete(userInventory, marketAthlete, userTeam);
                    break;
                case "sell athlete":
                    System.out.println("Enter the name of the athlete you want to sell:");
                    String athleteName = scanner.nextLine();
                    userMarket.sellAthlete(userInventory, athleteName, userTeam);
                    break;
                case "sell item":
                    System.out.println("Enter the name of the item you want to sell:");
                    String itemName = scanner.nextLine();
                    userInventory.sellItem(userItem);
                    break;
                case "quit":
                    System.out.println("Thanks for playing!");
                    gameRunning = false;
                    break;
                default:
                    System.out.println("Invalid command. Type 'help' for a list of commands.");
                    break;
            }
         */
    }
    
    
    
    
    
    
    
	public void updateAvailableAthletes(List<Athlete> athletesList, Market userMarket) {
	    for (Athlete generatedAthlete : athletesList) {
	        userMarket.availableAthletes.put(generatedAthlete.getAthleteName(), generatedAthlete);
	    }
	}
}

