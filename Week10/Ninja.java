
/**
 * Abstract class for a Ninja object.
 *
 * @author Felipe Bergerman
 * @version 1.1
 */
public abstract class Ninja implements Comparable<Ninja> {
    private String name;
    private int health;
    private int attack;

    /**
     * Constructor that accepts a name, health, and attack.
     *
     * @param name   String representing the ninja name
     * @param health int representing the ninja health
     * @param attack int representing the ninja attack
     */
    public Ninja(String name, int health, int attack) {
        if (name == null || name.equals("")) {
            this.name = "Naruto Uzumaki";
        } else {
            this.name = name;
        }
        if (health <= 0) {
            this.health = 1;
        } else {
            this.health = health;
        }
        if (attack < 2) {
            this.attack = 2;
        } else {
            this.attack = attack;
        }
    }

    /**
     * Method that determines if a Ninja has fainted based on their health.
     *
     * @return true if health <= 0, false otherwise
     */
    public boolean hasFainted() {
        if (this.health <= 0) {
            return true;
        }
        return false;
    }

    /**
     * Method in which this Ninja is attacked.
     *
     * @param damage int representing how much damage is taken.
     */
    public void getAttacked(int damage) {
        if (!(damage <= 0)) {
            this.health -= damage;
        }
    }

    /**
     * Method that enables a Ninja to attack another Ninja.
     *
     * @param n The Ninja to be attacked.
     */
    public void attackNinja(Ninja n) {
        n.getAttacked(this.attack);
    }

    /**
     * Method that returns a String representation of a Ninja.
     *
     * @return A formatted String containing a Ninja's name, attack, and health.
     */
    public String toString() {
        return String.format("%s/%d/%d", this.name, this.attack, this.health);
    }

    /**
     * A getter method for a Ninja's health.
     *
     * @return Ninja's health as an int.
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * A getter method for a Ninja's attack.
     *
     * @return Ninja's attack as an int.
     */
    public int getAttack() {
        return this.attack;
    }

    /**
     * A method that compares 2 Ninja based on their attack and health stats.
     *
     * @param n The Ninja being compared to
     * @return an int determined by subtracting the attack and health from one Ninja
     *         from another. A null input returns 1.
     */
    public int compareTo(Ninja n) {
        if (n == null) {
            return 1;
        }
        return ((this.attack + this.health) - (n.getAttack() + n.getHealth()));
    }
}
