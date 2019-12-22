public class Main {
    public static void main(String[] args) {
        System.out.println("Default acc");
        DefaultAccount acc = new DefaultAccount();
        acc.deposit(10000);
        acc.checkBalance();
        acc.deposit(-100);
        System.out.println("Card acc");
        CardAccount card = new CardAccount();
        card.deposit(1000);
        card.checkBalance();
        card.withdraw(100.0);
        card.checkBalance();
        System.out.println("Deposit acc");
        DepositAccount dep = new DepositAccount();
        dep.deposit(1000.0);
        dep.withdraw(10.0);
        dep.checkBalance();
    }
}
