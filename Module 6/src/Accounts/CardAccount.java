package Accounts;

public class CardAccount extends DefaultAccount {

    @Override
    public void withdraw(double withdraw) {
        if (withdraw > 0 && balance > withdraw * 1.01) {
            balance = balance - withdraw * 1.01;
            System.out.println("You took from the card: " + withdraw + "rub Commission: " + withdraw * 0.01 + "rub");
        } else {
            System.out.println("Error");
        }
    }
}