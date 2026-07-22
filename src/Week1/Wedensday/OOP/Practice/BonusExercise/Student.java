package Week1.Wedensday.OOP.Practice.BonusExercise;

public class Student {
    private String name;
    private int age;
    private String course;
    private static int studentCount=0;

    public Student(){studentCount++;}

    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
        studentCount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", course='" + course + '\'' +
                '}';
    }

    public static int getStudentCount() {
        return studentCount;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}


