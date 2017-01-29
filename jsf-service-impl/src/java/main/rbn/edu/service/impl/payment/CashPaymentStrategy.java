package rbn.edu.service.impl.payment;

import rbn.edu.model.Payment;
import rbn.edu.service.strategy.IPaymentStrategy;

public class CashPaymentStrategy implements IPaymentStrategy {

    private static final long serialVersionUID = -5784149070745309527L;

    @Override
    public void executePayment(Payment payment) {
	System.out.println("Get paid in cash");
	System.out.println(payment.toString());
    }

}
