import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
class SubscriptionId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "student_id")
    private Student student;

    public SubscriptionId() {
    }

    public SubscriptionId(Course courseId, Student studentId) {
        this.course = courseId;
        this.student = studentId;
    }

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubscriptionId)) return false;
        SubscriptionId that = (SubscriptionId) o;
        return Objects.equals(getCourse(), that.getCourse()) &&
                Objects.equals(getStudent(), that.getStudent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourse(), getStudent());
    }
}
