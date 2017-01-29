package rbn.edu.service.impl;

import org.springframework.stereotype.Service;

import rbn.edu.enums.PaymentEnum;
import rbn.edu.model.Payment;
import rbn.edu.service.IPaymentService;
import rbn.edu.service.impl.payment.CashPaymentStrategy;
import rbn.edu.service.impl.payment.CreditCardPaymentStrategy;
import rbn.edu.service.impl.payment.DebitCardPaymentStrategy;
import rbn.edu.service.strategy.IPaymentStrategy;

@Service
public class PaymentService implements IPaymentService {

    private static final long serialVersionUID = -3357866054343824833L;

    @Override
    public void pay(Payment payment) {
	IPaymentStrategy command = null;
	if (PaymentEnum.CASH.equals(payment.getType())) {
	    command = new CashPaymentStrategy();
	} else if (PaymentEnum.CREDIT_CARD.equals(payment.getType())) {
	    command = new CreditCardPaymentStrategy();
	} else {
	    command = new DebitCardPaymentStrategy();
	}
	command.executePayment(payment);
    }

}
