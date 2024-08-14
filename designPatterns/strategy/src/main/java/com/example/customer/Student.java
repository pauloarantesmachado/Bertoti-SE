package com.example.customer;

public class Student implements Loan{
    @Override
    public void toLoan() {
        System.out.println("To loan student");
    }
}
