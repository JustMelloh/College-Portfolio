public interface AnimalInterface {
    // NOTES :
    // Cannot have instanced variables\attributes\fields
    // Can have static final contant variables
    // Cannot have contructors


    // Abstract methods and constants

    public static final double g = 10;


    public abstract void speakable();

    void movable();
    void foodtype();
    void sleep();

    public default void display(){
        System.out.println("This is the default method.");
    }
}
