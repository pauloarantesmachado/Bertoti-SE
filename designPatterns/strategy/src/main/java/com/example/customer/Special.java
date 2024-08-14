package com.example.customer;

public class Special implements Loan{
    @Override
    public void toLoan() {
        System.out.println("To loan a special customer");
    }
}
