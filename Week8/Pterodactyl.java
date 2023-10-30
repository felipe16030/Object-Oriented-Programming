package Week8;
/**
 * A class which can be utilized to create Pterodactyl objects. Pterodactyl is a
 * subclass of Dinosaur and will, thus, contain a name, height, width, and
 * weight alongside a flightCeiling.
 * Pterodactyls are be capable of calculating their own, custom enclosure size.
 *
 * @author Felipe Bergerman
 * @version 1.0
 */

public class Pterodactyl extends Dinosaur {

    private double flightCeiling;

    /**
     * Creates a new Pterodactyl object with the following parameters. Makes
     * reference to the Dinosaur constructor.
     *
     * @param name          a String representing the name of a Pterodactyl
     * @param height        a double representing the height of a Pterodactyl
     * @param width         a double representing the width of a Pterodactyl
     * @param weight        a double representing the weight of a Pterodactyl
     * @param flightCeiling a double representing the flight ceiling of a
     *                      Pterodactyl
     */
    public Pterodactyl(String name, double height, double width, double weight, double flightCeiling) {
        super(name, height, width, weight);
        this.flightCeiling = makeFlightCeilingInRange(flightCeiling);
    }

    /**
     * Creates a new Pterodactyl object by accepting a name and width and sets all
     * other instance variables to their defaults.
     *
     * @param name  a String representing the name of a Pterodactyl
     * @param width a double representing the width of a Pterodactyl
     */
    public Pterodactyl(String name, double width) {
        this(name, 15, width, 1000, 50);
    }

    /**
     * Creates a new Pterodactyl object by accepting a name and sets all other
     * instance variables to their defaults.
     *
     * @param name a String representing the name of a Pterodactyl
     */
    public Pterodactyl(String name) {
        this(name, 15, 12, 1000, 50);
    }

    /**
     * Creates a new Pterodactyl object with all instance variables intialized to
     * their defaults.
     */
    public Pterodactyl() {
        this("Barney", 15, 12, 1000, 50);
    }

    /**
     * Creates a deepcopy of the Pterodactyl p.
     *
     * @param p a Pterodactyl object.
     */
    public Pterodactyl(Pterodactyl p) {
        this(p.getName(), p.getHeight(), p.getWidth(), p.getWeight(), p.getFlightCeiling());
    }

    /**
     * Sets the flight ceiling for a given Pterodactyl.
     *
     * @param flightCeil a double representing the new flight ceiling.
     */
    public void setFlightCeiling(double flightCeil) {
        this.flightCeiling = makeFlightCeilingInRange(flightCeil);
    }

    /**
     * Gets the flight ceilling for a given Pterodactyl.
     *
     * @return the flight ceiling as a double.
     */
    public double getFlightCeiling() {
        return this.flightCeiling;
    }

    /**
     * Gets the enclosure size for a given Pterodactyl by multiplying its height,
     * width, and the constant 4, then adding its flight ceiling.
     *
     * @return the enclosure size as a double.
     */
    public double enclosureSize() {
        return (4 * super.getWidth() * super.getHeight()) + this.flightCeiling;
    }

    /**
     * Formats a string detailing a given Pterodactyl's name, flight
     * ceiling, and other instance data,
     * as dictated by the Dinosaur's toString method.
     *
     * @return the formatted String
     */
    public String toString() {
        return String.format("%s can fly %.2f feet into the air! %s", super.getName(), this.flightCeiling,
                super.toString());
    }

    /**
     * A helper method which ensures that the flight ceiling for a given Pterodactyl
     * is in range.
     *
     * @param flightCeil a double representing a potential new flight celing
     * @return flightCeil as a double if it is in range [10, 90]. Otherwise 50.
     */
    private double makeFlightCeilingInRange(double flightCeil) {
        if (flightCeil >= 10 && flightCeil <= 90) {
            return flightCeil;
        } else {
            return 50;
        }
    }
}
