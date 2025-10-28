package co.istad.oop.banking;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BankingApp3 {
    public static void main(String[] args) {

        Card card = new Card();
        card.setCardNo("12345678");
        card.setCsv(123);
        card.setPin("8899");
        card.setCardType("VISA");
        card.setOverLimit(BigDecimal.valueOf(5000));
        card.setExpiredAt(LocalDateTime.of(2030,1,1,0,0));

        Account account = new PayrollAccount(
                "88889999",
                "RATANAK SAREN",
                BigDecimal.valueOf(5000),
                LocalDateTime.of(2023, 1,1, 0,0,0),
                10,
                card
        );

        account.checkBalance();

        account = new SavingAccount(
                "88889999",
                "RATANAK SAREN",
                BigDecimal.valueOf(5000),
                LocalDateTime.of(2023, 1,1, 0,0,0),
                10,
                card
        );

        account.checkBalance();

    }
}
