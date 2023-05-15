import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AthleteTest {

	  @Test
	  public void testCanPlayWithInjury() {
	    Athlete athlete = new Athlete("John", "Forward", 90, 80, false, 100, 200);
	    athlete.setInjured(true);
	    assertEquals("No", athlete.canPlay());
	  }

	  @Test
	  public void testCanPlayWithoutInjury() {
	    Athlete athlete = new Athlete("John", "Forward", 90, 80, false, 100, 200);
	    athlete.setInjured(false);
	    assertEquals("Yes", athlete.canPlay());
	  }

	  @Test
	  public void testToString() {
	    Athlete athlete = new Athlete("John", "Forward", 90, 80, false, 100, 200);
	    String expected = "Name: John\nPosition: Forward\nSkill: 90\nStamina: 80\nContract Price: 100\nSelling Price: 200\nCan John play? Yes";
	    assertEquals(expected, athlete.toString());
	  }

	  @Test
	  public void testGetAthleteByName() {
	    Athlete athlete1 = new Athlete("John", "Forward", 90, 80, false, 100, 200);
	    Athlete athlete2 = new Athlete("David", "Midfielder", 80, 70, false, 150, 300);
	    ArrayList<Athlete> testActiveTeamRoster = new ArrayList<Athlete>();
	    ArrayList<Athlete> testReserveTeamRoster = new ArrayList<Athlete>();
	    Team team = new Team("yabba",testActiveTeamRoster,testReserveTeamRoster);
	    team.reserveTeamRoster.add(athlete1);
	    team.reserveTeamRoster.add(athlete2);
	    Athlete result = athlete1.getAthleteByName("David", team);
	    assertEquals(athlete2, result);
	  }

	}
//use assertions for Junit tests

