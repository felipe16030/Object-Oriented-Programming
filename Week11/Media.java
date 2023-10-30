package Week11;

import java.util.ArrayList;

/**
 * Abstract class that defines a Media object. Implements the comparable
 * interface.
 *
 * @author Felipe Bergerman
 * @version 1.1
 */
public abstract class Media implements Comparable<Media> {
    private Genre genre;
    private String name;
    private int rating;
    private double rentalPrice;

    /**
     * Constructor for a Media object. Accepts genre, name, rating, and rentalPrice.
     *
     * @param genre       enum that represents the genre of the Media
     * @param name        String that represents the name of the Media
     * @param rating      double that represents the rating of the Media
     * @param rentalPrice double that represents the rental price of the Media
     */
    public Media(Genre genre, String name, int rating, double rentalPrice) {
        this.genre = genre;
        this.name = name;
        this.rating = rating;
        this.rentalPrice = rentalPrice;
    }

    /**
     * Constructor for a Media object. Accepts genre, name, and rating. Defaults
     * rentalPrice to 7.
     *
     * @param genre  enum that represents the genre of the Media
     * @param name   String that represents the name of the Media
     * @param rating double that represents the rating of the Media
     */
    public Media(Genre genre, String name, int rating) {
        this(genre, name, rating, 7);
    }

    /**
     * Creates a String representation of a Media.
     *
     * @return a formatted String including genre, name, rating, and rental price.
     */
    public String toString() {
        return String.format("Genre: %s, Name: %s, Rating: %d, Rental Price: $%.2f", this.genre.name(), this.name,
                this.rating, this.rentalPrice);
    }

    /**
     * Checks for equality between 2 Media objects.
     *
     * @param other another objected to be checked for equality
     * @return true if the objects are equal, false otherwise
     */
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (!(other instanceof Media)) {
            return false;
        } else {
            Media m = (Media) other;
            if (m.getGenre() == this.genre && m.getName().equals(this.name) && m.rating == this.rating
                    && m.rentalPrice == this.rentalPrice) {
                return true;
            }
            return false;
        }
    }

    /**
     * Compares 2 Media objects based on genre carinality first, name second, and
     * rating third.
     *
     * @param m another Media to be compared to
     * @return int based on the difference between the two objects
     */
    @Override
    public int compareTo(Media m) {
        if (this.genre != m.getGenre()) {
            return this.genre.ordinal() - m.getGenre().ordinal();
        } else if (!this.name.equals(m.getName())) {
            return this.name.compareTo(m.getName());
        } else if (this.rating != m.getRating()) {
            return this.rating - m.getRating();
        } else {
            return 0;
        }
    }

    /**
     * Gets the Media genre.
     *
     * @return Genre of the Media
     */
    public Genre getGenre() {
        return this.genre;
    }

    /**
     * Gets the Media name.
     *
     * @return String name of the Media
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the rating of the Media.
     *
     * @return double rating of the Media
     */
    public int getRating() {
        return this.rating;
    }

    /**
     * Gets the rentalPrice of the Media.
     *
     * @return double rentalPrice of the Media
     */
    public double getRentalPrice() {
        return this.rentalPrice;
    }
}
