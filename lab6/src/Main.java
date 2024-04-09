//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import lab6.task1.*;
import lab6.task2.*;
import lab6.task3.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /*
        //task 1
        List<Student> students = new ArrayList<>();
        students.add(new Student("Aurel Vlaicu", 5.3, 7.8, 9.0));
        students.add(new Student("Liviu Teodorescu", 7.7, 1.2, 9.0));
        students.add(new Student("Maria Popescu", 6.5, 8.5, 8.0));

        Sort totalGradeSorter = new Sort(new TotalGradeSorting());
        totalGradeSorter.print(students);

        Sort partialGradeSorter = new Sort(new PartialGradeSorting());
        partialGradeSorter.print(students);

        Sort averageGradeSorter = new Sort(new AverageGradeSorting());
        averageGradeSorter.print(students);
        */

        /*
        //task 2
        Topic gatit = new GroupChat("gatit");
        Topic programare = new GroupChat("programare");

        User adrian = new ConcreteUser("Adrian");
        User ion = new ConcreteUser("Ion");
        User maria = new ConcreteUser("Maria");
        User matei = new ConcreteUser("Matei");

        gatit.join(adrian);
        gatit.join(maria);

        programare.join(adrian);
        programare.join(ion);
        programare.join(maria);
        programare.join(matei);

        programare.notifyUsers(ion,"Salutare!");
        gatit.notifyUsers(adrian, "Omlette du fromage!");
        */

        //task 3
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Adrian", "Cash", 1000));
        clients.add(new Client("Maria", 750));
        clients.add(new Client("Ion", "Card", 1500));
        double[] amount_to_pay = {200, 500, 2000};
        String[] methods = {"Cash", "Card", "Bank Transfer"};

        TransactionManagement transactionManagement = new TransactionManagement();

        int i = 0;
        for(Client client: clients){
            String paymentMethod = client.getPaymentMethod();
            if (paymentMethod.equals("random")){
                Random random = new Random();
                int randomNumber = random.nextInt(3);
                paymentMethod = methods[randomNumber];
            }
            if (paymentMethod.equals("Cash"))
                transactionManagement.addTransaction(new CashPayment(client, amount_to_pay[i]));
            else if (paymentMethod.equals("Card"))
                transactionManagement.addTransaction(new CardPayment(client, amount_to_pay[i]));
            else if (paymentMethod.equals("Bank Transfer"))
                transactionManagement.addTransaction(new BankTransferPayment(client, amount_to_pay[i]));
            i++;
        }

        transactionManagement.processTransactions();
    }
}