import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
class StudentCourseCompositeKey  implements Serializable {
    @JoinColumn(name = "course_id")
    private Course courseId;

    @JoinColumn(name = "student_id")
    private Student studentId;

    public StudentCourseCompositeKey () {
    }

    public StudentCourseCompositeKey (Course courseId, Student studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public Course getCourse() {
        return courseId;
    }

    public Student getStudent() {
        return studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentCourseCompositeKey )) return false;
        StudentCourseCompositeKey  that = (StudentCourseCompositeKey ) o;
        return Objects.equals(getCourse(), that.getCourse()) &&
                Objects.equals(getStudent(), that.getStudent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourse(), getStudent());
    }
}
