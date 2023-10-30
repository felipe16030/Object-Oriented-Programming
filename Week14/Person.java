package Week14;
/**
 * A class that defines a Person object that is of a generic type.
 *
 * @author Felipe Bergerman
 * @version 1.1
 * @param <T> the generic type passed in
 */
public class Person<T> {
    private T parcel;
    private Person<T> nextPerson;

    /**
     * Constructor that defines a Person object. Accepts a percel and nextPerson
     * objects.
     *
     * @param parcel     the parcel that a Person will hold
     * @param nextPerson the next Person in the line
     */
    public Person(T parcel, Person<T> nextPerson) {
        this.parcel = parcel;
        this.nextPerson = nextPerson;
    }

    /**
     * Constructor that defines a Person object. Accepts a parcel and sets
     * nextPerson to null.
     *
     * @param parcel the object that the person will hold.
     */
    public Person(T parcel) {
        this.parcel = parcel;
        this.nextPerson = null;
    }

    /**
     * Gets the parcel that the Person object will hold.
     *
     * @return the parcel held
     */
    public T getParcel() {
        return this.parcel;
    }

    /**
     * Gets the nextPerson that this Person holds.
     *
     * @return the next Person object.
     */
    public Person<T> getNextPerson() {
        return nextPerson;
    }

    /**
     * Sets the next Person to a Person passed in.
     *
     * @param nextPerson the Person passed in.
     */
    public void setNextPerson(Person<T> nextPerson) {
        this.nextPerson = nextPerson;
    }

    /**
     * Sets the parcel to a parcel passed in.
     *
     * @param parcel parcel passed in.
     */
    public void setParcel(T parcel) {
        this.parcel = parcel;
    }
}
