import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class UserMarketAthleteGenerator {

    private static final String[] firstNames = { 'Adam', 'Andrew', 'Benjamin', 'Brandon', 'Brian', 'Caleb', 'Christopher', 'Daniel', 'David', 'Derek',          'Dominic', 'Edward', 'Eric', 'Ethan', 'Gabriel', 'George', 'Harrison', 'Isaac', 'Jack', 'Jacob',          'James', 'Jason', 'Jeffrey', 'John', 'Jonathan', 'Joseph', 'Joshua', 'Justin', 'Kevin', 'Kyle',          'Liam', 'Lucas', 'Matthew', 'Michael', 'Nathan', 'Nicholas', 'Noah', 'Patrick', 'Peter', 'Philip',          'Richard', 'Robert', 'Ryan', 'Samuel', 'Scott', 'Stephen', 'Thomas', 'Timothy', 'Tyler', 'William'};
    private static final String[] lastNames = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Martinez",            "Hernandez", "Lopez", "Gonzalez", "Perez", "Moore", "Taylor", "Anderson", "Jackson", "Martin", "Lee",            "Allen", "Young", "Wright", "Scott", "Walker", "Hall", "King", "Green", "Baker", "Adams", "Nelson",            "Carter", "Mitchell", "Parker", "Collins", "Turner", "Phillips", "Campbell", "Evans", "Edwards", "Cooper",            "Reed", "Bailey", "Bell", "Murphy", "Rivera", "Morgan", "Howard", "Cox" };
    private static final String[] positions = { "Striker", "Attacking Midfielder", "Defending Midfielder", "Defender" };


    public static List<Athlete> generateAthletes() {
        List<Athlete> athletes = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 100; i++) {
            Athlete athlete = new Athlete();
            athlete.setAthleteName(firstNames[random.nextInt(firstNames.length)] + " " + lastNames[random.nextInt(lastNames.length)]);
            athlete.setAthleteAge(MIN_AGE + random.nextInt(MAX_AGE - MIN_AGE + 1));
            athlete.setAthletePosition(positions[random.nextInt(positions.length)]);
            athletes.add(athlete);
        }
        return athletes;
    }
}
}
