package Week7;
public class Card {
    private int hitPoints;
    private String pokemonName;
    private PokemonType pokemonType;
    private String attack;
    private int condition;

    public Card(int hitPoints, String pokemonName, PokemonType pokemonType, String attack, int condition) {
        this.hitPoints = hitPoints;
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
        this.attack = attack;
        this.condition = makeConditionInRange(condition);

        printCondition(this.condition);
    }

    public Card(int hitPoints, String pokemonName, PokemonType pokemonType) {
        this.hitPoints = hitPoints;
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
        this.attack = "Hyperbeam";
        this.condition = 80;

        printCondition(this.condition);
    }

    public Card() {
        this.hitPoints = 120;
        this.pokemonName = "Ditto";
        this.pokemonType = PokemonType.NORMAL;
        this.attack = "Imposter";
        this.condition = 89;

        printCondition(this.condition);
    }

    public boolean isRestorable() {
        if (this.condition >= 50 && this.condition <= 89) {
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format("<%d,%s,%s,%s,%d,%b>", this.hitPoints, this.pokemonName, this.pokemonType.name(),
                this.attack, this.condition, this.isRestorable());
    }

    public int getCondition() {
        return this.condition;
    }

    public void setCondition(int cond) {
        this.condition = makeConditionInRange(cond);
    }

    private void printCondition(int cond) {
        if (cond >= 90) {
            System.out.println("Card condition: Mint");
        } else if (cond >= 80) {
            System.out.println("Card condition: Excellent");
        } else if (cond >= 70) {
            System.out.println("Card condition: Very Good");
        } else if (cond >= 60) {
            System.out.println("Card condition: Good");
        } else if (cond >= 50) {
            System.out.println("Card condition: Fine");
        } else {
            System.out.println("Card condition: Damaged");
        }
    }

    private int makeConditionInRange(int cond) {
        if (cond < 40 || cond > 100) {
            return 80;
        }
        return cond;
    }
}
