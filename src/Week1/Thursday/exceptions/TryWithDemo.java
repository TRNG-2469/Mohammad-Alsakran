package Week1.Thursday.exceptions;

import java.io.FileInputStream;

public class TryWithDemo {
    public static void main(String[] args) {
        FileInputStream fis = null;

        try (FileInputStream fi = new FileInputStream("test.txt")) {
            // Use the FileInputStream here
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
