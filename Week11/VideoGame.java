package Week11;
/**
 * Class that defines a VideoGame object which is-a type of Media.
 *
 * @author Felipe Bergerman
 * @version 1.1
 */
public class VideoGame extends Media {
    private int maxPlayers;
    private boolean needsConsole;

    /**
     * Constructor for a VideoGame object. Accepts a genre, name, rating,
     * rentalPrice, and needsConsole.
     *
     * @param genre        Genre that represents the Genre of a VideoGame
     * @param name         String that represents the name of a VideoGame
     * @param rating       double that represents the rating of a VideoGame
     * @param rentalPrice  double that represents the rating of a VideoGame
     * @param maxPlayers   int that represents the max number of players of a
     *                     VideoGame
     * @param needsConsole boolean that represents whether a VideoGame requires a
     *                     console to play
     */
    public VideoGame(Genre genre, String name, int rating, double rentalPrice, int maxPlayers, boolean needsConsole) {
        super(genre, name, rating, rentalPrice);
        this.maxPlayers = maxPlayers;
        this.needsConsole = needsConsole;
    }

    /**
     * Constructor for a VideoGame object. Accepts a genre, name, and rating.
     * Defaults rentalPrice to 5, maxPlayers to 2, and needsConsole to false.
     *
     * @param genre       Genre that represents the Genre of a VideoGame
     * @param name        String that represents the name of a VideoGame
     * @param rating      double that represents the rating of a VideoGame
     */
    public VideoGame(Genre genre, String name, int rating) {
        this(genre, name, rating, 5, 2, false);
    }

    /**
     * Creates a String representation of a VideoGame.
     *
     * @return a String containing a VideoGame's maxPlayers, genre, name, and
     *         whether it requires a console.
     */
    public String toString() {
        String needsConsleString = needsConsole ? "needs" : "does not need";
        return String.format("This is a %d-player %s video game called %s that %s a gaming console to play.",
                this.maxPlayers, this.getGenre().name(), this.getName(), needsConsleString);
    }

    /**
     * Checks for equality of 2 Objects.
     *
     * @param other another Object to be checked for equality
     * @return true if the 2 Objects are equal, false otherwise
     */
    public boolean equals(Object other) {
        if (!(super.equals(other)) || !(other instanceof VideoGame)) {
            return false;
        }
        VideoGame v = (VideoGame) other;
        if (this.maxPlayers == v.getMaxPlayers() && this.needsConsole == v.getNeedsConsole()) {
            return true;
        }
        return false;
    }

    /**
     * Gets the maxPlayers of a VideoGame.
     *
     * @return int maxPlayers
     */
    public int getMaxPlayers() {
        return this.maxPlayers;
    }

    /**
     * Gets the needsConsole of a VideoGame.
     *
     * @return boolean needsConsole
     */
    public boolean getNeedsConsole() {
        return this.needsConsole;
    }
}
