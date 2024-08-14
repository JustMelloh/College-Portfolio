public class Cat extends Animal {
    

    Cat(String name){
        super(name);
    }

    public void eat(){
        System.out.println("Cat is eating");
    }

    public void greet(){
        System.out.println("Meow");
    }
    
    public void speakable(){
        System.out.println("Cat is speakable");
    }

    public void movable(){
        System.out.println("Cat is movable");
    }

    public void foodType(){
        System.out.println("Cat is carnivorous");
    }

    public void sleep(){
        System.out.println("Cat is sleeping");
    }
}
