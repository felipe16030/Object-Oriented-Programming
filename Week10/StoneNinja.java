
/**
 * Class for a StoneNinja object, which is a subclass of Ninja.
 *
 * @author Felipe Bergerman
 * @version 1.1
 */
public class StoneNinja extends Ninja {
    private boolean ninjaArmor;

    /**
     * Constructor that accepts a name, health, attack, and ninja armor.
     *
     * @param name       String representing the StoneNinja name
     * @param health     int representing the StoneNinja health
     * @param attack     int representing the StoneNinja attack
     * @param ninjaArmor boolean representing whether the StoneNinja has armor
     */
    public StoneNinja(String name, int health, int attack, boolean ninjaArmor) {
        super(name, health, attack);
        this.ninjaArmor = ninjaArmor;
    }

    /**
     * Default 0 arg constructor.
     */
    public StoneNinja() {
        this("Naruto Uzumaki", 8, 10, true);
    }

    /**
     * Method breaks the Ninja armor.
     */
    public void breakArmor() {
        this.ninjaArmor = false;
    }

    /**
     * Method in which this StoneNinja is attacked. StoneNinja's can absorb up to 20
     * damage if they have armor.
     *
     * @param damage int representing how much damage a StoneNinja is attacked by.
     */
    public void getAttacked(int damage) {
        if (ninjaArmor) {
            super.getAttacked(damage - 20);
            this.breakArmor();
        }
        super.getAttacked(damage);
    }

    /**
     * A getter method for whether this StoneNinja has armor.
     *
     * @return true if this StoneNinja has armor, false otherwise
     */
    public boolean getNinjaArmor() {
        return this.ninjaArmor;
    }

    /**
     * Method that returns a String representation of a StoneNinja.
     *
     * @return A formatted String containing a StoneNinja's name, health, attack,
     *         and ninja armor status.
     */
    public String toString() {
        return String.format("Stone Ninja: %s/%b", super.toString(), this.ninjaArmor);
    }
}
