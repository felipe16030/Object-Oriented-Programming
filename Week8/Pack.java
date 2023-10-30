package Week8;
/**
 * A class which can be utilized to create Pack objects. Packs will contain a
 * size and a name. Certain Dinosaur's can belong to Packs
 *
 * @author Felipe Bergerman
 * @version 1.0
 */

public class Pack {
    private final int size;
    private final String packName;

    /**
     * Creates a new Pack object with the following parameters.
     *
     * @param size     an int representing the how many Dinosaurs are in the Pack.
     * @param packname a String representing the name of the Pack. The Pack name is
     *                 set to "The Power Pack" if packName is invalid.
     */
    public Pack(int size, String packname) {
        this.size = makeSizeInRange(size);
        if (isValidName(packname)) {
            this.packName = packname;
        } else {
            this.packName = "The Power Pack";
        }
    }

    /**
     * Formats a string containing a Pack's name and its size.
     *
     * @return the formatted string.
     */
    public String toString() {
        return this.packName + " is a family of dinosaurs of size " + this.size + "!";
    }

    /**
     * Gets the Pack name.
     *
     * @return the Pack name as a String.
     */
    public String getPackName() {
        return this.packName;
    }

    /**
     * Gets the Pack size.
     *
     * @return the Pack size as an int.
     */
    public int getPackSize() {
        return this.size;
    }

    /**
     * A helper method which is used to make sure size is in range [0, ∞]
     *
     * @param sz an int representing a potential size for a pack
     * @return sz as an int if it is in range. Otherwise, 4.
     */
    private int makeSizeInRange(int sz) {
        if (sz < 0) {
            return 4;
        }
        return sz;
    }

    /**
     * A helper method which determines if a String name for a pack is valid. A name
     * is valid if it is neither null not empty
     *
     * @param name a String representing the name of a Pack
     * @return true if name is valid. Otherwise, false.
     */
    private boolean isValidName(String name) {
        if (name == null || name.equals("")) {
            return false;
        }
        return true;
    }
}
