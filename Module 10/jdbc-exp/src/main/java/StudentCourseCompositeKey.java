import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
class StudentCourseCompositeKey  implements Serializable {
    @JoinColumn(name = "course_id")
    private int courseId;

    @JoinColumn(name = "student_id")
    private int studentId;

    public StudentCourseCompositeKey () {
    }

    public StudentCourseCompositeKey (int courseId, int studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public int getCourse() {
        return courseId;
    }

    public int getStudent() {
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
