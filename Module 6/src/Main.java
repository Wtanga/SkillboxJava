import Accounts.CardAccount;
import Accounts.DefaultAccount;
import Accounts.DepositAccount;

public class Main {
    public static void main(String[] args) {
        DepositAccount dep = new DepositAccount();
        dep.deposit(100);
        CardAccount card = new CardAccount();
        card.deposit(10);
        dep.toTransfer(card, 20);
        System.out.println(dep.checkBalance());
        System.out.println(card.checkBalance());
        card.toTransfer(dep, 10);
        System.out.println(dep.checkBalance());
        System.out.println(card.checkBalance());
    }
}
