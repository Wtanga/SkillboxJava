package Accounts;

public class DefaultAccount {
    protected double balance;

    public DefaultAccount() {

    }

    public boolean withdraw(double withdraw) {
        if (withdraw > 0.0 && balance > withdraw) {
            balance = balance - withdraw;
            System.out.println("You took from the card: " + withdraw + "rub");
            return true;
        } else {
            System.out.println("Error withdraw");
            return false;
        }
    }

    public double checkBalance() {
        return balance;
    }

    public boolean deposit(double deposit) {
        if (deposit > 0.0) {
            balance = balance + deposit;
            System.out.println("Your deposit: " + deposit + "rub");
            return true;
        } else {
            System.out.println("Deposit value cannot be negative");
            return false;
        }
    }

    public void toTransfer(DefaultAccount account, double deposit) {
        if (withdraw(deposit)) {
            account.deposit(deposit);
        } else {
            System.out.println("Transfer error");
        }
    }
}
