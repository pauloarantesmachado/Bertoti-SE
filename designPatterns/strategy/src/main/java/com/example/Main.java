package com.example;

import com.example.customer.Customer;

import com.example.customer.Regular;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setCustomer(new Regular());
        customer.toLoanNow();
    }
}