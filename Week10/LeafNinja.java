
/**
 * Class for a LeafNinja object, which is a subclass of Ninja.
 *
 * @author Felipe Bergerman
 * @version 1.1
 */
public class LeafNinja extends Ninja {
    private int poisonAmount;

    /**
     * Constructor that accepts a name, health, attack, and poison amount.
     *
     * @param name         String representing the name of a LeafNinja
     * @param health       int representing the health of a LeafNinja
     * @param attack       int representing the attack of a LeafNinja
     * @param poisonAmount int representing the poison amount of a LeafNinja
     */
    public LeafNinja(String name, int health, int attack, int poisonAmount) {
        super(name, health, attack);
        if (poisonAmount <= 0) {
            this.poisonAmount = 5;
        } else {
            this.poisonAmount = poisonAmount;
        }
    }

    /**
     * Default 0 arg constructor.
     */
    public LeafNinja() {
        this("Naruto Uzumaki", 5, 9, 10);
    }

    /**
     * Getter method which gets the poison amount.
     *
     * @return poison amount as an int
     */
    public int getPoisonAmount() {
        return this.poisonAmount;
    }

    /**
     * A class specific attack which varies its affect depending on who the
     * target is. If a StoneNinja is targetted, their ninja armor breaks.
     * If a MistNinja is attacked, their hit chance is incremented. If a LeafNinja
     * is the target, the greater of the 2 LeafNinjas will add 2 to their poison
     * amount.
     *
     * @param n Ninja to be attacked
     */
    public void poisonAttack(Ninja n) {
        if (this.poisonAmount > 0) {
            if (n instanceof StoneNinja) {
                StoneNinja ninja = (StoneNinja) n;
                if (ninja.getNinjaArmor()) {
                    ninja.breakArmor();
                }
                this.poisonAmount--;
            } else if (n instanceof MistNinja) {
                MistNinja ninja = (MistNinja) n;
                ninja.getConfused();
                this.poisonAmount--;
            } else if (n instanceof LeafNinja) {
                LeafNinja ninja = (LeafNinja) n;
                if (super.compareTo(ninja) > 0) {
                    this.poisonAmount += 2;
                } else if (super.compareTo(ninja) < 0) {
                    ninja.poisonAmount += 2;
                }
            }
        }
    }

    /**
     * Method that attacks another Ninja, first with poison, then with a regular
     * attack.
     *
     * @param n the Ninja to be attacked
     */
    public void attackNinja(Ninja n) {
        this.poisonAttack(n);
        if (this.poisonAmount == 0) {
            n.getAttacked((this.getAttack() / 2));
        } else {
            n.getAttacked(super.getAttack());
        }
    }

    /**
     * Method that returns a String representation of a LeafNinja.
     *
     * @return a formatted String that contains a LeafNinja's name, health, attack,
     *         and poison amount.
     */
    public String toString() {
        return String.format("Leaf Ninja: %s/%d", super.toString(), this.poisonAmount);
    }
}
