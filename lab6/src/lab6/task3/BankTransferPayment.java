package lab6.task3;

public class BankTransferPayment implements Command{
    private Client client;
    private double amount;

    public BankTransferPayment(Client client, double amount) {
        this.client = client;
        this.amount = amount;
    }
    public void execute() {
        if (client.getBalance() >= amount) {
            client.withdraw(amount);
            System.out.println("Bank transfer payment successful for client " + client.getName());
        }
        else
            System.out.println("Balance is too low for client " + client.getName());
    }
}
