package Accounts;

import java.time.Duration;
import java.time.LocalDate;

public class DepositAccount extends DefaultAccount {
    private long time;
    LocalDate timeOfDeposit;

    @Override
    public boolean withdraw(double withdraw) {
        LocalDate timeOfWithdraw = LocalDate.now();
        Duration duration = Duration.between(timeOfDeposit.atStartOfDay(), timeOfWithdraw.atStartOfDay());
        int currentDuration = (int) duration.toDays();
        int minDuration = 30;
        if (withdraw > 0 && balance > withdraw && currentDuration > minDuration) {
            balance = balance - withdraw;
            System.out.println("You took from the card: " + withdraw + "rub");
            return true;
        } else {
            System.out.println("Error withdraw");
            return false;
        }
    }

    @Override
    public boolean deposit(double deposit) {
        if (deposit > 0.0) {
            timeOfDeposit = LocalDate.now();
            balance = balance + deposit;
            return true;
        } else {
            System.out.println("Deposit value cannot be negative");
            return false;
        }
    }
}
