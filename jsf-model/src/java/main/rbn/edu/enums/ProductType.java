package rbn.edu.enums;

public enum ProductType {

    UTILIY(0), CAR(1), CLOTH(2);

    private ProductType(int value) {
	this.value = value;
    }

    private int value;

    @Override
    public String toString() {
	return String.valueOf(value);
    }
}
