package com.example.customer;
public class Customer {
    private Loan customer;
    
    public void setCustomer(Loan customer){
        this.customer = customer;
    }

    public void toLoanNow(){
        customer.toLoan();
    }
}
