public class DepositAccount extends DefaultAccount {
    long time;

    public void withdraw(double withdraw) {
        Long timeLastDeposit = 2592000000L;
        if (withdraw > 0 && balance > withdraw && (System.currentTimeMillis() - time) > timeLastDeposit) {
            balance = balance - withdraw;
            System.out.println("You took from the card: " + withdraw + "rub");
        } else {
            System.out.println("Error");
        }
    }

    public void deposit(double deposit) {
        if (deposit > 0.0) {
            time = System.currentTimeMillis();
            balance = balance + deposit;
        } else {
            System.out.println("Deposit value cannot be negative");
        }
    }
}
