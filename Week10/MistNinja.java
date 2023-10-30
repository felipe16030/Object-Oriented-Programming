
/**
 * Class for a MistNinja object, which is a subclass of Ninja.
 *
 * @author Felipe Bergerman
 * @version 1.1
 */
public class MistNinja extends Ninja {
    private int hitChance;

    /**
     * Constructor which accepts a name, health, attack, and hit chance.
     *
     * @param name      String representing the name of a MistNinja
     * @param health    int representing the health of a MistNinja
     * @param attack    int representing the attack of a MistNinja
     * @param hitChance int representing the hitChance of a MistNinja
     */
    public MistNinja(String name, int health, int attack, int hitChance) {
        super(name, health, attack);
        if (hitChance < 5 || hitChance > 15) {
            this.hitChance = 12;
        } else {
            this.hitChance = hitChance;
        }
    }

    /**
     * 0 arg default constructor.
     */
    public MistNinja() {
        this("Naruto Uzumaki", 7, 8, 12);
    }

    /**
     * Method which is invoked when attacked by a LeafNinja. Increments the
     * hitchance of a MistNinja.
     */
    public void getConfused() {
        if ((this.hitChance + 1) < 15) {
            this.hitChance++;
        }
    }

    /**
     * A method in which a MistNinja is attacked. MistNinjas can evade attacks, if
     * their hitChance divides the damage dealt.
     *
     * @param damage int representing how much damage a MistNinja is attacked with.
     */
    public void getAttacked(int damage) {
        if (!(damage % this.hitChance == 0)) {
            super.getAttacked(damage);
        }
    }

    /**
     * Method that returns a String representation of a MistNinja.
     *
     * @return A formatted String that includes a MistNinja's name, health, attack
     *         and hit chance.
     */
    public String toString() {
        return String.format("Mist Ninja: %s/%s", super.toString(), this.hitChance);
    }
}
