import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "testtest";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(course_name) AS Name, COUNT(course_name) AS Count " +
                    "FROM PurchaseList pl WHERE YEAR(pl.subscription_date ) = 2018 GROUP BY course_name ORDER BY pl.subscription_date;");//GROUP BY course_name
            while (resultSet.next()){
                String courseName = resultSet.getString("Name");
                String count = resultSet.getString("Count");
                System.out.println(courseName + " " + count);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
