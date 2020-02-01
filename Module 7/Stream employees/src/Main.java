import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    private static String staffFile = "data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";





    public static void main(String[] args) {
        Calendar date1 = new GregorianCalendar(2017, 0, 00);
        Date dateAfter = date1.getTime();
        Calendar date2 = new GregorianCalendar(2018, 0, 00);
        Date dateBefore = date2.getTime();
        ArrayList<Employee> staff = loadStaffFromFile();
        Stream<Employee> maxSalary = staff.stream();
        maxSalary.filter(employee ->  employee.getWorkStart()
                .after(dateAfter))
                .filter(employee ->  employee.getWorkStart()
                .before(dateBefore))
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);
    }

    private static ArrayList<Employee> loadStaffFromFile() {
        ArrayList<Employee> staff = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for (String line : lines) {
                String[] fragments = line.split("\t");
                if (fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                        fragments[0],
                        Integer.parseInt(fragments[1]),
                        (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}