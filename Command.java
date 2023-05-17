//Command Pattern. This allows us to refactor our code and avoid a bunch of if statements, in the GameEnviironment we have also
//created a mapping between the user input and the interface's command object.

import java.util.Scanner;

public interface Command {
	
	void execute();
	
	public class StadiumCommand implements Command {
	    public void execute() {
	        // Logic to handle the Stadium command
	        // ...
	    }
	}

	public class MatchCommand implements Command {
	    public void execute() {
	        // Logic to handle the Match command
	        // ...
	    }
	}
	//This is the Market command where user buys a new athlete, and places it into the reserve.

	public class MarketPurchaseCommand implements Command {
	    private Market userMarket;
	    private Scanner scanner;
	    private Team userTeam;
	    private Inventory userInventory;

	    public MarketPurchaseCommand(Market userMarket, Scanner scanner, Team userTeam, Inventory userInventory) {
	        this.userMarket = userMarket;
	        this.scanner = scanner;
	        this.userTeam = userTeam;
	        this.userInventory = userInventory;
	    }

	    public void execute() {
	        while (userTeam.getReserveTeamRoster().size() < 6) {
	            userMarket.checkAvailablePlayers();
	            System.out.println("Enter the name of the athlete you want to buy: - From GameEnvironment Class");
	            String athleteName = scanner.nextLine();

	            if (userMarket.availableAthletes.containsKey(athleteName)) {
	                boolean isSuccess = userMarket.purchaseAthlete(userInventory, athleteName, userTeam); //BUG

	                if (isSuccess) {
	                    System.out.println("You have successfully purchased " + athleteName);
	                } else {
	                    System.out.println("Sorry, the purchase was unsuccessful. Please try again.");
	                }
	            } else {
	                System.out.println("The name you entered does not exist! Please try again. - From GameEnvironment Class");
	            }
	        }
	        System.out.println("Your activeTeamRoster is full! - From GameEnvironment Class");
	    }
	}

	
	
	
	public class DisplayInventoryCommand implements Command {
		private Inventory userInventory;
		
		public DisplayInventoryCommand(Inventory userInventory) {
			this.userInventory = userInventory;
		}
		public void execute() {
			userInventory.displayItemsOwned(userInventory.getItemsOwned());

			
	}
	}
	
	
	
	
	
	//Display Week Command
	
	public class DisplayWeekCommand implements Command {
		private GameEnvironment game;
		
		public DisplayWeekCommand(GameEnvironment game) {
			this.game = game;
		}
		public void execute() {
			 System.out.println("It is currently week " + game.getCurrentWeek() + ", there is " + (game.getNumberOfWeeks() - game.getCurrentWeek()) + " weeks left.");
			
	}
	}
	
	//Display Money Command
	public class DisplayMoneyCommand implements Command {
		private Inventory userInventory;
		
		public DisplayMoneyCommand(Inventory userInventory) {
			this.userInventory = userInventory;
		}
		public void execute() {
		    System.out.println("Your current balance: " + userInventory.getCurrentMoney());
			
	}
	}
	
	
	//Display Team Command
	public class DisplayTeamCommand implements Command {
		private Team userTeam;
		
		public DisplayTeamCommand(Team userTeam) {
			this.userTeam = userTeam;
		}
		public void execute() {
			System.out.println("Your team name is: " + userTeam.getTeamName());
			userTeam.displayRoster(userTeam.getActiveTeamRoster(), userTeam.getReserveTeamRoster());
	}
	}
	
	//Take a Bye Command
	public class TakeAByeCommand implements Command {
	    private GameEnvironment game;

	    public TakeAByeCommand(GameEnvironment game) {
	        this.game = game;
	    }

	    @Override
	    public void execute() {
	        int currentWeek = game.getCurrentWeek();
	        int numberOfWeeks = game.getNumberOfWeeks();
	        currentWeek += 1;
	        game.setCurrentWeek(currentWeek);
	        if (currentWeek <= numberOfWeeks) {
	        	System.out.println("You have taken a bye for a week. Now we are in week: " + currentWeek);
	        	}
	        
	    	}
	    
	    
	    
		}


}
