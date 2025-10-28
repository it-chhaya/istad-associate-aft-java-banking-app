package co.istad.oop.banking;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Card {
    private String cardNo;
    private int csv;
    private String pin;
    private BigDecimal overLimit;
    private String cardType;

    private LocalDateTime cardAt;
    private LocalDateTime expiredAt;

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getCsv() {
        return csv;
    }

    public void setCsv(int csv) {
        this.csv = csv;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public BigDecimal getOverLimit() {
        return overLimit;
    }

    public void setOverLimit(BigDecimal overLimit) {
        this.overLimit = overLimit;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public LocalDateTime getCardAt() {
        return cardAt;
    }

    public void setCardAt(LocalDateTime cardAt) {
        this.cardAt = cardAt;
    }

    public LocalDateTime getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(LocalDateTime expiredAt) {
        this.expiredAt = expiredAt;
    }
}
