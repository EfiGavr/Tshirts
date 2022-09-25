package com.mykiout.tshirts.runnables;

import com.mykiout.tshirts.enums.ColorEnum;
import com.mykiout.tshirts.enums.FabricEnum;
import com.mykiout.tshirts.enums.SizeEnum;
import com.mykiout.tshirts.exceptions.PaymentException;
import com.mykiout.tshirts.model.Order;
import com.mykiout.tshirts.model.TShirt;
import com.mykiout.tshirts.payments.BankTrasferPayment;
import com.mykiout.tshirts.payments.CashPayment;
import com.mykiout.tshirts.payments.CreditCardPayment;
import com.mykiout.tshirts.payments.Payment;
import java.util.ArrayList;
import java.util.List;

public class CheckoutExecutor {

    public static void main(String[] args) throws PaymentException {

        List<TShirt> tshirts = createAllVariations();
        Order order = new Order();
        for (TShirt tshirt : tshirts) {
            order.addTshirt(tshirt);
        }
        Payment paymentMethod = new CashPayment();

        order.checkout(paymentMethod);

        // In case of other way of Payment :
        //        paymentMethod = new BankTrasferPayment();
        //        order.checkout(paymentMethod);
        //        
        //        paymentMethod = new CreditCardPayment();
        //        order.checkout(paymentMethod);
    }

    public static List<TShirt> createAllVariations() {
        List<TShirt> tshirts = new ArrayList<TShirt>();
        /**
         * Create a counter so we know how many items we have on the list of
         * TShirts
         */
        int counter = 0;
        /**
         * Create, add to the order and print all the possible combinations of
         * Tshirts
         */
        for (ColorEnum color : ColorEnum.values()) {
            for (SizeEnum size : SizeEnum.values()) {
                for (FabricEnum fabric : FabricEnum.values()) {
                    TShirt tshirt = new TShirt(color, size, fabric);
                    tshirts.add(tshirt);
//                    System.out.println(color.name() + " - " + size.name() + " - " + fabric.name());
                    counter++;
                }
            }
        }
        System.out.println("Counter = " + counter);
        return tshirts;
    }
}
