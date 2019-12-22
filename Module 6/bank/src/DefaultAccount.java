public class DefaultAccount {
    private int balance;

    public DefaultAccount() {
        this.balance = balance;
    }

    public void withdraw(int withdraw) {
        if (withdraw > 0) {
            balance = balance - withdraw;
        } else {
            System.out.println("Withdraw value cannot be negative");
        }
    }

    public void checkBalance() {
        System.out.println("Your balance: " + balance + " rub");
    }

    public void deposit(int deposit) {
        if (deposit > 0) {
            balance = balance + deposit;
        } else {
            System.out.println("Deposit value cannot be negative");
        }
    }
}
