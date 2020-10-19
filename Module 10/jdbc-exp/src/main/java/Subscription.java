import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
class SubscriptionId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id")
    private Course course;

    @JoinColumn(name = "id")
    private long student;

    public SubscriptionId() {
    }

    public SubscriptionId(Course courseId, Long studentId) {
        this.course = courseId;
        this.student = studentId;
    }

    public Course getCourse() {
        return course;
    }

    public long getStudent() {
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
@Entity(name = "Subscriptions")
@Table(name = "Subscriptions")
public class Subscription {
    @EmbeddedId
    private SubscriptionId id;

    @ManyToMany(cascade = CascadeType.ALL)
    private Student student;

    @ManyToMany(cascade = CascadeType.REFRESH)
    private Course course;

    @Column(name = "subscription_Date")
    private Date subscriptionDate;

    public Subscription(Course course, Student student, Date date) {
        this.course = course;
        this.student = student;
        this.subscriptionDate = date;
    }


    public SubscriptionId getId() {
        return id;
    }

    public void setId(SubscriptionId id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }


}
