package rbn.edu.service.impl.payment;

import rbn.edu.model.Payment;
import rbn.edu.service.strategy.IPaymentStrategy;

public class DebitCardPaymentStrategy implements IPaymentStrategy {

    private static final long serialVersionUID = -1904853846711906333L;

    @Override
    public void executePayment(Payment payment) {
	System.out.println("Get paid in debit card");
	System.out.println(payment.toString());

    }

}
