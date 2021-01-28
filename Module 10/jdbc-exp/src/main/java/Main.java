import org.hibernate.*;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
        try (ScrollableResults scrollableResults = session.createSQLQuery(
                "select s.id as student_id, c.id as course_id " +
                        "from PurchaseList pl, Students s, Courses c " +
                        "where pl.course_name = c.name AND pl.student_name = s.name")
                .scroll()
        ) {
            while (scrollableResults.next()) {
                Course course = session.get(Course.class, (int) scrollableResults.get()[1]);
                Student student = session.get(Student.class, (int) scrollableResults.get()[0]);
                linkedPurchaseList.setId(new StudentCourseCompositeKey(course, student));
            }
        }
        System.out.println(linkedPurchaseList);

        sessionFactory.close();
    }
}
