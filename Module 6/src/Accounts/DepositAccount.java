package Accounts;

import java.time.Duration;
import java.time.LocalDate;

public class DepositAccount extends DefaultAccount {
    private LocalDate timeOfDeposit;
    private static final int MIN_DEPOSIT_DAYS = 30;

    public DepositAccount(){

    }

    @Override
    public boolean withdraw(double withdraw) {
        if(timeOfDeposit != null) {
            LocalDate timeOfWithdraw = LocalDate.now();
            Duration duration = Duration.between(timeOfDeposit.atStartOfDay(), timeOfWithdraw.atStartOfDay());
            int currentDuration = (int) duration.toDays();
            if (withdraw > 0.0 && balance > withdraw && currentDuration > MIN_DEPOSIT_DAYS) {
                balance -= withdraw;
                System.out.println("You took from the card: " + withdraw + "rub");
                return true;
            } else {
                System.out.println("Error withdraw");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean deposit(double deposit) {
        if (deposit > 0.0) {
            timeOfDeposit = LocalDate.now();
            balance += deposit;
            return true;
        } else {
            System.out.println("Deposit value cannot be negative");
            return false;
        }
    }
}
