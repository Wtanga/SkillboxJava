package Staff;

public class Manager implements Employee {
    private double percent = 0.05;
    private double fixedPart = 25000;
    private double earnings = (int) (Math.random() * 180000);
    private double monthSalary;
    protected static double income;

    public Manager() {
        monthSalary = fixedPart + percent * earnings;
        income += monthSalary;
    }

    @Override
    public double getMonthSalary() {
        return monthSalary;
    }

}
