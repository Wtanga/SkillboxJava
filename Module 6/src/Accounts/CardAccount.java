package Accounts;

public class CardAccount extends DefaultAccount {
    static final double COMMISSION = 1.01;
    @Override
    public boolean withdraw(double withdraw) {
        return super.withdraw(withdraw * COMMISSION);
    }
}
