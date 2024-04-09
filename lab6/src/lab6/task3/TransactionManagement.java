package lab6.task3;

import java.util.ArrayList;
import java.util.List;

public class TransactionManagement {
    private List<Command> transactions = new ArrayList<>();

    public void addTransaction(Command transaction) {
        transactions.add(transaction);
    }

    public void processTransactions() {
        for (Command transaction : transactions) {
            transaction.execute();
        }
        transactions.clear();
    }
}
