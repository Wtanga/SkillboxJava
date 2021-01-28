import java.util.HashMap;
import java.util.Random;

public class Bank {
    private HashMap<String, Account> accounts;
    private final Random random = new Random();
    private final int transactionLimit = 50000;

    private synchronized boolean isFraud(Account accountPayer, Account accountReceiver, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами.
     * Если сумма транзакции > 50000, то после совершения транзакции,
     * она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка
     * счетов (как – на ваше усмотрение)
     */
    public void transfer(Account accountPayer, Account accountReceiver, long amount) throws InterruptedException {
        if (accountPayer.getMoney() != -1 && accountReceiver.getMoney() != -1) {
            accountPayer.setMoney(accountPayer.getMoney() - amount);
            accountReceiver.setMoney(accountReceiver.getMoney() + amount);
            if (amount > transactionLimit) {
                if (isFraud(accountPayer, accountReceiver, amount)) {
                    System.out.println(accountPayer.getAccNumber() + " is blocked");
                    System.out.println(accountReceiver.getAccNumber() + " is blocked");
                    accountPayer.setMoney(-1);
                    accountReceiver.setMoney(-1);
                };
            }
            System.out.println("Balance " + accountPayer.getAccNumber() + ": " + accountPayer.getMoney());
            System.out.println("Balance " + accountReceiver.getAccNumber() + ": " + accountReceiver.getMoney());
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(Account accountNum) {
        return accountNum.getMoney();
    }
}
