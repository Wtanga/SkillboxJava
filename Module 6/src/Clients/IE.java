package Clients;

public class IE extends Client {
    static final double COMMISSION_LESS_THOUS = 0.99;
    static final double COMMISSION_MORE_THOUS = 0.995;
    @Override
    public boolean deposit(double deposit) {
        if (deposit > 0.0) {
            if (deposit < 1000) {
                return super.withdraw(deposit * COMMISSION_LESS_THOUS);
            } else {
                return super.withdraw(deposit * COMMISSION_MORE_THOUS);
            }
        } else {
            System.out.println("Deposit value cannot be negative");
            return false;
        }
    }
}
