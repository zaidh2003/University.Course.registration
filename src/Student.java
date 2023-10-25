import java.util.ArrayList;
import java.util.List;

public class Student {
    private static int idCounter = 1;
    private int studentId;
    private String name;
    private List<String> enrolledCourses;

    public Student(String name) {
        this.studentId = idCounter++;
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    public boolean registerCourse(String course) {
        if (enrolledCourses.size() >= 3) {
            System.out.println("Maximum course limit reached for this student.");
            return false;
        }
        enrolledCourses.add(course);
        return true;
    }

    public boolean dropCourse(String course) {
        return enrolledCourses.remove(course);
    }
}
