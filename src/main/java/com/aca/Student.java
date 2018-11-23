import java.util.*;

class Student {

   @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Valid(minValue = 0.0f, maxValue = 4.0f)
    private float gpa;

    @NotEmpty
    private List<Course> courses;

    public Student(String firstName, String lastName, float gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
		this.courses = new ArrayList<>();
    }

    void enroll(Course course) {
        courses.add(course);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public float getGpa() {
        return gpa;
    }

    public List<Course> getCourses() {
        return courses;
    }

}