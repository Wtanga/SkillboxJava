package Accounts;

public class CardAccount extends DefaultAccount {

    @Override
    public boolean withdraw(double withdraw) {
        if (withdraw > 0 && balance > withdraw) {
            balance = balance - withdraw * 1.01;
            System.out.println("You took from the card: " + withdraw + "rub Commission: " + withdraw * 0.01 + "rub");
            return true;
        } else {
            System.out.println("Error withdraw");
            return false;
        }
    }
}
