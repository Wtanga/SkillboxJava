import javax.persistence.*;
import java.util.Date;

@Entity(name = "Subscriptions")
@Table(name = "Subscriptions")
public class Subscription {
    @EmbeddedId
    private SubscriptionId id;

    @Column(name = "subscription_Date")
    private Date subscriptionDate;

    public Subscription(SubscriptionId subscriptionId, Date subscriptionDate){
        this.id = subscriptionId;
        this.subscriptionDate = subscriptionDate;
    }

    public SubscriptionId getId() {
        return id;
    }

    public void setId(SubscriptionId id) {
        this.id = id;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }


}
