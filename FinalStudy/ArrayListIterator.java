package FinalStudy;
import java.util.Iterator;

public class ArrayListIterator<E> implements Iterator<E> {

    private int index;
    private ArrayList<E> backingList;

    public ArrayListIterator(ArrayList<E> arrList) {
        backingList = arrList;
        index = 0;
    }

    public E next() {
        if(hasNext()) {
            E element = (E) backingList.getBackingArray()[index];
            index++;
            return element;
        }
        throw new IndexOutOfBoundsException("Invalid index");
    }

    public boolean hasNext() {
        if(index > backingList.size()-1) {
            return false;
        }
        return true;
    }
}