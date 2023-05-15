import java.util.ArrayList;

//Next steps on here:
//replaceActiveAthlete method
//Automatically Sort Athletes by Position everytime replaceActiveAthlete method is called. Also call just before a match is run. 

public class Team {
	
	public String teamName;
	public ArrayList<Athlete> activeTeamRoster; 
	public ArrayList<Athlete> reserveTeamRoster;
	public int teamPoints;
	
	
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
			System.out.println("Active Athlete Name: "+ activeUserAthlete.athleteName + ", Position: " + activeUserAthlete.athletePosition);
		}
		System.out.println("------------------------------------------------");
		System.out.println("Your current reserve team roster is down below");
		//For loop for reserveTeamRoster
		for(Athlete reserveUserAthlete: reserveTeamRoster) {
			System.out.println("Reserve Athlete Name: " + reserveUserAthlete.athleteName + ", Position: " + reserveUserAthlete.athletePosition);
		}
		System.out.println("------------------------------------------------");
	}
	//Getter method is not used properly. Consult Lab Tutor on this.
	public void replaceActiveAthlete(String activeUserAthleteName, String reserveUserAthleteName, Team userTeam) {
		Athlete activeUserAthlete = new Athlete();
		Athlete reserveUserAthlete = new Athlete();
		Athlete activeUserAthlete = activeUserAthlete.getAthleteByName(activeUserAthleteName, userTeam);
		Athlete reserveUserAthlete = reserveUserAthlete.getAthleteByName(reserveUserAthleteName, userTeam);
		
		int indexActive = activeTeamRoster.indexOf(activeUserAthlete);
		int indexReserve = reserveTeamRoster.indexOf(reserveUserAthlete);
		
		activeTeamRoster.set(indexActive, reserveUserAthlete);
		reserveTeamRoster.set(indexReserve, activeUserAthlete);
	}	
}

