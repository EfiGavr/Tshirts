package com.mykiout.tshirts.model;

import com.mykiout.tshirts.exceptions.PaymentException;
import com.mykiout.tshirts.payments.Payment;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Order acts like Cart in online Payments
 *
 * @author Hp
 */
public class Order {

    private List<TShirt> tshirts;

    public Order() {
        tshirts = new ArrayList<TShirt>();
    }

    /**
     * Add a new Tshirt on the List
     *
     * @param tshirt
     */
    public void addTshirt(TShirt tshirt) {
        tshirts.add(tshirt);
    }

    /**
     * Remove a Tshirt from the List
     *
     * @param tshirt
     */
    public void removeTshirt(TShirt tshirt) {
        tshirts.remove(tshirt);
    }

    /**
     * Returns the total amount of all the tshirts we have in our List .
     *
     * @return
     */
    public double getTotalAmount() {
        double totalAmount = 0.0;
        for (TShirt currentTshirt : tshirts) {
            totalAmount += currentTshirt.getPrice();
        }
        return totalAmount;
    }

    /**
     * Take as parameter the payment method and continue to checkout-payment
     * after getting the total amount of the order
     *
     * @param paymentMethod
     * @throws PaymentException
     */
    public void checkout(Payment paymentMethod) throws PaymentException {
        double totalAmount = getTotalAmount();
        paymentMethod.pay(totalAmount);
    }

}
