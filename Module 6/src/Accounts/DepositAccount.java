package Accounts;

public class DepositAccount extends DefaultAccount {
    private long time;

    @Override
    public void withdraw(double withdraw) {
        long difference = time  - System.currentTimeMillis();
        int daysGone =  (int)(difference / (1000 * 60 * 60 * 24 * 30L));
        int daysNeededToDeposit = 30;
        if (withdraw > 0 && balance > withdraw && daysGone > daysNeededToDeposit) {
            balance = balance - withdraw;
            System.out.println("You took from the card: " + withdraw + "rub");
        } else {
            System.out.println("Error");
        }
    }

    @Override
    public void deposit(double deposit) {
        if (deposit > 0.0) {
            time = System.currentTimeMillis();
            balance = balance + deposit;
        } else {
            System.out.println("Deposit value cannot be negative");
        }
    }
}