import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        SQLQuery query = session.createSQLQuery("select pl.course_name, pl.student_name, s.id, c.id, s.name, c.name " +
                "from PurchaseList pl, Students s, Courses c where pl.course_name = c.name, pl.student_name = s.name");
        List<Object[]> rows = query.list();
        for(Object[] row : rows){
            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
            linkedPurchaseList.setId(
                    new StudentCourseCompositeKey(
                          Integer.parseInt(row[4].toString()), Integer.parseInt(row[3].toString())
                    ));
            System.out.println(linkedPurchaseList);
        }


        sessionFactory.close();
    }
}
