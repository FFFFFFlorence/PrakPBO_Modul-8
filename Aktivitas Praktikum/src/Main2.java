class Engine {
    public void start() {
        System.out.println("Engine menyala");
    }
}

class Car {
    Engine engine = new Engine();

    void drive(){
        engine.start();
        System.out.println("Mobil berjalan");
    }
}

public class Main2 {
    public static void main(String[] args) {
        Car car = new Car();
        car.drive();
    }
}
