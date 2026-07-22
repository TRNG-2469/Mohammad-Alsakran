package Week1.Wedensday.OOPDesignExercise;

public interface Drivable {

    abstract void accelerate();
    default void soundHorn(){
        System.out.println("[HORN]Beep Beep!");
    }
}
