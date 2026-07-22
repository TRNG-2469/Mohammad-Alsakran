package Week1.Wedensday.AiAssistedDebugging;

public class RosterApp {
    public static void main(String[] args) {
        String[] studentNames = new String[5];
        studentNames[0] = "Alice";
        studentNames[1] = "Bob";

        for (int i = 0; i < studentNames.length; i++) {
            // Skip uninitialized (null) entries to avoid NullPointerException
            String name = studentNames[i];
            if (name == null) {
                continue;
            }

            if (name.startsWith("A")) {
                System.out.println("Student: " + name);
            }
        }
    }
}