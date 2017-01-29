package rbn.edu.enums;

public enum PaymentEnum {

    CREDIT_CARD("Credit card"), DEBIT_CARD("Debit card"), CASH("In cash");

    private String description;

    private PaymentEnum(String description) {
	this.description = description;
    }

    @Override
    public String toString() {
	return description;
    }

    public String getDescription() {
	return description;
    }
}
