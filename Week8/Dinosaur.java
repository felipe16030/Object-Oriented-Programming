package Week8;
/**
 * A class which will be utilized to construct Dinosaur objects. Dinosaurs will
 * have a name, height, width, and weight. A static variable will track the
 * total amount of enclosures built for all Dinosaurs. Dinosaurs are also
 * capable of building enclosures and calculating the food they require. This
 * is a Superclass to Pterodactyls and Velociraptos
 *
 * @author Felipe Bergerman
 * @version 1.0
 */

public class Dinosaur {
    protected final String name;
    private double height;
    private double width;
    private double weight;

    protected static int totalEnclosures;

    /**
     * Creates a new Dinosaur object with the following parameters.
     *
     * @param name   a String which represents the name of a Dinosaur
     * @param height a double which represents the height of a Dinosaur
     * @param width  a double which represents the width of a Dinosaur
     * @param weight a double which represents the weight of a Dinosaur
     */
    public Dinosaur(String name, double height, double width, double weight) {
        if (isValidName(name)) {
            this.name = name;
        } else {
            this.name = "Barney";
        }
        this.height = height;
        this.width = width;
        this.weight = weight;
    }

    /**
     * Creates a deep copy of Dinosaur d.
     *
     * @param d Another Dinosaur object.
     */
    public Dinosaur(Dinosaur d) {
        this(d.getName(), d.getHeight(), d.getWidth(), d.getWeight());
    }

    /**
     * Creates a new Dinosaur object with default parameters.
     */
    public Dinosaur() {
        this("Barney", 15, 20, 1000);
    }

    /**
     * Gets a Dinosaur's name.
     *
     * @return a Dinosaur's name as a String.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Calculates a given Dinosaur's enclosure size.
     *
     * @return the enclosure size as a double
     */
    public double enclosureSize() {
        return 10 * this.width * this.height;
    }

    /**
     * Calculates the food required for a given Dinosaur.
     *
     * @return the food as a double.
     */
    public double calculateFood() {
        return this.weight * this.width * this.height;
    }

    /**
     * Formats a string detailing the Dinosaur's name, enclosure size, and required
     * food.
     *
     * @return the formatted string.
     */
    public String toString() {
        return String.format("%s requires a %.2f square foot enclosure and %.2f pounds of food.", this.name,
                this.enclosureSize(), this.calculateFood());
    }

    /**
     * Builds an enclosure if the Dinosaur is within the given bounds and updates
     * the static variable totalEnclosures.
     *
     * @return a string stating a Dinosaur has been added to a park if it is within
     *         the bounds. Otherwise a string stating the Dinosaur is too expensive
     *         for the park.
     */
    public String buildEnclosure() {
        if (enclosureSize() > 6000 || calculateFood() > 80000) {
            return toString() + " " + this.name + " is too expensive for the park!";
        } else {
            Dinosaur.totalEnclosures++;
            return toString() + " " + this.name + " has been added to the park!";
        }
    }

    /**
     * Gets the total enclosures for all Dinosaurs.
     *
     * @return the static integer totalEnclosures.
     */
    public static int getTotalEnclosures() {
        return Dinosaur.totalEnclosures;
    }

    /**
     * Sets the height of a given Dinosaur.
     *
     * @param height a double representing the height of a Dinosaur.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Sets the width of a given Dinosar.
     *
     * @param width a double representing the width of a Dinosaur
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Sets the weight of a given Dinosaur.
     *
     * @param weigth a double representing the weight of a Dinosaur.
     */
    public void setWeight(double weigth) {
        this.weight = weigth;
    }

    /**
     * Gets the height of a given Dinosaur.
     *
     * @return the height of a Dinosaur as a double.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Gets the width of a given Dinosaur.
     *
     * @return the width of a Dinosaur as a double.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Gets the weight of a given Dinosaur.
     *
     * @return the weight of a Dinosaur as a double.
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * Helper method that determines if a string patameter is a valid name for a
     * Dinosaur.
     *
     * @param str a string that contains a potential name for a Dinosaur.
     * @return true if the String is neither null nor empty. False otherwise.
     */
    private boolean isValidName(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        return true;
    }
}