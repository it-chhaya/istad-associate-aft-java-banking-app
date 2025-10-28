package co.istad.oop.banking;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class PayrollAccount extends Account {

    private float taxRate;
    private Card card;

    public float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(float taxRate) {
        this.taxRate = taxRate;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public PayrollAccount(String actNo, String actName, BigDecimal balance, LocalDateTime createdAt, float taxRate, Card card) {
        super(actNo, actName, balance, createdAt);
        this.taxRate = taxRate;
        this.card = card;
    }

    @Override
    public void deposit(BigDecimal amount) {
        BigDecimal salaryWithTax = amount.multiply(BigDecimal.valueOf(taxRate/100));
        BigDecimal salaryWithoutTax = amount
                .subtract(salaryWithTax)
                .setScale(2, RoundingMode.UP);
        if (card != null){
            if (LocalDateTime.now().isAfter(card.getExpiredAt())){
                System.out.println("Card is Expired!");
                return;
            }
            if (amount.compareTo(card.getOverLimit())>0){
                System.out.println("Amount is over limit: " + card.getOverLimit());
                return;
            }
            if (!card.getCardNo().equals("12345678")){
                System.out.println("Card Number is invalid");
                return;
            }
            if (card.getCsv() !=123){
                System.out.println("Card CSV is incorrect!");
                return;
            }
            if (!card.getPin().equals("8899")){
                System.out.println("Pin is incorrect!!");
                return;
            }
            super.deposit(salaryWithoutTax);
        }else {
            super.deposit(salaryWithoutTax);
        }

    }

    @Override
    public void withdrawal(BigDecimal amount) {
        if (card != null){
            if (LocalDateTime.now().isAfter(card.getExpiredAt())){
                System.out.println("Card is Expired!");
                return;
            }
            if (amount.compareTo(card.getOverLimit())>0){
                System.out.println("Amount is over limit: " + card.getOverLimit());
                return;
            }
            if (!card.getCardNo().equals("12345678")){
                System.out.println("Card Number is invalid");
                return;
            }
            if (card.getCsv() !=123){
                System.out.println("Card CSV is incorrect!");
                return;
            }
            if (!card.getPin().equals("8899")){
                System.out.println("Pin is incorrect!!");
                return;
            }
            super.withdrawal(amount);
        }else {
            super.withdrawal(amount);
        }
    }

    @Override
    public void checkBalance() {
        super.checkBalance();
        System.out.println("Tax Rate: " + taxRate);
    }
}
