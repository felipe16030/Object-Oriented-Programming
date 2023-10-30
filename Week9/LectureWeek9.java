package "";

public class LectureWeek9 {
    /**
     * Static type of a reference is what the reference is declared as. It cannot change.
     * Dynamic type of a reference is what type of object a reference is assigned to. It can change.
     * 
     * Up-casts from subclass to super class is legal. Will always run and compile.
     * Side-casts from subclass to subclass is not legal. Will not compile.
     * Down-casts from superclass to subclass is legal. Will always compile, sometimes a runtime exception.
     * 
     * Compiler only works with static types, thus it only checks IF there exists a chance that casted objects
     * have a IS-A relatinoship with the type it is being casted to. During run time, an exception is thrown if
     * the dynamic type a reference is casted to is not a parent.
     * 
     * Polymorphism:
     * 
     * If an animal Bird, Dog, and Fish is-a animal:
     * Animal animal = new Bird(); is legal because Bird is 'is-a' Animal.
     * Bird bird = new Animal(); is not legal because Animal is not a Bird.
     * The method invoked by the runtime machine is that of the dynamic type. Subclasses overrides superclass methods.
     */

}
