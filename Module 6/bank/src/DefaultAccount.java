public class DefaultAccount {
    public double balance;

    public DefaultAccount() {
        this.balance = balance;
    }

    public void withdraw(double withdraw) {
        if (withdraw > 0.0 && balance > withdraw) {
            balance = balance - withdraw;
        } else {
            System.out.println("Error");
        }
    }

    public void checkBalance() {
        System.out.println("Your balance: " + balance + " rub");
    }

    public void deposit(double deposit) {
        if (deposit > 0.0) {
            balance = balance + deposit;
        } else {
            System.out.println("Deposit value cannot be negative");
        }
    }
}
