import Staff.Employee;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        company.hireAllManagers(80);
        company.hireAllOperators(180);
        company.hireAllTopManagers(10);
        System.out.println("Highest salary:");
        company.getTopSalaryStaff(10);
        System.out.println("Lowest salary:");
        company.getLowestSalaryStaff(30);
        company.fire(135);
        System.out.println("Highest salary:");
        company.getTopSalaryStaff(10);
        System.out.println("Lowest salary:");
        company.getLowestSalaryStaff(30);

    }
}
