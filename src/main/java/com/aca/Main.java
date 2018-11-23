public class Main {
     public static void main(String... args) throws IllegalAccessException, InstantiationException {
        Course c1 = new Course("Databases", "CS101");
        Course c2 = new Course("Introduction to programming", "CS102");

        Student student = new Student("John", "Smith", 3.8f);
        student.enroll(c1);
        student.enroll(c2);

        Validator validator = new Validator();
        if (!validator.isValid(student)) {
            throw new IllegalArgumentException();
        }
    }
}