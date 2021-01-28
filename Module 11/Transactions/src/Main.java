public class Main {
    public static void main(String[] args) throws InterruptedException {
        Account account1 = new Account();
        account1.setMoney(100000);
        account1.setAccNumber("Mr");
        Account account2 = new Account();
        account2.setMoney(100000);
        account2.setAccNumber("Ms");
        Bank bank = new Bank();
        bank.transfer(account1, account2, 60000);
        System.out.println(bank.getBalance(account1));
    }
}
