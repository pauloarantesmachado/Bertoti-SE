package com.example.customer;
public class Customer {
    private CustomerEnum customerEnum;

    public Customer(CustomerEnum customerEnum) {
        this.customerEnum = customerEnum;
    }

    public void toLoanNow(){
        Loan customer;
        if(customerEnum.name().equals("REGULAR")){
             customer = new Regular();
             customer.toLoan();
        } else if (customerEnum.name().equals("SPECIAL")) {
            customer = new Special();
            customer.toLoan();
        }else {
            customer = new Student();
            customer.toLoan();
        }
    }

}
