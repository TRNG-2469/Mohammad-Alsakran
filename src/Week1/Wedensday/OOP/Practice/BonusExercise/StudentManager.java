package Week1.Wedensday.OOP.Practice.BonusExercise;
public class StudentManager {
    public static void main(String[] args){

        Student s1 = new Student();


        Student s2 = new Student("Jane", 22, "Mathematics");

        s1.setAge(20);
        s1.setName("John");
        s1.setCourse("Computer Science");


        System.out.println(s1);
        System.out.println(s2);
        System.out.println("Total students: " + Student.getStudentCount());


        Student s3 = new Student("Jane", 22, "Mathematics");

    }
}
