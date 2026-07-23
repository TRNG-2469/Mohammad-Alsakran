package Week1.Thursday.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CheckedDemo {
    public static void main(String[] args) {
        FileInputStream fis=null;

        try {
            fis=new FileInputStream("test.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
