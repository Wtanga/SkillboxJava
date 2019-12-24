import Accounts.CardAccount;
import Accounts.DefaultAccount;
import Accounts.DepositAccount;

public class Main {
    public static void main(String[] args) {
        System.out.println("Default acc");
        DefaultAccount acc = new DefaultAccount();
        acc.deposit(1000);
        acc.withdraw(100000.0);
        acc.checkBalance();
        System.out.println("Card acc");
        CardAccount card = new CardAccount();
        card.deposit(1000);
        card.checkBalance();
        card.withdraw(10000.0);
        card.checkBalance();
        System.out.println("Deposit acc");
        DepositAccount dep = new DepositAccount();
        dep.deposit(1000.0);
        dep.withdraw(10000.0);
        dep.checkBalance();
    }
}