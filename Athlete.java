//toString()  method is wrong for some reason. Not sure why though.....

public class Athlete {
	private String athleteName;
	private String athletePosition;
	private int athleteSkill;
	private int athleteStamina;
	private boolean athleteInjured;
	private int athleteCost;
	private int athleteSalePrice;
	
	public Athlete(String name, String position, int skill, int stamina, boolean available, int cost, int salePrice) {
		athleteName = name;
		athletePosition = position;
		athleteSkill = skill;
		athleteStamina = stamina;
		athleteInjured = available;
		athleteCost = cost;
		athleteSalePrice = salePrice;
	}
	
	public Athlete() {
		athleteName = "Empty Constructor Created TeamName";
		athletePosition = "Empty Constructor Created Position";
		athleteSkill = 0;
		athleteStamina = 0;
		athleteInjured = false;
		athleteCost = 0;
		athleteSalePrice = 0;
		
	}
	
	public String canPlay() {
		if (this.athleteInjured == true) {
			return "No";
		}
		else {
		return "Yes";
		}
	}
	
	public String toString() {
		return "Name: " + athleteName + "\n" + 
			   "Position: " + athletePosition + "\n" + 
			   "Skill: " + athleteSkill + "\n" + 
			   "Stamina: " + athleteStamina + "\n" + 
			   "Contract Price: " + athleteCost + "\n" + 
			   "Selling Price: " + athleteSalePrice + "\n" + 
			   "Can " + athleteName + " play? :" + canPlay();
	}
	
    public void setInjured(boolean injured) {
        this.athleteInjured = injured;
    }
    
	
	//Getters and setters for private attributes and also specific String to Athlete Object method
	
	public Athlete getAthleteByName(String userInputAthleteName, Team userTeam) {
		System.out.println("Program called getAthleteByName method, from Athlete class."); //Print Statement for Debugging.

		    for (Athlete reserveUserAthlete : userTeam.reserveTeamRoster) { 
		        if (reserveUserAthlete.athleteName.equals(userInputAthleteName)){
		  		return reserveUserAthlete;
	        }
		    }
		    
	        for (Athlete activeUserAthlete : userTeam.activeTeamRoster) { 
		        if (activeUserAthlete.athleteName.equals(userInputAthleteName)){
		  		return activeUserAthlete;
		        }
		    //If cannot find, will print Athlete not Found!
		    }
		    return null;
		    }
    
    public String getAthleteName() {
        return this.athleteName;
    }
    
    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }
    
	// Getter for athletePosition
	public String getAthletePosition() {
		return athletePosition;
	}

	// Setter for athletePosition
	public void setAthletePosition(String athletePosition) {
		this.athletePosition = athletePosition;
	}

	// Getter for athleteSkill
	public int getAthleteSkill() {
		return athleteSkill;
	}

	// Setter for athleteSkill
	public void setAthleteSkill(int athleteSkill) {
		this.athleteSkill = athleteSkill;
	}

	// Getter for athleteStamina
	public int getAthleteStamina() {
		return athleteStamina;
	}

	// Setter for athleteStamina
	public void setAthleteStamina(int athleteStamina) {
		this.athleteStamina = athleteStamina;
	}

	// Getter for athleteInjured
	public boolean isAthleteInjured() {
		return athleteInjured;
	}

	// Setter for athleteInjured
	public void setAthleteInjured(boolean athleteInjured) {
		this.athleteInjured = athleteInjured;
	}

	// Getter for athleteCost
	public int getAthleteCost() {
		return athleteCost;
	}

	// Setter for athleteCost
	public void setAthleteCost(int athleteCost) {
		this.athleteCost = athleteCost;
	}

	// Getter for athleteSalePrice
	public int getAthleteSalePrice() {
		return athleteSalePrice;
	}

	// Setter for athleteSalePrice
	public void setAthleteSalePrice(int athleteSalePrice) {
		this.athleteSalePrice = athleteSalePrice;
	}

}

//void Itembooster method
/*
public void applyItemBooster(ItemBooster booster) {
if (booster.getType() == ItemType.OFFENSIVE) {
    this.athleteSkill += booster.getBoostAmount();
} else if (booster.getType() == ItemType.DEFENSIVE) {
    this.athleteStamina += booster.getBoostAmount();
}
// Handle other types of boosters if needed
}
*/
