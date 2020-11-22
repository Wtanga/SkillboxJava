import javax.persistence.*;
import java.util.Date;

@Entity(name = "Subscriptions")
@Table(name = "Subscriptions")
public class Subscription {
    @EmbeddedId
    private StudentCourseCompositeKey  id;

    @Column(name = "subscription_Date")
    private Date subscriptionDate;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Subscription(StudentCourseCompositeKey  subscriptionId, Date subscriptionDate){
        this.id = subscriptionId;
        this.subscriptionDate = subscriptionDate;
    }

    public StudentCourseCompositeKey  getId() {
        return id;
    }

    public void setId(StudentCourseCompositeKey  id) {
        this.id = id;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }


}
