public class DefaultAccount {
    public double balance;

    public DefaultAccount() {
        this.balance = balance;
    }

    public void withdraw(double withdraw) {
        if (withdraw > 0.0 && balance > withdraw) {
            balance = balance - withdraw;
            System.out.println("You took from the card: " + withdraw + "rub");
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
            System.out.println("Your deposit: " + deposit + "rub");
        } else {
            System.out.println("Deposit value cannot be negative");
        }
    }
}
