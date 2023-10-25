import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseCode;
    private String title;
    private List<String> enrolledStudents;
    private int maxEnrollmentLimit;

    public Course(String courseCode, String title, int maxEnrollmentLimit) {
        this.courseCode = courseCode;
        this.title = title;
        this.maxEnrollmentLimit = maxEnrollmentLimit;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getEnrolledStudents() {
        return enrolledStudents;
    }

    public boolean enrollStudent(String student) {
        if (enrolledStudents.size() >= maxEnrollmentLimit) {
            System.out.println("Course has reached its maximum enrollment limit.");
            return false;
        }
        enrolledStudents.add(student);
        return true;
    }

    public boolean dropStudent(String student) {
        return enrolledStudents.remove(student);
    }
}
