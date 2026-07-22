package Week1.Wedensday.OOPDesignExercise;

public class Truck extends Vehicle implements Drivable {

    private String model;

    public Truck(String model) {
        super(model);

    }

    @Override
    public void accelerate() {
        speed+=10;
        System.out.println("The truck is accelerating.");
    }


    @Override
    public void start() {
        System.out.println("The truck is starting.");
    }

    @Override
    public void soundHorn() {
        System.out.println("[TRUCK HORN]Beep Beep!");
    }
}
