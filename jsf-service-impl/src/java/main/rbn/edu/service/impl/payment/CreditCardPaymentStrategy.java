package rbn.edu.service.impl.payment;

import rbn.edu.model.Payment;
import rbn.edu.service.strategy.IPaymentStrategy;

public class CreditCardPaymentStrategy implements IPaymentStrategy {

    private static final long serialVersionUID = -6763090923705570367L;

    @Override
    public void executePayment(Payment payment) {
	System.out.println("Get paid in credit card");
	System.out.println(payment.toString());

    }

}
