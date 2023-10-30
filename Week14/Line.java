package Week14;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class that defines a Line object.
 *
 * @author Felipe Bergerman
 * @version 1.1
 * @param <T> generic type passed in
 */
public class Line<T> implements List<T> {

    private Person<T> firstPerson;
    private int size;

    /**
     * Constructor for a Line Object. Accepts an array containing parcels that each
     * Person in the list will hold in that order.
     *
     * @param parcel the array of parcel objects
     */
    public Line(T[] parcel) {
        if (parcel == null) {
            throw new IllegalArgumentException("parcel array passed in is null or parcel is empty");
        } else if (parcel.length >= 2) {
            this.firstPerson = new Person<T>(parcel[0], null);
            Person<T> currentPerson = new Person<T>(null, null);
            Person<T> previousPerson = new Person<T>(null, null);
            for (int i = 0; i < parcel.length - 1; i++) {
                if (parcel[i] == null) {
                    throw new IllegalArgumentException("Null value in parcel array");
                } else if (i == 0) {
                    currentPerson = new Person<T>(parcel[1], null);
                    this.firstPerson = new Person<T>(parcel[0], currentPerson);
                    previousPerson = currentPerson;
                } else {
                    currentPerson = new Person<T>(parcel[i + 1], null);
                    previousPerson.setNextPerson(currentPerson);
                    previousPerson = currentPerson;
                }
            }
        } else if (parcel.length == 1) {
            this.firstPerson = new Person<T>(parcel[0], null);
        } else {
            this.firstPerson = null;
        }
        this.size = parcel.length;
    }

    /**
     * Builds an empty line.
     */
    public Line() {
        this.firstPerson = null;
        this.size = 0;
    }

    /**
     * Gets the first person in line.
     *
     * @return the first person in line
     */
    public Person<T> getFirstPerson() {
        return firstPerson;
    }

    /**
     * Takes each item from the parcels held by the people in line and puts them
     * into an array.
     *
     * @return the array of parcel items.
     */
    public T[] toArray() {
        Iterator<T> iterator = this.iterator();
        T[] arr = (T[]) new Object[this.size];
        int counter = 0;
        while (iterator.hasNext()) {
            arr[counter] = iterator.next();
            counter++;
        }
        return arr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                String.format("===== LINE %d =====\nisEmpty: %b\nsize: %d\nfirstPerson: %s\n: [",
                        hashCode(),
                        isEmpty(),
                        size(),
                        (firstPerson == null ? "null" : firstPerson.getParcel())));

        T[] people = toArray();
        if (people == null) {
            sb.append("TODO: Implement toArray method...");
        } else {
            for (int i = 0; i < people.length - 1; ++i) {
                sb.append(String.format("%s, ", people[i])); // append all but last value
            }
            if (people.length > 0) {
                sb.append(String.format("%s", people[people.length - 1])); // append last value
            }
        }
        sb.append("]\n============================");
        return sb.toString();
    }

    @Override
    public void add(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("element passed in is null");
        } else if (size == 0) {
            this.firstPerson = new Person<T>(element, null);
        } else if (size == 1) {
            this.firstPerson.setNextPerson(new Person<T>(element, null));
        } else {
            Person<T> currPerson = this.firstPerson;
            for (int i = 0; i < this.size - 1; i++) {
                currPerson = currPerson.getNextPerson();
            }
            currPerson.setNextPerson(new Person<T>(element, null));
        }
        size++;
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if ((index > this.size || index < 0) && element == null) {
            throw new IndexOutOfBoundsException("index passed in is out of bounds and element is null");
        } else if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException("index passed in is larger than the list size");
        } else if (element == null) {
            throw new IllegalArgumentException("element passed in is null");
        } else {
            if (this.size == 0) {
                this.firstPerson = new Person<T>(element, null);
            } else if (index == 0) {
                Person<T> originalFirstPerson = this.firstPerson;
                this.firstPerson = new Person<T>(element, originalFirstPerson);
            } else {
                Person<T> currPerson = this.firstPerson;
                for (int i = 0; i < index - 1; i++) {
                    currPerson = currPerson.getNextPerson();
                }
                Person<T> originalPerson = currPerson.getNextPerson();
                currPerson.setNextPerson(new Person<T>(element, originalPerson));
            }
            this.size++;
        }
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (this.size == 0) {
            throw new NoSuchElementException("list is empty");
        }
        Person<T> initialPerson = this.firstPerson;
        this.firstPerson = firstPerson.getNextPerson();
        this.size--;
        return initialPerson.getParcel();
    }

    @Override
    public T remove(int index) throws NoSuchElementException, IndexOutOfBoundsException {
        if ((index > this.size - 1 || index < 0) && size == 0) {
            throw new NoSuchElementException("index is invalid and the list is empty");
        } else if (this.size == 0) {
            throw new NoSuchElementException("the list is empty");
        } else if ((index > this.size - 1 || index < 0)) {
            throw new IndexOutOfBoundsException("index is invalid");
        } else {
            Person<T> personReturned;
            if (size == 1) {
                personReturned = this.firstPerson;
                this.firstPerson = null;
            } else if (index == 0) {
                personReturned = this.firstPerson;
                this.firstPerson = this.firstPerson.getNextPerson();
            } else if (index == this.size - 1) {
                Person<T> currPerson = this.firstPerson;

                for (int i = 0; i < this.size - 2; i++) {
                    currPerson = currPerson.getNextPerson();
                }
                personReturned = currPerson.getNextPerson();
                currPerson.setNextPerson(null);
            } else {
                Person<T> currPerson = this.firstPerson;

                for (int i = 0; i < index - 1; i++) {
                    currPerson = currPerson.getNextPerson();
                }
                personReturned = currPerson.getNextPerson();
                currPerson.setNextPerson(personReturned.getNextPerson());
            }
            this.size--;
            return personReturned.getParcel();
        }
    }

    @Override
    public T remove(T element) throws IllegalArgumentException, NoSuchElementException {
        if (element == null) {
            throw new IllegalArgumentException("element is null");
        }
        int index = -1;
        Person<T> currPerson = this.firstPerson;
        for (int i = 0; i < this.size; i++) {
            if (currPerson.getParcel().equals(element)) {
                index = i;
                break;
            }
            currPerson = currPerson.getNextPerson();
        }
        if (index == -1) {
            throw new NoSuchElementException("element not found in the list");
        }
        return remove(index);
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if ((index > this.size - 1 || index < 0) && element == null) {
            throw new IndexOutOfBoundsException("index is invalid and element is null");
        } else if ((index > this.size - 1 || index < 0)) {
            throw new IndexOutOfBoundsException("index is invalid");
        } else if (element == null) {
            throw new IllegalArgumentException("element is null");
        } else {
            Person<T> personReturned;
            if (size == 1) {
                personReturned = this.firstPerson;
                this.firstPerson.setParcel(element);
            } else if (index == 0) {
                personReturned = this.firstPerson;
                this.firstPerson.setParcel(element);
            } else if (index == this.size - 1) {
                Person<T> currPerson = this.firstPerson;

                for (int i = 0; i < this.size - 1; i++) {
                    currPerson = currPerson.getNextPerson();
                }
                personReturned = currPerson;
                currPerson.setParcel(element);
            } else {
                Person<T> currPerson = this.firstPerson;

                for (int i = 0; i < index; i++) {
                    currPerson = currPerson.getNextPerson();
                }
                personReturned = currPerson;
                currPerson.setParcel(element);
            }
            return personReturned.getParcel();
        }
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if ((index > this.size - 1) || index < 0) {
            throw new IndexOutOfBoundsException("index is invalid");
        }
        Iterator<T> iterator = this.iterator();
        T parcelReturned = null;
        int count = 0;
        while (iterator.hasNext()) {
            if (count == index) {
                parcelReturned = iterator.next();
                break;
            }
            iterator.next();
            count++;
        }
        return parcelReturned;
    }

    @Override
    public boolean contains(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("element is null");
        } else {
            Iterator<T> iterator = this.iterator();
            boolean hasElement = false;
            while (iterator.hasNext()) {
                if (iterator.next().equals(element)) {
                    hasElement = true;
                }
            }
            return hasElement;
        }
    }

    @Override
    public void clear() {
        this.firstPerson = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new LineIterator<T>(this);
    }

    /**
     * Method that reverses the linked list recursively. Does so with the helper
     * method reverseHelper
     */
    public void reverse() {
        this.firstPerson = this.reverseHelper(this.firstPerson);
    }

    /**
     * Recursive helper method for the reverse method.
     *
     * @param head the Head person of the current Line
     * @return a Person that is the new head of the line
     */
    private Person<T> reverseHelper(Person<T> head) {
        if (head == null) {
            return null;
        }

        if (head.getNextPerson() == null) {
            return head;
        }

        Person<T> newHead = reverseHelper(head.getNextPerson());
        head.setNextPerson(null);
        Person<T> tempHead = newHead;
        while (tempHead.getNextPerson() != null) {
            tempHead = tempHead.getNextPerson();
        }
        tempHead.setNextPerson(head);

        return newHead;
    }
}
