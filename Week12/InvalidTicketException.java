package Week12;
/**
 * Class that defines an InvalidTicketException that is checked.
 *
 * @author Felipe Bergerman
 * @version 1.1
 */
public class InvalidTicketException extends Exception {
    /**
     * Constructor that creates an InvalidTicketException.
     *
     * @param errMessage String representing an error message
     */
    public InvalidTicketException(String errMessage) {
        super(errMessage);
    }

    /**
     * Constructor that creates an InvalidTicketException with a default error
     * message.
     */
    public InvalidTicketException() {
        this("Invalid ticket");
    }
}
