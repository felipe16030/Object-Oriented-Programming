package Week12;
/**
 * Class that defines a FootballGame object which is-a SportsGame.
 *
 * @author Felipe Bergerman
 * @version 1.1
 */
public class FootballGame extends SportsGame {
    private String singer;

    /**
     * Constructor for a FootballGame object that accepts a venue, startTime,
     * startDate, score1, score2, seatsLeft, and singer.
     *
     * @param venue     String for a venue
     * @param startTime String for a startTime
     * @param startDate String for a StartDate
     * @param score1    int representing score1
     * @param score2    int representing score2
     * @param seatsLeft int representing the number of seats left
     * @param singer    String representing the singer at the event
     * @throws IllegalArgumentException if the singer is either blank or null
     */
    public FootballGame(String venue, String startTime, String startDate, int score1, int score2, int seatsLeft,
            String singer) throws IllegalArgumentException {
        super(venue, startTime, startDate, score1, score2, seatsLeft);
        if (!isStringValid(singer)) {
            throw new IllegalArgumentException("singer is either blank or null");
        }
        this.singer = singer;
    }

    /**
     * Constructs a String representation of the object.
     *
     * @return a formatted String containing all instance data.
     */
    public String toString() {
        return String.format("FootballGame,%s,%s", super.toString(), this.singer);
    }

    /**
     * Checks for equality between a FootballGame and another object.
     *
     * @param other the other object being checked for equality
     * @return true if the FootballGame is equal to the object
     */
    public boolean equals(Object other) {
        if (!(other instanceof FootballGame) || !super.equals(other)) {
            return false;
        }
        FootballGame fg = (FootballGame) other;
        if (fg.singer.equals(this.singer)) {
            return true;
        }
        return false;
    }
}
