package co.istad.oop.banking;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

public class BankingApp2 {
    public static void main(String[] args) {

        Card card = new Card();
        card.setCardNo("12345678");
        card.setCsv(123);
        card.setPin("8899");
        card.setCardType("VISA");
        card.setOverLimit(BigDecimal.valueOf(5000));
        card.setExpiredAt(LocalDateTime.of(2030,1,1,0,0));

        PayrollAccount payrollAccount = new PayrollAccount(
                "88889999",
                "RATANAK SAREN",
                BigDecimal.valueOf(5000),
                LocalDateTime.of(2023, 1,1, 0,0,0),
                10, card
        );

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("--------------------------");
            System.out.println("Enter (1) to check balance");
            System.out.println("Enter (2) to deposit");
            System.out.println("Enter (3) to withdrawal");
            System.out.println("Enter (0) to exit");
            System.out.print("Enter your choice: ");
            int option = Integer.parseInt(scanner.nextLine());
            System.out.println("--------------------------");

            switch (option) {
                case 1 -> payrollAccount.checkBalance();
                case 2 -> {
                    System.out.print("Enter amount: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    payrollAccount.deposit(BigDecimal.valueOf(amount));
                }
                case 3 -> {
                    {
                        System.out.print("Enter amount: ");
                        double amount = Double.parseDouble(scanner.nextLine());
                        payrollAccount.withdrawal(BigDecimal.valueOf(amount));
                    }
                }
                case 0 -> System.exit(0);
            }
        } while (true);
    }
}
