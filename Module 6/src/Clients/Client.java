package Clients;


public abstract class Client {
    protected double balance;

    public Client(){

    }

    public abstract void checkBalance();
    public abstract void withdraw(double withdraw);
    public abstract void deposit(double deposit);

}
