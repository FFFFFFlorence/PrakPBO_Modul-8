class Animal {

}

class Mammal extends Animal {

}

class Reptile extends Animal {

}

class Dog extends Mammal {

}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Mammal mammal = new Mammal();
        Reptile reptile = new Reptile();
        Dog dog = new Dog();

        System.out.println(mammal instanceof Animal); // true
        System.out.println(dog instanceof Animal); // true
        System.out.println(dog instanceof Mammal); // true
        System.out.println(animal instanceof Dog); // false

        Animal animal2 = new Dog();
        //Dog dog2 = (Dog) animal2; // ClassCastException at runtime
        // Uncommenting the line below will cause a ClassCastException
        // Dog dog3 = (Dog) mammal;

        if (animal2 instanceof Dog) {
            Dog dog2 = (Dog) animal2; // This cast is safe
            System.out.println("Object berhasil dibuat");
        } else {
            System.out.println("Object gagal dibuat");
            
        } 
    }
}
