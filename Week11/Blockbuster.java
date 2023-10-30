package Week11;
import java.util.ArrayList;

/**
 * Class for a Blockbuster object.
 *
 * @author Felipe Bergerman
 * @version 1.1
 */
public class Blockbuster {
    private ArrayList<Media> mediaItems;

    /**
     * Constructor for a Blockbuster object. Instantiates a Blockbuster's
     * mediaItems.
     */
    public Blockbuster() {
        this.mediaItems = new ArrayList<Media>();
    }

    /**
     * Adds Media to a Blockbuster's mediaItems.
     *
     * @param m Media to be added to mediaItems
     */
    public void addMedia(Media m) {
        this.mediaItems.add(m);
    }

    /**
     * Removes a Media from mediaItems.
     *
     * @param m the Media to be removed
     * @return the Media item removed, null if no item was removed
     */
    public Media removeMedia(Media m) {
        for (int i = 0; i < this.mediaItems.size(); i++) {
            if (this.mediaItems.get(i).equals(m)) {
                Media mediaRemoved = this.mediaItems.get(i);
                this.mediaItems.remove(i);
                return mediaRemoved;
            }
        }
        return null;
    }

    /**
     * Sorts the mediaItem list using selection sort in O(n^2) time.
     */
    public void sortMedia() {
        for (int i = 0; i < this.mediaItems.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < this.mediaItems.size(); j++) {
                if (this.mediaItems.get(j).compareTo(this.mediaItems.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            Media tempMedia = this.mediaItems.get(minIndex);
            this.mediaItems.set(minIndex, this.mediaItems.get(i));
            this.mediaItems.set(i, tempMedia);
        }
    }

    /**
     * Finds a specific media from mediaItems using Binary Search in O(log(n)) time.
     *
     * @param m the Media to be found
     * @return the Media found or null if no Media is found
     */
    public Media findMedia(Media m) {
        this.sortMedia();
        int leftIndex = 0;
        int rightIndex = this.mediaItems.size() - 1;
        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (m.compareTo(this.mediaItems.get(middleIndex)) < 0) {
                rightIndex = middleIndex - 1;
            } else if (m.compareTo(this.mediaItems.get(middleIndex)) > 0) {
                leftIndex = middleIndex + 1;
            } else {
                return this.mediaItems.get(middleIndex);
            }
        }
        return null;
    }

    /**
     * Finds the most popular Movie in mediaItems based on rating first then name.
     *
     * @return formatted String containing the Movie rating and name, or a default
     *         String if no Movies are in media Items
     */
    public String mostPopularMovie() {
        int maxIndex = 0;
        boolean foundMovie = false;
        for (int i = 0; i < this.mediaItems.size(); i++) {
            if (this.mediaItems.get(i) instanceof Movie) {
                foundMovie = true;
                if (this.mediaItems.get(i).getRating() > this.mediaItems.get(maxIndex).getRating()) {
                    maxIndex = i;
                } else if (this.mediaItems.get(i).getRating() == this.mediaItems.get(maxIndex).getRating()) {
                    if (this.mediaItems.get(i).getName().compareTo(this.mediaItems.get(maxIndex).getName()) > 0) {
                        maxIndex = i;
                    }
                }
            }
        }
        if (foundMovie) {
            return String.format("With a rating of %d, our customers enjoy watching %s the most!",
                    this.mediaItems.get(maxIndex).getRating(), this.mediaItems.get(maxIndex).getName());
        } else {
            return "No movies were found.";
        }
    }
}
