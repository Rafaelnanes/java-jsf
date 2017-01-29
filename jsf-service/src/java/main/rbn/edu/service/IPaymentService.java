package rbn.edu.service;

import java.io.Serializable;

import rbn.edu.model.Payment;

public interface IPaymentService extends Serializable {

    void pay(Payment payment);

}
