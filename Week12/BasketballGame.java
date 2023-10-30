package Week12;
/**
 * Class that defines a BasketballGame object which is-a SportsGame.
 *
 * @author Felipe Bergerman
 * @version 1.1
 */
public class BasketballGame extends SportsGame {
    private String league;

    /**
     * Constructor for a BasketballGame object that accepts a venue, startTime,
     * startDate, score1, score2, seatsLeft, and league.
     *
     * @param venue     String for a venue
     * @param startTime String for a startTime
     * @param startDate String for a StartDate
     * @param score1    int representing score1
     * @param score2    int representing score2
     * @param seatsLeft int representing the number of seats left
     * @param league    String representing the league in which the game occurs
     * @throws IllegalArgumentException if the singer is either blank or null
     */
    public BasketballGame(String venue, String startTime, String startDate, int score1, int score2, int seatsLeft,
            String league) throws IllegalArgumentException {
        super(venue, startTime, startDate, score1, score2, seatsLeft);
        if (!isStringValid(league)) {
            throw new IllegalArgumentException("league is either blank or null");
        }
        this.league = league;
    }

    /**
     * Constructs a String representation of the object.
     *
     * @return a formatted String containing all instance data.
     */
    public String toString() {
        return String.format("BasketballGame,%s,%s", super.toString(), this.league);
    }

    /**
     * Checks for equality between a BasketballGame and another object.
     *
     * @param other the other object being checked for equality
     * @return true if the BasketballGame is equal to the object
     */
    public boolean equals(Object other) {
        if (!(other instanceof BasketballGame) || !super.equals(other)) {
            return false;
        }
        BasketballGame bg = (BasketballGame) other;
        if (bg.league.equals(this.league)) {
            return true;
        }
        return false;
    }
}
