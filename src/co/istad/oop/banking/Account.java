package co.istad.oop.banking;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Account {
    private String actNo;
    private String actName;
    private BigDecimal balance;
    private LocalDateTime createdAt;

    public String getActNo() {
        return actNo;
    }

    public void setActNo(String actNo) {
        this.actNo = actNo;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Account() {}

    public Account(String actNo, String actName, BigDecimal balance, LocalDateTime createdAt) {
        this.actNo = actNo;
        this.actName = actName;
        this.balance = balance;
        this.createdAt = createdAt;
    }

    public void checkBalance() {
        System.out.println("Account No: " + actNo);
        System.out.println("Account Name: " + actName);
        System.out.println("Account Balance: " + balance);
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 1) {
            System.out.println("Amount must be bigger than zero");
            return;
        }
        balance = balance.add(amount);
    }

    public void withdrawal(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 1) {
            System.out.println("Amount must be bigger than zero");
            return;
        }

        if (amount.compareTo(balance) > 0) {
            System.out.println("Insufficient balance");
            return;
        }

        balance = balance.subtract(amount);
    }

}
