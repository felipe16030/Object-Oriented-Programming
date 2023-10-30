package Week8;
/**
 * A driver class for the Dinosaurs.
 *
 * @author Felipe Bergerman
 * @version 1.0
 */
public class JurassicPark {

    /**
     * The main executable method.
     *
     * @param args stores java command line arguments.
     */
    public static void main(String[] args) {
        Dinosaur d1 = new Dinosaur("Dino", 15, 4, 1000);
        Dinosaur d2 = new Dinosaur(d1);
        Pterodactyl p1 = new Pterodactyl("Petey", 18, 5, 1500, 80);
        Pterodactyl p2 = new Pterodactyl(p1);
        Pack p = new Pack(6, "Dinos");
        Velociraptor v1 = new Velociraptor("Belly", 8, 4, 750, 30, p);
        Velociraptor v2 = new Velociraptor(v1);

        System.out.println(v1);
        System.out.println(v2);

        d2.buildEnclosure();
        p2.buildEnclosure();
        v2.buildEnclosure();

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(d1);
        System.out.println(d2);
    }
}
