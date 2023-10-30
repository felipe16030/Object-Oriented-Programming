/**
 * This is the Ride class which is abstract and will be inherited by
 * RollerCoaster and Trolley.
 *
 * @author Felipe Bergerman
 * @version 1.1
 */
public abstract class Ride {
    protected final String id;
    protected double earnings;
    protected int runsSinceInspection;
    protected String[] passengers;

    /**
     * Constructor that creates a Ride instance.
     *
     * @param id                  String that contains the ride id
     * @param runsSinceInspection int that contains the runs since inspection
     * @param passengers          Array of string that contains the list of
     *                            passengers on board
     */
    public Ride(String id, int runsSinceInspection, String[] passengers) {
        this.id = id;
        this.earnings = 0;
        this.runsSinceInspection = runsSinceInspection;
        this.passengers = passengers.clone();
    }

    /**
     * Constructor that creates a Ride instance. Runs since inspection is set to a
     * defualt of 0.
     *
     * @param id         String that contains the ride id
     * @param passengers Array of string that contains the list of passengers on
     *                   board
     */
    public Ride(String id, String[] passengers) {
        this(id, 0, passengers);
    }

    /**
     * Method that determines if the ride can run pending on the number of runs
     * passed in, the max runs this ride can run, and the number of rides run since
     * inspection.
     * Will only be implemented in children classes.
     *
     * @param numRuns Int that contains the number of potential runs
     * @return true if it can run and flase if not
     */
    public abstract boolean canRun(int numRuns);

    /**
     * Method that inspects components of the ride. Only implemeneted in children
     * classes.
     *
     * @param components Array of strings containing components to be inspected
     * @return true if the specific components are all inspected
     */
    public abstract boolean inspectRide(String[] components);

    /**
     * Method that calculates the costPerPassenger. Only implmeneted in children
     * classes.
     *
     * @param numStops int containing the number of stops the passenger will run
     * @return the cost per passenger as a double
     */
    public abstract double costPerPassenger(int numStops);

    /**
     * Method that adds passengers to the ride. Only implemented in children
     * classes.
     *
     * @param numStops   int representing the number of stops travelled
     * @param psngrs Array of strings representing the passengers to be added
     * @return true if the passengers were added and the ride run, false otherwise.
     */
    public abstract boolean addPassengers(int numStops, String[] psngrs);

    /**
     * Method that returns the passengers onboard a ride.
     *
     * @return a formatted string with all passengers onboard.
     */
    public String getPassengerList() {
        String returnString = "Passenger List for " + this.id + ":";
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] != null) {
                returnString += "\n" + passengers[i];
            }
        }
        return returnString;
    }

    /**
     * Method that charges a passenger and updates earnings based on the cost per
     * passenger.
     *
     * @param numStops int representing the number of stops travelled
     */
    public void chargePassenger(int numStops) {
        this.earnings += this.costPerPassenger(numStops);
    }

    /**
     * Method that removes a specific passsenger by name.
     *
     * @param name String containing the name of the passenger to be removed
     * @return true if a passenger was removed, false otherwise
     */
    public boolean removePassenger(String name) {
        for (int i = 0; i < this.passengers.length; i++) {
            if (this.passengers[i] != null) {
                if (name.toUpperCase().equals(this.passengers[i].toUpperCase())) {
                    this.passengers[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method that overrides equal method from the Object class and checks equality
     * via comparing runs since inspection and the ride id.
     *
     * @param o object passed in to compare equality
     * @return true if the objects are equal, false otherwise.
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (o.getClass() != this.getClass()) {
            return false;
        } else {
            Ride other = (Ride) o;
            if (this.id.equals(other.id) && this.runsSinceInspection == other.runsSinceInspection) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method that produces a string representation of the object.
     *
     * @return Formatted string dictating the ride id, runs since inspection, and
     *         earnings
     */
    public String toString() {
        return String.format("%s has run %d times and has earned $%.2f.", this.id, this.runsSinceInspection,
                this.earnings);
    }
}
