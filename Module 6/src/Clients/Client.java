package Clients;


public abstract class Client {
    protected double balance;

    public Client(){

    }

    public double checkBalance() {
        return balance;
    }
    public boolean deposit(double deposit) {
        if (deposit > 0.0) {
            balance += deposit;
            System.out.println("Your deposit: " + deposit + "rub");
            return true;
        } else {
            System.out.println("Deposit value cannot be negative");
            return false;
        }
    }
    public boolean withdraw(double withdraw) {
        if (withdraw > 0.0 && balance > withdraw) {
            balance -= withdraw;
            System.out.println("You took from the card: " + withdraw + "rub");
            return true;
        } else {
            System.out.println("Error withdraw");
            return false;
        }
    }

}
