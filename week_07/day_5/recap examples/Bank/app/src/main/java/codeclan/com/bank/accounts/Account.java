package codeclan.com.bank.accounts;

import java.util.ArrayList;

import codeclan.com.bank.customers.Customer;

/**
 * Created by user on 10/11/2017.
 */

public abstract class Account {
    private String accountNumber;
    private String sortCode;
    private Customer holder;
    private float balance;

    public Account(String accountNumber,
                   String sortCode,
                   Customer holder,
                   float balance) {
        this.accountNumber = accountNumber;
        this.sortCode = sortCode;
        this.holder = holder;
        this.balance = balance;
    }

    public void deposit(float depositAmount) {
        this.balance += depositAmount;
    }

    public float getBalance() {
        return this.balance;
    }

    public void withdraw(float withdrawAmount) {
        if(this.balance - withdrawAmount >= 0) {
            this.balance -= withdrawAmount;
        }
    }
}
