package Clients;

public class Entity extends Client {
    public void withdraw(double withdraw) {
        if (withdraw > 0.0 && balance > withdraw) {
            balance = balance - withdraw * 1.01;
            System.out.println("You took : " + withdraw + "rub");
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
