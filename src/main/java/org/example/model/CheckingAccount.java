package org.example.model;

import org.example.exceptions.ExceededLimitException;
import org.example.exceptions.InvalidAmountException;

public class CheckingAccount extends BankAccount {
    private double dailyWithdrawalLimit = 300.0; // 300 за замовченням[cite: 11]

    public CheckingAccount(String customerName, Long accountNumber, Long userId, String userPassword) {
        super(customerName, accountNumber, userId, userPassword);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Сума зняття повинна бути більше 0.");
        }
        if (amount > dailyWithdrawalLimit) {
            throw new ExceededLimitException("Сума перевищує денний ліміт зняття (" + dailyWithdrawalLimit + ").");
        }
        super.withdraw(amount);
    }

    public double getDailyWithdrawalLimit() { return dailyWithdrawalLimit; }
    public void setDailyWithdrawalLimit(double dailyWithdrawalLimit) { this.dailyWithdrawalLimit = dailyWithdrawalLimit; }
}