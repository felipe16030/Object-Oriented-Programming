package Week11;
/**
 * Class for a Movie object which is-a type of Media.
 *
 * @author Felipe Bergerman
 * @version 1.1
 */
public class Movie extends Media {
    private int runtime;

    /**
     * Constructor for a Movie object. Accepts a genre, name, rating, rentalPrice,
     * and runtime.
     *
     * @param genre       Genre that represents the genre a Movie
     * @param name        String that represents the name of a Movie
     * @param rating      double that represents the rating of a Movie
     * @param rentalPrice double that represents the rentalPrice of a Movie
     * @param runtime     int that represents the runtime of a Movie
     */
    public Movie(Genre genre, String name, int rating, double rentalPrice, int runtime) {
        super(genre, name, rating, rentalPrice);
        this.runtime = runtime;
    }

    /**
     * Constructor for a Movie object. Accepts a genre, name, rating. Defaults
     * rentalPrice to 5 and runtime to 111.
     *
     * @param genre  Genre that represents the genre a Movie
     * @param name   String that represents the name of a Movie
     * @param rating double that represents the rating of a Movie
     */
    public Movie(Genre genre, String name, int rating) {
        this(genre, name, rating, 5, 111);
    }

    /**
     * Creates a String represntation of a Movie.
     *
     * @return a formatted String including genre, name, rating, rentalPrice, and
     *         runtime
     */
    public String toString() {
        return String.format("%s, Runtime: %d", super.toString(), this.runtime);
    }

    /**
     * Checks for equality between 2 objects.
     *
     * @param other another objects to be checked for equality
     * @return true if the 2 objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object other) {

        if (super.equals(other)) {
            if (other instanceof Movie) {
                Movie m = (Movie) other;
                if (m.getRuntime() == this.runtime) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Gets the runtime of a Movie.
     *
     * @return int runtime of a Movie
     */
    public int getRuntime() {
        return this.runtime;
    }
}
