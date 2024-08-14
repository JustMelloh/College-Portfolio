public abstract class Animal implements AnimalInterface {
    // 1. Abstract is a non access modifier, you cannot instantiate the class.
    // 2. Can have attributes, methods, constructors and abstract methods.


    private String name;

    Animal(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public abstract void greet();
    public abstract void eat();

    public String toString(){
        return ("Animal name: " + this.name);
    }
}
