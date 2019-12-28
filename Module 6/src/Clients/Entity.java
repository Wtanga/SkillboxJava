package Clients;

public class Entity extends Client {
    static final double COMMISSION = 1.01;
    @Override
    public boolean withdraw(double withdraw) {
        return super.withdraw(withdraw * COMMISSION);
    }
}
