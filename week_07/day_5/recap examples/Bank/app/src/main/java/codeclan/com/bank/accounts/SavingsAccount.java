package codeclan.com.bank.accounts;

import codeclan.com.bank.customers.Customer;

/**
 * Created by user on 10/11/2017.
 */

public class SavingsAccount extends Account {
    private float interestRate;

    public SavingsAccount(String accountNumber,
                          String sortCode,
                          Customer holder,
                          float balance,
                          float interestRate) {
        super(accountNumber, sortCode, holder, balance);
        this.interestRate = interestRate;

        // So i cannot get access to this.balance
        // as it is private
        // So to update my balance
        // i would need to say
        // this.deposit(100);


    }

    public void addInterest() {
        //I cannot get access to this.balance
        //The worse thing I can do is make it public
        //because I would be breaking encapsulation
        //(public float balance)
        //To do it correctly,
        //I would expose the instance variable
        //with a getter method
        float balance = this.getBalance();
        float interest = balance * this.interestRate;
        this.deposit(interest);
    }
}
