package Week12;
import java.util.ArrayList;

/**
 * Class that acts as a driver for our other classes.
 *
 * @author Felipe Bergerman
 * @version 1.1
 */
public class Driver {
    /**
     * Main executable method.
     *
     * @param args Array of String for command line arguments
     */
    public static void main(String[] args) {
        ArrayList<SportsGame> arrList = new ArrayList<SportsGame>();
        arrList.add(new BasketballGame("CULC", "17:30", "10-15-23", 100, 98, 1000, "ACC"));
        try {
            Tickets.findTickets("TestTickets.csv",
                    new BasketballGame("McCamish Pavilion", "19:30", "11-07-2022", 93, 63, 6192,
                            "Atlantic Coast Conference"));
            Tickets.purchaseTickets("E.csv", arrList);
            Tickets.attendGame("E.csv", new BasketballGame("McCamish Pavilion", "19:30", "11-07-2022", 93, 63, 6192,
                    "Atlantic Coast Conference"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
