/**
 * Class that acts solely as a drive to test the Ride, RollerCoaster, and
 * Trolley classes.
 *
 * @author Felipe Bergerman
 * @version 1.1
 */
public class Driver {
    /**
     * Main executable string.
     *
     * @param args Array of strings that contains java command line arguemnts
     */
    public static void main(String[] args) {

        RollerCoaster r1 = new RollerCoaster("Blitz", 0, new String[3], 5.5, 10, 100);
        RollerCoaster r2 = new RollerCoaster("Blitz", 0, new String[3], 5.5, 10, 100);
        System.out.println(r1.equals(r2));
        String[] passengers = {"Bob", "Mike"};
        r1.addPassengers(5, passengers);
        System.out.println(r1.equals(r2));
        System.out.println(r1);
        System.out.println(r2);

        String[] stations = {"0", "1", "2", "3"};
        Trolley t1 = new Trolley("Carry", 0, stations, 0);
        Trolley t2 = new Trolley("Carry", 0, stations, 0);
        System.out.println(t1.equals(t2));
        t1.addPassengers(8, passengers);
        System.out.println(t1.equals(t2));
        System.out.println(t1);
        System.out.println(t2);
    }
}
