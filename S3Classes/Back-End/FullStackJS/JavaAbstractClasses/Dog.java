public class Dog extends Animal{
    

    public Dog(String name){
        super(name);
    }

    public void eat(){
        System.out.println("Dog is eating bones.");
    }

    public void greet(){
        System.out.println("Woof");
    }
}
