
package com.mykiout.tshirts.payments;

import com.mykiout.tshirts.exceptions.PaymentException;

public interface Payment {
    
    /**
     *
     * @param price
     * @throws com.mykiout.tshirts.exceptions.PaymentException
     */
    public void pay(double price) throws PaymentException;
}
