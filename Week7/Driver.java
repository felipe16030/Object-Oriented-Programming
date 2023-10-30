package Week7;
public class Driver {
    public static void main(String[] args) {
        Collection c = new Collection(new Card[3]);
        Card c1 = new Card();
        c.addCard(0, c1);
        Card c2 = new Card(150, "Charizard", PokemonType.FIRE);
        c.addCard(1, c2);
        System.out.println(c);
    }
}
