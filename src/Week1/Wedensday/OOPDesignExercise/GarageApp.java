package Week1.Wedensday.OOPDesignExercise;

public class GarageApp {
    public static void main(String[] args) {
        Car car = new Car("Toyota Camry");
        Truck truck = new Truck("Ford F-150");

        car.start();
        car.accelerate();
        car.soundHorn();
        car.stop();

        truck.start();
        truck.accelerate();
        truck.soundHorn();
        truck.stop();
    }
}
