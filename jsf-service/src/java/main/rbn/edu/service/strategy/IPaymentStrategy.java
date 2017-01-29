package rbn.edu.service.strategy;

import java.io.Serializable;

import rbn.edu.model.Payment;

public interface IPaymentStrategy extends Serializable {

    void executePayment(Payment payment);

}
