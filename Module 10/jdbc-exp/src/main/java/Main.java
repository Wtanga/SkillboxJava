import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class, 1);
        System.out.println(student.getRegistrationDate());
        Teacher teacher  = session.get(Teacher.class, 1);
        System.out.println(teacher.getSalary() + " - " + teacher.getName());
        Course course = session.get(Course.class, 1);
        System.out.println(course.getStudents().size() + "\nStudents count: " + course.getStudentsCount());

        sessionFactory.close();
    }
}
