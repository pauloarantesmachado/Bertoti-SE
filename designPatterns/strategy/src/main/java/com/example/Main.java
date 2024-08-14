package com.example;

import com.example.customer.Customer;
import com.example.customer.CustomerEnum;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(CustomerEnum.REGULAR);
        customer.toLoanNow();

        Customer customer2 = new Customer(CustomerEnum.SPECIAL);
        customer2.toLoanNow();

        Customer customer3 = new Customer(CustomerEnum.STUDENT);
        customer3.toLoanNow();
    }
}