import java.util.ArrayList;

//Next steps on here:
//replaceActiveAthlete method
//Automatically Sort Athletes by Position everytime replaceActiveAthlete method is called. Also call just before a match is run. 

public class Team {
	
	private String teamName;
	private ArrayList<Athlete> activeTeamRoster; 
	private ArrayList<Athlete> reserveTeamRoster;
	private int teamPoints;
	
	
	//Need a way to sort athletes by position, automatically under certain conditions. otherwise, will specify throughout the program when to do it.
		//This is the constructor the user will use
	    public Team(String teamName, ArrayList<Athlete> activeTeamRoster, ArrayList<Athlete> reserveTeamRoster) {
	        this.teamName = teamName;
	        this.activeTeamRoster = activeTeamRoster;
	        this.reserveTeamRoster = reserveTeamRoster;
	    }
	    

	    // Getters and setters for the instance variables here...
	
	public void displayRoster(ArrayList<Athlete> activeTeamRoster, ArrayList<Athlete> reserveTeamRoster){
		System.out.println("Your current active team roster is down below ");
		//For loop for activeTeamRoster
		for(Athlete activeUserAthlete: activeTeamRoster) {
			System.out.println("Active Athlete Name: "+ activeUserAthlete.getAthleteName() + ", Position: " + activeUserAthlete.getAthletePosition());
			System.out.println("Stamina: "+ activeUserAthlete.getAthleteStamina() + ", Skill: " + activeUserAthlete.getAthleteSkill());
		}
		System.out.println("------------------------------------------------");
		System.out.println("Your current reserve team roster is down below");
		//For loop for reserveTeamRoster
		for(Athlete reserveUserAthlete: reserveTeamRoster) {
			System.out.println("Active Athlete Name: "+ reserveUserAthlete.getAthleteName() + ", Position: " + reserveUserAthlete.getAthletePosition());
			System.out.println("Stamina: "+ reserveUserAthlete.getAthleteStamina() + ", Skill: " + reserveUserAthlete.getAthleteSkill());
		}
		System.out.println("------------------------------------------------");
	}
	//Getter method is not used properly. Consult Lab Tutor on this.
	public void replaceActiveAthlete(String activeUserAthleteName, String reserveUserAthleteName, Team userTeam) {
		Athlete activeUserAthlete = new Athlete();
		Athlete reserveUserAthlete = new Athlete();
		activeUserAthlete = activeUserAthlete.getAthleteByName(activeUserAthleteName, userTeam);
		reserveUserAthlete = reserveUserAthlete.getAthleteByName(reserveUserAthleteName, userTeam);
		
		int indexActive = activeTeamRoster.indexOf(activeUserAthlete);
		int indexReserve = reserveTeamRoster.indexOf(reserveUserAthlete);
		
		activeTeamRoster.set(indexActive, reserveUserAthlete);
		reserveTeamRoster.set(indexReserve, activeUserAthlete);
	}	
	
	//Getters & Setters Methods for Team Class
	
    public String getTeamName() {
        return teamName;
    }
    
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    
    public ArrayList<Athlete> getActiveTeamRoster() {
        return activeTeamRoster;
    }
    
    public void setActiveTeamRoster(ArrayList<Athlete> activeTeamRoster) {
        this.activeTeamRoster = activeTeamRoster;
    }
    
    public ArrayList<Athlete> getReserveTeamRoster() {
        return reserveTeamRoster;
    }
    
    public void setReserveTeamRoster(ArrayList<Athlete> reserveTeamRoster) {
        this.reserveTeamRoster = reserveTeamRoster;
    }
    
    public int getTeamPoints() {
        return teamPoints;
    }
    
    public void setTeamPoints(int teamPoints) {
        this.teamPoints = teamPoints;
    }
	
	
	
}

