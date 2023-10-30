/**
 * The RollerCoaster class is reponsible for creating a RollerCoaster object and
 * will be a subclass of Ride.
 *
 * @author Felipe Bergerman
 * @version 1.1
 */
public class RollerCoaster extends Ride {
    private double rate;
    private double photoFees;
    private int maxNumRuns;

    /**
     * Constructor that creates an instance of a RollerCoaster. Makes use of the
     * Ride constructor.
     *
     * @param id                  String that contains the ride id
     * @param runsSinceInspection int that contains the runs since inspection
     * @param passengers          Array of string that contains the list of
     *                            passengers on board
     * @param rate                double that contains the rate it costs to ride one
     *                            stop
     * @param photoFees           double that contains the cost to purchase the
     *                            one-time mandatory photo package
     * @param maxNumRuns          int that contains the max number of runs the
     *                            RollerCoaster can run before inspection
     */
    public RollerCoaster(String id, int runsSinceInspection, String[] passengers, double rate, double photoFees,
            int maxNumRuns) {
        super(id, runsSinceInspection, passengers);
        this.rate = rate;
        this.photoFees = photoFees;
        this.maxNumRuns = maxNumRuns;
    }

    /**
     * Constructor that creates an instance of a RollerCoaster. Makes use of the
     * Ride constructor. Sets the passenger list, rate, and photo fees to their
     * defaults.
     *
     * @param id                  String that contains the ride id
     * @param runsSinceInspection int that contains the runs since inspection
     * @param maxNumRuns          int that contains the max number of runs the
     *                            RollerCoaster can run before inspection
     */
    public RollerCoaster(String id, int runsSinceInspection, int maxNumRuns) {
        this(id, runsSinceInspection, new String[4], 10, 15, maxNumRuns);
    }

    /**
     * Constructor that creates an instance of a RollerCoaster. Makes use of the
     * Ride constructor. Sets the runs since inspection, passenger list, rate, photo
     * fees, and max number of runs to their
     * defaults.
     *
     * @param id String that contains the ride id
     */
    public RollerCoaster(String id) {
        this(id, 0, new String[4], 10, 15, 200);
    }

    /**
     * Method that determines if the ride can run pending on the number of runs
     * passed in, the max runs this ride can run, and the number of rides run since
     * inspection.
     *
     * @param numRuns int containing the number of runs.
     * @return true if the number of runs does not exceed the max number of runs
     *         minus the number of runs already ran, false otherwise or if numRuns
     *         is negative
     */
    public boolean canRun(int numRuns) {
        if (numRuns < 0) {
            return false;
        }
        if (numRuns > (maxNumRuns - runsSinceInspection)) {
            return false;
        }
        return true;
    }

    /**
     * A method that inspects certain components of the ride. Resets the number of
     * runs since inspection if specific components are checked.
     *
     * @param components Array of strings that contains the components to be
     *                   inspected
     * @return true if the brakes and tracks are checked, false otherwise
     */
    public boolean inspectRide(String[] components) {
        boolean containsTracks = false;
        boolean containsBrakes = false;
        for (int i = 0; i < components.length; i++) {
            if (components[i].toUpperCase().equals("TRACKS CLEAR")) {
                containsTracks = true;
            }
            if (components[i].toUpperCase().equals("BRAKES OK")) {
                containsBrakes = true;
            }
        }
        if (containsBrakes && containsTracks) {
            this.runsSinceInspection = 0;
            return true;
        }
        return false;
    }

    /**
     * Method that calculates the cost per passenger based on the number of stops,
     * rate, and photo fees.
     *
     * @param numStops int containing the number of stops travelled
     * @return the cost per passenger as a double.
     */
    public double costPerPassenger(int numStops) {
        return ((numStops * rate) + photoFees);

    }

    /**
     * Method that adds passengers to the ride if there are enough open slots. If
     * so,
     * they are charged for the number of stops they want to ride.
     *
     * @param numStops   int containing the number of stops to ride
     * @param passengers Array of strings containing names of passengers to be added
     * @return true if passengers are added and the ride is ridden, false otherwise
     */
    public boolean addPassengers(int numStops, String[] passengers) {
        if (canRun(numStops) && (passengers.length <= this.passengers.length)
                && numSeatsAvailable() >= passengers.length) {
            int j = 0;
            for (int i = 0; i < this.passengers.length; i++) {
                if (this.passengers[i] == null && j < passengers.length) {
                    this.passengers[i] = passengers[j];
                    this.chargePassenger(numStops);
                    j++;
                }
            }
            this.runsSinceInspection += numStops;
            return true;
        }
        return false;
    }

    /**
     * Method that checks equality of 2 RollerCoasters by comparing all data checked
     * by the Ride equals method in addition to the rate, photo fees, and the max
     * number of runs.
     *
     * @param o the object being checked for equality
     * @return true if they are equal, false otherwise
     */
    public boolean equals(Object o) {

        if (!super.equals(o)) {
            return false;
        }

        RollerCoaster other = (RollerCoaster) o;
        if (this.rate == other.rate && this.photoFees == other.photoFees
                && this.maxNumRuns == other.maxNumRuns) {
            return true;
        }

        return false;
    }

    /**
     * Method that returns a string representation of a RollerCoaster.
     *
     * @return a formatted string containg the Coaster's id, runs since inspection,
     *         earnings, runs left, rate, and photo fees.
     */
    public String toString() {
        String returnString = String.format(
                "Roller Coaster %s has run %d times and has earned $%.2f. It can only run %d more times.",
                this.id, this.runsSinceInspection, this.earnings, (this.maxNumRuns - this.runsSinceInspection));
        returnString += String.format(
                " It costs $%.2f per ride and there is a one-time photo fee of $%.2f.",
                this.rate, this.photoFees);
        return returnString;
    }

    /**
     * Helper method that determines the number of seets available on a
     * RollerCoaster.
     *
     * @return the number of seats available as an int
     */
    private int numSeatsAvailable() {
        int numSeats = 0;
        for (int i = 0; i < this.passengers.length; i++) {
            if (this.passengers[i] == null) {
                numSeats++;
            }
        }
        return numSeats;
    }
}
