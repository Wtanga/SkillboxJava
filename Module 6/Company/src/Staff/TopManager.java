package Staff;

public class TopManager implements Employee {
    private double fixedPart = 20000;
    private double bonus = 1.5 * 20000;
    private double monthSalary;
    private double bonusCondition = 10000000.0;

    @Override
    public double getMonthSalary() {
        if (Manager.income > bonusCondition) {
            return monthSalary = fixedPart + bonus;
        } else {
            return monthSalary = fixedPart;
        }
    }
}
