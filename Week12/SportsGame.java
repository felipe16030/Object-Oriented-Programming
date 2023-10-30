package Week12;
/**
 * Defines an abstract class SportsGame.
 *
 * @author Felipe Bergerman
 * @version 1.1
 */
public abstract class SportsGame {
    private String venue;
    private String startTime;
    private String startDate;
    private int score1;
    private int score2;
    private int seatsLeft;

    /**
     * Constructor for a SportsGame object that accepts a venue, startTime,
     * startDate, score1, score2, seatsLeft.
     *
     * @param venue     String for a venue
     * @param startTime String for a startTime
     * @param startDate String for a StartDate
     * @param score1    int representing score1
     * @param score2    int representing score2
     * @param seatsLeft int representing the number of seats left
     * @throws IllegalArgumentException if the venue, startTime, or startDate are
     *                                  invalid or if score1, score2, or seatsLeft
     *                                  are negative
     */
    public SportsGame(String venue, String startTime, String startDate, int score1, int score2, int seatsLeft)
            throws IllegalArgumentException {
        if (!isStringValid(venue) || !isStringValid(startTime) || !isStringValid(startDate)) {
            throw new IllegalArgumentException("Either venue, startTime, or startDate is blank or null");
        }
        if (score1 < 0 || score2 < 0 || seatsLeft < 0) {
            throw new IllegalArgumentException("Either score1, score2, or seatsLeft is negative");
        }
        this.venue = venue;
        this.startTime = startTime;
        this.startDate = startDate;
        this.score1 = score1;
        this.score2 = score2;
        this.seatsLeft = seatsLeft;
    }

    /**
     * Constructs a String representation of the object.
     *
     * @return a formatted String containing all instance data.
     */
    public String toString() {
        return String.format("%s,%s,%s,%d,%d,%d", this.venue, this.startTime, this.startDate, this.score1,
                this.score2, this.seatsLeft);
    }

    /**
     * Checks for equality between a BasketballGame and another object.
     *
     * @param other the other object being checked for equality
     * @return true if the BasketballGame is equal to the object
     */
    public boolean equals(Object other) {
        if (other == null || !(other instanceof SportsGame)) {
            return false;
        }
        SportsGame sg = (SportsGame) other;
        if (sg.venue.equals(this.venue) && sg.startDate.equals(this.startDate) && sg.startTime.equals(this.startTime)
                && sg.score1 == this.score1 && sg.score2 == this.score2 && sg.seatsLeft == this.seatsLeft) {
            return true;
        }
        return false;
    }

    /**
     * gets the seatsLeft.
     *
     * @return int seatsLeft
     */
    public int getSeatsLeft() {
        return this.seatsLeft;
    }

    /**
     * A helper method that determines if a String is valid.
     *
     * @param str String to be checked for validity
     * @return true if the String is valid, false otherwise
     */
    protected boolean isStringValid(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        return true;
    }
}