/**
 * The Trolley class is reponsible for creating a Trolley object and
 * will be a subclass of Ride.
 *
 * @author Felipe Bergerman
 * @version 1.1
 */
public class Trolley extends Ride {
    private String[] stations;
    private int currentStation;

    /**
     * Constructor that creates an instance of a Trolley object. Makes use of the
     * Ride constructor. Defaults the passengers to an empty array of size 20.
     *
     * @param id                  String containing the Trolley id
     * @param runsSinceInspection int that contains the runs since last inspection
     * @param stations            Array of strings that contains the stop names
     * @param currentStation      int that contains the index of the current stop
     */
    public Trolley(String id, int runsSinceInspection, String[] stations, int currentStation) {
        super(id, runsSinceInspection, new String[20]);
        this.stations = stations.clone();
        this.currentStation = currentStation;
    }

    /**
     * Constructor that creates an instance of a Trolley object. Makes use of the
     * Ride constructor. Defaults the passengers to an empty array of size 20 and
     * runs since inspection to 0.
     *
     * @param id             String containing the Trolley id
     * @param stations       Array of strings that contains the stop names
     * @param currentStation int that contains the index of the current stop
     */
    public Trolley(String id, String[] stations, int currentStation) {
        this(id, 0, stations, currentStation);
    }

    /**
     * Method that determines if the ride can run. It can run
     * if the number of runs passed in is not negative.
     *
     * @param numRuns int containing the number of runs
     * @return true if it can run, false otherwise
     */
    public boolean canRun(int numRuns) {
        return numRuns >= 0 ? true : false;
    }

    /**
     * A method that inspects certain components of the ride. Resets the number of
     * runs since inspection if specific components are checked.
     *
     * @param components Array of strings that contains the components to be
     *                   inspected
     * @return true if the gas and brakes are checked, false otherwise
     */
    public boolean inspectRide(String[] components) {
        boolean containsGas = false;
        boolean containsBrakes = false;
        for (int i = 0; i < components.length; i++) {
            if (components[i].toUpperCase().equals("GAS TANK NOT EMPTY")) {
                containsGas = true;
            }
            if (components[i].toUpperCase().equals("BRAKES OK")) {
                containsBrakes = true;
            }
        }
        if (containsBrakes && containsGas) {
            this.runsSinceInspection = 0;
            return true;
        }
        return false;
    }

    /**
     * Method that calculates the cost per passenger based on the number of stops
     * and how many stations are on the rotation.
     *
     * @param numStops int containing the number of stops travelled
     * @return the cost per passenger as a double.
     */
    public double costPerPassenger(int numStops) {
        return ((numStops * 3.0) / stations.length);
    }

    /**
     * Method that adds passengers to the ride if there are enough open slots. If
     * so, they are charged for the number of stops they want to ride.
     *
     * @param numStops   int containing the number of stops to ride
     * @param passengers Array of strings containing names of passengers to be added
     * @return true if passengers are added and the ride is ridden, false otherwise
     */
    public boolean addPassengers(int numStops, String[] passengers) {
        if (canRun(numStops)) {
            int j = 0;
            for (int i = 0; i < this.passengers.length; i++) {
                if (this.passengers[i] == null && j < passengers.length) {
                    this.passengers[i] = passengers[j];
                    this.chargePassenger(numStops);
                    j++;
                }
            }
            this.moveTrolley(numStops);
            return true;
        }
        return false;
    }

    /**
     * Method that checks equality of 2 Trolleys by comparing all data checked
     * by the Ride equals method in addition to the stations and current station.
     *
     * @param o the object being checked for equality
     * @return true if they are equal, false otherwise
     */
    public boolean equals(Object o) {

        if (!super.equals(o)) {
            return false;
        }

        Trolley other = (Trolley) o;
        boolean areStationsEqual = true;
        if (other.stations.length != this.stations.length) {
            return false;
        }
        for (int i = 0; i < this.stations.length; i++) {
            if (!(this.stations[i].toUpperCase().equals(other.stations[i].toUpperCase()))) {
                areStationsEqual = false;
            }
        }

        if (this.currentStation == other.currentStation && areStationsEqual) {
            return true;
        }

        return false;
    }

    /**
     * Method that will move the Trolley forward a given number of stations. It
     * updates both the runs since inspection and the current station. Loops back if
     * it reaches the end.
     *
     * @param numStations int containing the number of stations to move forward
     */
    public void moveTrolley(int numStations) {
        this.runsSinceInspection += ((this.currentStation + numStations) / this.stations.length);
        this.currentStation = ((this.currentStation + numStations) % this.stations.length);
    }

    /**
     * Method that returns a string representation of a RollerCoaster.
     *
     * @return a formatted string containg the Trolley's id, runs since inspection,
     *         earnings, the current station, and the next station up.
     */
    public String toString() {
        return String.format(
                "Trolley %s has driven %d loops and has earned $%.2f. This trolley is at %s. Next up is %s.", this.id,
                this.runsSinceInspection, this.earnings, this.stations[this.currentStation],
                this.stations[(this.currentStation % (this.stations.length - 1)) + 1]);
    }
}
