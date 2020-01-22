import Staff.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


import static Staff.Manager.income;

public class Company {
    public ArrayList<Employee> staff = new ArrayList<>();

    public void hireManager() {
        Manager manager = new Manager();
        staff.add(manager);
    }

    public void hireTopManager() {
        TopManager topManager = new TopManager();
        staff.add(topManager);
    }

    public void hireOperator() {
        Operator operator = new Operator();
        staff.add(operator);
    }

    public void hireAllManagers(int count) {
        for (int i = 0; i < count; i++) {
            Manager manager = new Manager();
            staff.add(manager);
        }
    }

    public void hireAllTopManagers(int count) {
        for (int i = 0; i < count; i++) {
            TopManager topManager = new TopManager();
            staff.add(topManager);
        }
    }

    public void hireAllOperators(int count) {
        for (int i = 0; i < count; i++) {
            Employee operator = new Operator();
            staff.add(operator);
        }
    }

    void fire(int count) {
        for (int i = 0; i < count; i++) {
            staff.remove((int) (Math.random() * staff.size()));
        }
    }

    public double getIncome() {
        return income;
    }

    void getTopSalaryStaff(int count) {
        Collections.sort(staff, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getMonthSalary() > o2.getMonthSalary()) {
                    return -1;
                }
                if (o1.getMonthSalary() < o2.getMonthSalary()) {
                    return 1;
                }
                return 0;

            }
        });
        if (count <= staff.size()) {
            for (int i = 0; i < count && count <= staff.size(); i++) {
                System.out.println(i + ". " + staff.get(i).getMonthSalary());
            }
        }
    }

    void getLowestSalaryStaff(int count) {
        Collections.sort(staff, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getMonthSalary() > o2.getMonthSalary()) {
                    return 1;
                }
                if (o1.getMonthSalary() < o2.getMonthSalary()) {
                    return -1;
                }
                return 0;

            }
        });
        if (count <= staff.size()) {
            for (int i = 0; i < count; i++) {
                System.out.println(i + ". " + staff.get(i).getMonthSalary());
            }
        }
    }
}

