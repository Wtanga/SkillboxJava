import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList {

    @EmbeddedId
    private StudentCourseCompositeKey  id;

    public StudentCourseCompositeKey getId() {
        return id;
    }

    public void setId(StudentCourseCompositeKey id) {
        this.id = id;
    }
}
