import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AthleteGenerator {
    private static final String[] NAMES = {"John", "Jane", "Bob", "Alice", "Mike", "Sara", "Tom", "Emily", "David", "Lisa"};
    private static final String[] POSITIONS = {"Forward", "Midfielder", "Defender", "Goalkeeper"};
    private static final int MIN_SKILL = 50;
    private static final int MAX_SKILL = 100;
    private static final int MIN_STAMINA = 50;
    private static final int MAX_STAMINA = 100;
    private static final int MIN_COST = 100;
    private static final int MAX_COST = 1000;
    private static final int MIN_SALE_PRICE = 200;
    private static final int MAX_SALE_PRICE = 1500;

    
    //Currently this method returns a Java List of 10 Athlete Objects, that are randomly generated.
    public List<Athlete> generateAthletes() {
        List<Athlete> athletesList = new ArrayList<Athlete>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            String name = NAMES[random.nextInt(NAMES.length)];
            String position = POSITIONS[random.nextInt(POSITIONS.length)];
            int skill = MIN_SKILL + random.nextInt(MAX_SKILL - MIN_SKILL + 1);
            int stamina = MIN_STAMINA + random.nextInt(MAX_STAMINA - MIN_STAMINA + 1);
            boolean available = random.nextBoolean();
            int cost = MIN_COST + random.nextInt(MAX_COST - MIN_COST + 1);
            int salePrice = MIN_SALE_PRICE + random.nextInt(MAX_SALE_PRICE - MIN_SALE_PRICE + 1);
            Athlete athlete = new Athlete(name, position, skill, stamina, available, cost, salePrice);
            athletesList.add(athlete);
        }
        return athletesList;
    }
}
