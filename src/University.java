import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students;
    private List<Course> courses;

    public University() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void registerStudent(Student student) {
        students.add(student);
    }

    public void registerCourse(Course course) {
        courses.add(course);
    }

    public void enrollStudentInCourse(int studentId, String courseCode) {
        Student student = findStudent(studentId);
        Course course = findCourse(courseCode);
        if (student != null && course != null) {
            if (student.registerCourse(courseCode)) {
                course.enrollStudent(String.valueOf(studentId));
                System.out.println(student.getName() + " has been enrolled in " + course.getTitle());
            }
        } else {
            System.out.println("Student or course not found.");
        }
    }

    public void dropStudentFromCourse(int studentId, String courseCode) {
        Student student = findStudent(studentId);
        Course course = findCourse(courseCode);
        if (student != null && course != null) {
            if (course.dropStudent(String.valueOf(studentId))) {
                student.dropCourse(courseCode);
                System.out.println(student.getName() + " has been dropped from " + course.getTitle());
            }
        } else {
            System.out.println("Student or course not found.");
        }
    }

    public void listAllStudents() {
        System.out.println("All Students:");
        for (Student student : students) {
            System.out.println("Student ID: " + student.getStudentId() + ", Name: " + student.getName());
        }
    }

    public void listAllCourses() {
        System.out.println("All Courses:");
        for (Course course : courses) {
            System.out.println("Course Code: " + course.getCourseCode() + ", Title: " + course.getTitle());
        }
    }

    public void listStudentsRegisteredForCourse(String courseCode) {
        Course course = findCourse(courseCode);
        if (course != null) {
            List<String> enrolledStudents = course.getEnrolledStudents();
            System.out.println("Students enrolled in " + course.getTitle() + ":");
            for (String studentId : enrolledStudents) {
                Student student = findStudent(Integer.parseInt(studentId));
                if (student != null) {
                    System.out.println("Student ID: " + student.getStudentId() + ", Name: " + student.getName());
                }
            }
        } else {
            System.out.println("Course not found.");
        }
    }

    public void listCoursesForStudent(int studentId) {
        Student student = findStudent(studentId);
        if (student != null) {
            List<String> enrolledCourses = student.getEnrolledCourses();
            System.out.println("Courses enrolled in by " + student.getName() + ":");
            for (String courseCode : enrolledCourses) {
                Course course = findCourse(courseCode);
                if (course != null) {
                    System.out.println("Course Code: " + course.getCourseCode() + ", Title: " + course.getTitle());
                }
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    private Student findStudent(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    private Course findCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
}
