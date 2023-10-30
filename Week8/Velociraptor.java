package Week8;
/**
 * A class which can be utilized to create Velociraptor objects. Velociraptor is
 * a subclass of Dinosaur and will, thus, contain a name, height, width, and
 * weight alongside a speed and Pack.
 * Velociraptor are be capable of calculating their own, custom enclosure size
 * and food required.
 *
 * @author Felipe Bergerman
 * @version 1.0
 */

public class Velociraptor extends Dinosaur {
    private int speed;
    private Pack pack;

    /**
     * Creates a new Velociraptor object with the following parameters. Makes
     * reference to the Dinosaur constructor.
     *
     * @param name   a String representing the name of a Velociraptor
     * @param height a double representing the height of a Velociraptor
     * @param width  a double representing the width of a Velociraptor
     * @param weight a double representing the weight of a Velociraptor
     * @param speed  a double representing the speed of a Velociraptor
     * @param pack   a Pack representing the Pack in which a Velociraptor is in
     */
    public Velociraptor(String name, double height, double width, double weight, int speed, Pack pack) {
        super(name, height, width, weight);
        this.speed = speed;
        this.pack = pack;
    }

    /**
     * Creates a new Velociraptor object by accepting a name and height. All other
     * instance variables are set to their defaults.
     *
     * @param name   A string representing the name of a Velociraptor
     * @param height a double representing the height of a Velociraptor
     */
    public Velociraptor(String name, double height) {
        this(name, height, 20, 1000, 30, null);
    }

    /**
     * Creates a deep copy of Velociraptor v.
     *
     * @param v a Velociraptor object.
     */
    public Velociraptor(Velociraptor v) {
        this(v.getName(), v.getHeight(), v.getWidth(), v.getWeight(), v.getSpeed(),
                new Pack(v.pack.getPackSize(), v.pack.getPackName()));
    }

    /**
     * Creates a new Velociraptor with all instance data set to their defaults.
     */
    public Velociraptor() {
        this("Barney", 15, 20, 1000, 30, null);
    }

    /**
     * Gets the speed of a given Velociraptor.
     *
     * @return the speed of a Velociraptor as an int.
     */
    public int getSpeed() {
        return this.speed;
    }

    /**
     * Calculates the necessary enclosure size of a Velociraptor. The enclosure size
     * is equal to 4 multiplied by its height multiplied by its width if the
     * Velociraptor is not in a pack. Otherwise the enclosure size is the pack size
     * multiplied by its height multiplied by its width.
     *
     * @return the enclosure size as a double.
     */
    @Override
    public double enclosureSize() {
        if (this.pack == null) {
            return 4 * super.getHeight() * super.getWidth();
        } else {
            return pack.getPackSize() * super.getWidth() * super.getHeight();
        }
    }

    /**
     * Calculates the food required by a Velociraptor. This is equal to its weight
     * multiplied by its speed multiplied by its height.
     *
     * @return the food required as a double
     */
    public double calculateFood() {
        return super.getWeight() * this.speed * super.getHeight();
    }

    /**
     * Gets the Pack to which a Velociraptor belongs to.
     *
     * @return the pack as a Pack
     */
    public Pack getPack() {
        return this.pack;
    }

    /**
     * Sets the speed of a Velociraptor.
     *
     * @param spd an integer representing speed
     */
    public void setSpeed(int spd) {
        this.speed = spd;
    }

    /**
     * Sets the pack that a Velociraptor belongs to.
     *
     * @param p a Pack representing a pack to which the Velociraptor will belong/.
     */
    public void setPack(Pack p) {
        this.pack = p;
    }

    /**
     * Formats a String which indicates a Velociraptor's pack and pack size and
     * other instance data as dictated by the Dinosar toString.
     *
     * @return the formatted String.
     */
    public String toString() {
        if (this.pack == null) {
            return super.toString();
        }
        return this.pack.getPackName() + " is a family of dinosaurs of size " + this.pack.getPackSize() + "! "
                + super.toString();
    }
}
