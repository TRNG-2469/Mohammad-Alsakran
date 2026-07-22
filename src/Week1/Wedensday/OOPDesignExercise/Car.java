package Week1.Wedensday.OOPDesignExercise;

public class Car extends Vehicle implements Drivable {

    private String model;

    public Car(String model) {
        super(model);

    }

    @Override
    public void accelerate() {
        speed+=20;
        System.out.println("The car is accelerating.");
    }


    @Override
    public void start() {
        System.out.println("The car is starting.");
    }

    @Override
    public void soundHorn() {
        System.out.println("[CAR HORN]Beep Beep!");
    }
}
