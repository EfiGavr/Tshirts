package com.mykiout.tshirts.payments;

import com.mykiout.tshirts.exceptions.PaymentException;

public class BankTrasferPayment implements Payment {
    
    /**
     * 
     * @param price
     * @throws PaymentException 
     */
    @Override
    public void pay(double price) throws PaymentException {
        System.out.println("Bank Transfer Payment goes here. Total Ammount : "+ price);
    }
}
