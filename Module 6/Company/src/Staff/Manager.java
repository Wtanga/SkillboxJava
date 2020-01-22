package Staff;

public class Manager implements Employee {
    private double fixedPart = 25000;
    private double earnings = (int) (Math.random() * 250000);
    private double monthSalary;
    public static double income;

    public Manager() {
        double percent = 0.05;
        monthSalary = fixedPart + percent * earnings;
        income += earnings;
    }

    @Override
    public double getMonthSalary() {
        return monthSalary;
    }

}
