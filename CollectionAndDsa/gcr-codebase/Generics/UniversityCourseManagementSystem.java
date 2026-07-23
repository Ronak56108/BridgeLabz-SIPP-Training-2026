import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private final String description;

    protected CourseType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

class ExamCourse extends CourseType {
    ExamCourse() {
        super("Exam-Based Evaluation");
    }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse() {
        super("Assignment-Based Evaluation");
    }
}

class ResearchCourse extends CourseType {
    ResearchCourse() {
        super("Research-Based Evaluation");
    }
}

class Course<T extends CourseType> {
    private final String name;
    private final int credits;
    private final T type;

    public Course(String name, int credits, T type) {
        this.name = name;
        this.credits = credits;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public T getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("Course{name='%s', credits=%d, type=%s}", name, credits, type.getDescription());
    }
}

public class UniversityCourseManagementSystem {
    public static void displayCourses(List<? extends Course<? extends CourseType>> courses) {
        System.out.println("University courses:");
        for (Course<? extends CourseType> course : courses) {
            System.out.println(" - " + course);
        }
    }

    public static void main(String[] args) {
        Course<ExamCourse> math = new Course<>("Mathematics", 4, new ExamCourse());
        Course<AssignmentCourse> art = new Course<>("Visual Arts", 3, new AssignmentCourse());
        Course<ResearchCourse> ai = new Course<>("AI Research", 5, new ResearchCourse());

        List<Course<? extends CourseType>> courseList = new ArrayList<>();
        courseList.add(math);
        courseList.add(art);
        courseList.add(ai);

        displayCourses(courseList);
    }
}
