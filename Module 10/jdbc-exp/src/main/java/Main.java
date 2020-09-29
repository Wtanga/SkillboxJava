import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "testtest";

        try (Connection connection =
                     DriverManager.getConnection(url, user, password);
             Statement statement =
                     connection.createStatement();
             ResultSet resultSet =
                     statement.executeQuery("SELECT MAX(course_name) AS Name, " +
                             "COUNT(course_name) AS Count, " +
                             "TIMESTAMPDIFF(month, MIN(subscription_date), MAX(subscription_date)) AS Dif " +
                             "FROM PurchaseList pl WHERE YEAR(pl.subscription_date ) = 2018" +
                             " GROUP BY course_name ORDER BY pl.subscription_date;")) {
            while (resultSet.next()) {
                String courseName = resultSet.getString("Name");
                double count = resultSet.getInt("Count");
                double dif = resultSet.getInt("Dif");
                System.out.printf("%s %.3f \n",courseName, (count / dif));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
//        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
//
//        Session session = sessionFactory.openSession();
//
//        Course course = session.get(Course.class, 1);
//        System.out.println(course.getName());
//        sessionFactory.close();
    }
}
