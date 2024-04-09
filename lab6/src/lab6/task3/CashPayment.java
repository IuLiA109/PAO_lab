package lab6.task3;

public class CashPayment implements Command{
    private Client client;
    private double amount;

    public CashPayment(Client client, double amount) {
        this.client = client;
        this.amount = amount;
    }
    @Override
    public void execute() {
        if (client.getBalance() >= amount) {
            client.withdraw(amount);
            System.out.println("Cash payment successful for client " + client.getName());
        }
        else
            System.out.println("Insufficient cash for client " + client.getName());
    }
}
