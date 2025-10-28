package co.istad.oop.banking;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;

public class SavingAccount extends Account {

    private float interestRate;
    private Card card;

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public SavingAccount(String actNo, String actName, BigDecimal balance, LocalDateTime createdAt, float interestRate, Card card) {
        super(actNo, actName, balance, createdAt);
        this.interestRate = interestRate;
        this.card = card;
    }

    public BigDecimal calculateInterestAmount() {
        // Find number of years
        long days = Duration.between(getCreatedAt(), LocalDateTime.now()).toDays();
        if (days > 365) {
            BigDecimal interestRateDivideBy100 = BigDecimal.valueOf(interestRate / 100);
            return getBalance().multiply(interestRateDivideBy100).setScale(3, RoundingMode.FLOOR);
        } else {
            return BigDecimal.ZERO;
        }
    }

    @Override
    public void checkBalance() {
        super.checkBalance();
        System.out.println("Interest Rate: " + interestRate);
        System.out.println("Interest Amount: " + calculateInterestAmount());
    }

    @Override
    public void deposit(BigDecimal amount) {
        super.deposit(amount);
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

}
