package Week11;
import java.util.ArrayList;

/**
 * Class that represents Oliva.
 *
 * @author Felipe Bergerman
 * @version 1.1
 */
public class Olivia {
    private static double budget;
    private static ArrayList<Media> cart;
    private static boolean canUseConsole;

    /**
     * Adds Media to Olivia's cart from a Blockbuster.
     *
     * @param m Media that Olivia checks out
     * @param b Blockbuster that Olivia is checking out from
     * @return true if she can add it to cart, false otherwise
     */
    public static boolean addToCart(Media m, Blockbuster b) {
        Media mediaToAdd = b.findMedia(m);
        if (mediaToAdd != null && mediaToAdd.getRentalPrice() <= Olivia.budget) {
            if (mediaToAdd instanceof VideoGame) {
                VideoGame v = (VideoGame) mediaToAdd;
                if (v.getNeedsConsole() && !canUseConsole) {
                    return false;
                }
            }
            Olivia.cart.add(b.removeMedia(mediaToAdd));
            Olivia.budget -= mediaToAdd.getRentalPrice();
            return true;
        }
        return false;
    }

    /**
     * Returns a specific Media from Olivia's cart to a Blockbuster.
     *
     * @param m The Media being returned
     * @param b The Blockbuster being returned to
     */
    public static void changeMind(Media m, Blockbuster b) {
        int index = 0;
        for (int i = 0; i < Olivia.cart.size(); i++) {
            if (Olivia.cart.get(i).equals(m)) {
                index = i;
                break;
            }
        }
        Olivia.budget += Olivia.cart.get(index).getRentalPrice();
        b.addMedia(Olivia.cart.remove(index));
    }
}
