package Clients;

public class IE extends Client {
    public void withdraw(double withdraw) {
        if (withdraw > 0.0 && balance > withdraw) {
            balance = balance - withdraw * 1.01;
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
            if (deposit < 1000) {
                balance = balance + deposit * 0.99;
            } else {
                balance = balance + deposit * 0.995;
            }
            System.out.println("Your deposit: " + deposit + "rub");
        } else {
            System.out.println("Deposit value cannot be negative");
        }
    }
}
