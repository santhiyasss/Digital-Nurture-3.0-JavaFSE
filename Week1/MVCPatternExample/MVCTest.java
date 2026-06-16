public class MVCTest {
    public static void main(String[] args) {
        Student model = new Student("Santhiya", "S101", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        System.out.println("--- Initial Student Details ---");
        controller.updateView();

        // Update details
        controller.setStudentName("Santhiya R");
        controller.setStudentGrade("A+");

        System.out.println("\n--- Updated Student Details ---");
        controller.updateView();
    }
}