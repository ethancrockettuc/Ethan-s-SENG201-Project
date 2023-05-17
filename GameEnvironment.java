import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class GameEnvironment implements Command{
	//Attributes of GameEnvironment
	private int currentWeek; //an integer representing the current match week.
	private int numberOfWeeks; //an integer representing the number of weeks for the season.
	//private ClubPage userClubPage; //an object representing the club page, which contains the options for starting a match, going to the market to buy players, or taking a bye.
	private Boolean seasonFinished; //a boolean value indicating whether or not the season is finished.
	private Boolean gameRunning; 
	
	private Inventory userInventory;
	private Team userTeam;
	private Market userMarket;
	private String difficulty; //Difficulty of gamemode. 
	
	//All instances of every class needed will be instantiated in here, or in the startGame, before the while loop (Section 3)
    public GameEnvironment() {
    	this.currentWeek = 0;
        this.userInventory = new Inventory();
        this.userTeam = new Team("not named yet",new ArrayList<Athlete>(), new ArrayList<Athlete>());
        this.userMarket = new Market();
        this.gameRunning = true;

        

    }
    public void startGame(GameEnvironment game) {
    	//System.out.println("The size of the reserve team is " + userTeam.getReserveTeamRoster().size());
    	
    	
    	//Section 1: Setup Team Name, Number of Weeks
    	
    	
    	
    	//Creating million dollars for inventory just to test
    	userInventory.setCurrentMoney(10000);
    	
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to our game! Let's get started.");
        
        //Creating Team Name userTeam Instance of Class Team
        System.out.print("Enter your team name: ");
        String userInputTeamName = scanner.nextLine();
        userTeam.setTeamName(userInputTeamName);
        System.out.println("Your team name is " +userTeam.getTeamName());
        //Selecting difficulty
        System.out.println("Choose a difficulty: Easy, Medium, Hard");
        String userInputDifficulty = scanner.nextLine();
        game.difficulty = userInputDifficulty;

        while (!userInputDifficulty.equals("Easy") && !userInputDifficulty.equals("Medium") && !userInputDifficulty.equals("Hard")) {
            System.out.println("Not a valid difficulty! Pick again.");
            System.out.println("Choose a difficulty: Easy, Medium, Hard");
            userInputDifficulty = scanner.nextLine();
            game.difficulty = userInputDifficulty;
        }


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
                    System.out.print("Enter the number of weeks you want to play (1-15) for the season: ");
                }
            } 
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer: ");
                System.out.print("Enter the number of weeks you want to play (1-15) for the season: ");
            }
        }
        numberOfWeeks = userInputNumWeeks;
        
        
        //SECTION 2: Buying Athletes from updated Market
        System.out.println("Perfect! Let's pick your Athletes from the available market!");
        
      //Autogenerator Athletes Class called, updates Market class, displays availableAthletes HashMap for Purchase
        AthleteGenerator generator = new AthleteGenerator();
        List<Athlete> athletesList = generator.generateAthletes();
        System.out.println("athletesList from athleteGenerator has a size of: " + Integer.toString(athletesList.size()));
        game.updateAvailableAthletes(athletesList, userMarket);
        System.out.println("availableAthletes from Market has a size of: " + Integer.toString(userMarket.availableAthletes.size()));
        
        
        userMarket.checkAvailablePlayers();
        
        
        //STILL NEEDED:
        //call the auto-sort Team ArrayList after this, so athletes are in fixed order.(This will be used when buying & switching athletes around in the game. 
        
        int count = 0;
        
        
       
        //while loop section for SECTION 2
//------------------------------This section needs to control user buying 3 attack, 2atkmdfielder, 2dfmidfielder & 3 defenders-------------------------------------------------------------------------------------------------------------------------
        while (count < 1) {
            System.out.println("Enter the name of the athlete you want to buy: - From GameEnvironment Class");
            String athleteName = scanner.nextLine(); 
            //Needs to see uesr is not overbuying number of athletes of each set position
            if(userMarket.availableAthletes.keySet().contains(athleteName)) {
            	
            
	            // Call the purchaseAthlete method to buy the athlete
	            boolean isSuccess = userMarket.purchaseAthleteForFirstTime(userInventory, athleteName, userTeam, userMarket);
	            
	            // Check if the purchase was successful
	            if (isSuccess) {
	                System.out.println("You have successfully purchased " + athleteName);
	                count++;
	            } else {
	                System.out.println("Sorry, the purchase was unsuccessful. Please try again.");
	            }
	        }
            else {
	        System.out.println("The name you entered does not exist! Please try again.- From GameEnvironment Class"); 
            }
        }
        System.out.println("Your activeTeamRoster is full! - From GameEnvironment Class");
        
        
// -------------------------------^^^This section needs to control user buying 3 attack, 2atkmdfielder, 2dfmidfielder & 3 defenders^^^--------------------------------------------------------------------------------------------------
        
        //System.out.println("You're ready to go!");
        
        
        
       //SECTION 3: Running the game
        //- Match, TakeABye(Done), Access Market to Buy items or Athletes, Rearrange Active & Reserve Athletes.
        
        //Command map for Command interface
        
        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("stadium", new StadiumCommand());
        commandMap.put("match", new MatchCommand());
        commandMap.put("buy", new MarketPurchaseCommand(userMarket,scanner,userTeam,userInventory));
        commandMap.put("skip", new TakeAByeCommand(game)); // TakeAByeCommand takes in GameEnvironment game instance, because it will directly change the currentWeek attribute.
        commandMap.put("team", new DisplayTeamCommand(userTeam));
        commandMap.put("money", new DisplayMoneyCommand(userInventory));
        commandMap.put("week", new DisplayWeekCommand(game));
        commandMap.put("inventory", new DisplayInventoryCommand(userInventory));
        

        
        //SECTION 2.2 PLAYING THE MAIN GAME
        while (game.currentWeek <= game.numberOfWeeks) {
            System.out.println("Welcome to the Club page! Type Stadium to go to Stadium, Match to go to Match, 'buy' or 'sell' in the market, type Skip to Take a Bye");
            
            //ALL OF THESE WILL BE COMMANDS
            //Insert Swap Active & Reserve Athletes around. 
            
            
            //part 3:
            
            
            
            //Instantiating the GameMatch class. It will be called through Command Interface, which has "Match" Keyword.
            //GameMatch userMatch = new GameMatch();
            
            //Command interface section down below
            String userInput = scanner.nextLine().toLowerCase(); // Convert user input to lowercase for case-insensitive comparison
            Command command = commandMap.get(userInput);
            if (command != null) {
                command.execute();
            } else {
                System.out.println("Invalid command.");
            }
        }
       
        
        //Game is finished
        System.out.println("Game is finished!");
       
       scanner.close();
    }
    
    
    //Extra Feature to this method needed: updates the available athletes in market, but makes sure there are ZERO duplicate Names in the userTeam and userMarket.
    //Issue is it never sorts athletes in order of position.
	public void updateAvailableAthletes(List<Athlete> athletesList, Market userMarket) {
	    for (Athlete generatedAthlete : athletesList) {
	        userMarket.availableAthletes.put(generatedAthlete.getAthleteName(), generatedAthlete);
	    }
	}
	
	public int getCurrentWeek() {
		return this.currentWeek;
	
	}
	//This is the user input total number of weeks in a season. An attribute of GameEnvironment Class.
	public int getNumberOfWeeks() {
		return this.numberOfWeeks;
	
	}
	
	//Setter method for Current Week
	public void setCurrentWeek(int currentWeek) {
		this.currentWeek = currentWeek;
	}
	
	
}

