import java.util.Scanner;

class UniversityApp {
    public static void main(String[] args) {
        University university = new University();
        Scanner scanner = new Scanner(System.in);

        // Adding students
        while (true) {
            System.out.println("Enter student name or type 'exit' to finish adding students:");
            String studentName = scanner.nextLine();
            if (studentName.equalsIgnoreCase("exit")) {
                break;
            }
            university.registerStudent(new Student(studentName));
        }

        // Adding 5 default courses
        university.registerCourse(new Course("1", "CSA2D_IC25", 3));
        university.registerCourse(new Course("2", "BBA1B_IV24", 3));
        university.registerCourse(new Course("3", "LOG3B_bc21", 3));
        university.registerCourse(new Course("4", "BCA1D_21", 3));
        university.registerCourse(new Course("5", "MEE3D_99", 3));

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Enroll a student in a course");
            System.out.println("2. Drop a student from a course");
            System.out.println("3. List all students");
            System.out.println("4. List all courses");
            System.out.println("5. List students registered for a specific course");
            System.out.println("6. List courses for a student");
            System.out.println("7. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    System.out.println("Enter student ID:");
                    int studentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.println("Enter course code:");
                    String courseCodeEnroll = scanner.nextLine();
                    university.enrollStudentInCourse(studentId, courseCodeEnroll);
                    break;
                case 2:
                    System.out.println("Enter student ID:");
                    int studentIdDrop = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.println("Enter course code:");
                    String courseCodeDrop = scanner.nextLine();
                    university.dropStudentFromCourse(studentIdDrop, courseCodeDrop);
                    break;
                case 3:
                    university.listAllStudents();
                    break;
                case 4:
                    university.listAllCourses();
                    break;
                case 5:
                    System.out.println("Enter course code:");
                    String courseCodeList = scanner.nextLine();
                    university.listStudentsRegisteredForCourse(courseCodeList);
                    break;
                case 6:
                    System.out.println("Enter student ID:");
                    int studentIdList = scanner.nextInt();
                    university.listCoursesForStudent(studentIdList);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
