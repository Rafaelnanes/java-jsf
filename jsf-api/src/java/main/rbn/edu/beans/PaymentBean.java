package rbn.edu.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import rbn.edu.enums.PaymentEnum;
import rbn.edu.model.Payment;
import rbn.edu.model.User;
import rbn.edu.model.UserProduct;
import rbn.edu.service.IPaymentService;
import rbn.edu.service.IUserProductService;
import rbn.edu.service.IUserService;

@ManagedBean
@ViewScoped
public class PaymentBean {

    @ManagedProperty(value = "#{paymentService}")
    private IPaymentService service;

    @ManagedProperty(value = "#{userProductService}")
    private IUserProductService userProductService;

    @ManagedProperty(value = "#{userService}")
    private IUserService userService;

    private List<PaymentEnum> paymentTypes = new ArrayList<PaymentEnum>();
    private Payment payment = new Payment();

    @PostConstruct
    protected void init() {
	payment.setUserProducts(new ArrayList<UserProduct>());
	for (PaymentEnum type : PaymentEnum.values()) {
	    paymentTypes.add(type);
	}
    }

    public void pay() {
	User user = userService.getUserLogged();
	List<UserProduct> cartItens = userProductService.getByUser(user.getId());
	payment.setUserProducts(cartItens);
	service.pay(payment);
    }

    public Payment getPayment() {
	return payment;
    }

    public void setPayment(Payment payment) {
	this.payment = payment;
    }

    public List<PaymentEnum> getPaymentTypes() {
	return paymentTypes;
    }

    public void setPaymentTypes(List<PaymentEnum> paymentTypes) {
	this.paymentTypes = paymentTypes;
    }

    public void setService(IPaymentService service) {
	this.service = service;
    }

    public void setUserProductService(IUserProductService userProductService) {
	this.userProductService = userProductService;
    }

    public void setUserService(IUserService userService) {
	this.userService = userService;
    }

}
