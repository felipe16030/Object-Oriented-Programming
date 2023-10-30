package Week14;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class that defines a LineIterator object that is of a generic type.
 *
 * @author Felipe Bergerman
 * @version 1.1
 * @param <T> a generic type passed in
 */
public class LineIterator<T> implements Iterator<T> {

    private Person<T> nextPerson;

    /**
     * Constructor that defines a LineIterator object.
     *
     * @param line a Line object passed in that the LineIterator is meant to iterate
     *             for.
     */
    public LineIterator(Line<T> line) {
        if (line == null) {
            throw new IllegalArgumentException("line passed in is null");
        }
        this.nextPerson = line.getFirstPerson();
    }

    @Override
    public boolean hasNext() {
        if (this.nextPerson == null) {
            return false;
        }
        return true;
    }

    @Override
    public T next() {
        if (this.hasNext()) {
            throw new NoSuchElementException("No next element");
        }

        T currentParcel = this.nextPerson.getParcel();
        this.nextPerson = this.nextPerson.getNextPerson();
        return currentParcel;
    }

}
