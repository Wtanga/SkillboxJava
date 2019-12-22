public class Main {
    public static void main(String[] args) {
//        DefaultAccount acc = new DefaultAccount();
//        acc.deposit(10000);
//        acc.checkBalance();
//        acc.deposit(-100);
        CardAccount card = new CardAccount();
        card.deposit(1000);
        card.checkBalance();
        card.withdraw(100.0);
        card.checkBalance();
    }
}
