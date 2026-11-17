package org.example.model;

import org.example.exceptions.InsufficientBalanceException;
import org.example.exceptions.InvalidAmountException;

public class BankAccount {
    private String customerName;
    private Long accountNumber;
    private Long userId;
    private String userPassword;
    private double accountBalance;

    public BankAccount(String customerName, Long accountNumber, Long userId, String userPassword) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.userId = userId;
        this.userPassword = userPassword;
        this.accountBalance = 0.0; // Баланс 0 при створенні
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Сума внеску повинна бути більше 0.");
        }
        this.accountBalance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Сума зняття повинна бути більше 0.");
        }
        if (amount > this.accountBalance) {
            throw new InsufficientBalanceException("Недостатньо коштів на рахунку.");
        }
        this.accountBalance -= amount;
    }

    public String getCustomerName() { return customerName; }
    public Long getAccountNumber() { return accountNumber; }
    public Long getUserId() { return userId; }
    public String getUserPassword() { return userPassword; }
    public double getAccountBalance() { return accountBalance; }
}