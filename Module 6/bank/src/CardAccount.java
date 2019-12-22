public class CardAccount extends DefaultAccount {

    public void withdraw(double withdraw) {
    if (withdraw > 0 && balance > withdraw) {
        balance = balance - withdraw * 1.01;
    } else {
        System.out.println("Error");
    }
    }
}
