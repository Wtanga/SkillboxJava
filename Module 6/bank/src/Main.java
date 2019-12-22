public class Main {
    public static void main(String[] args) {
        DefaultAccount acc = new DefaultAccount();
        acc.deposit(10000);
        acc.checkBalance();
        acc.deposit(-100);
    }
}
