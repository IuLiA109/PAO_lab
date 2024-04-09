package lab6.task3;

public class Client {
    private String name;
    private String paymentMethod;
    private double balance;

    public Client(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.paymentMethod = "random";
    }

    public Client(String name, String paymentMethod, double balance) {
        this.name = name;
        this.paymentMethod = paymentMethod;
        this.balance = balance;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

}
