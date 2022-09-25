
package com.mykiout.tshirts.payments;

import com.mykiout.tshirts.exceptions.PaymentException;

public class CreditCardPayment implements Payment{

    /**
     * 
     * @param price
     * @throws PaymentException 
     */
    @Override
    public void pay(double price) throws PaymentException {
        System.out.println("Credit Card Payment goes here. Total Ammount : "+ price);    }
    
}
