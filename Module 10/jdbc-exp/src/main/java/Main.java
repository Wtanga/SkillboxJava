import org.hibernate.*;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        HashMap<Integer, Integer> studentsCourseIds = new HashMap<>();
        Session session = sessionFactory.openSession();

        LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();


        try (ScrollableResults scrollableResults = session.createSQLQuery(
                "select s.id as student_id, c.id as course_id " +
                        "from PurchaseList pl, Students s, Courses c " +
                        "where pl.course_name = c.name AND pl.student_name = s.name")
                .scroll()
        ) {
            while (scrollableResults.next()) {
                studentsCourseIds.put((int) scrollableResults.get()[1], (int) scrollableResults.get()[0]);
            }
        }
        for(Map.Entry<Integer, Integer> entry : studentsCourseIds.entrySet()){
            Course course = session.get(Course.class, entry.getKey());
            Student student = session.get(Student.class, entry.getValue());
            linkedPurchaseList.setId(new StudentCourseCompositeKey(course, student));
        }
        sessionFactory.close();
    }
}
