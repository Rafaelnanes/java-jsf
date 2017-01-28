package rbn.edu.enums;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum UserAuthorizationType {

    ROLE_ADMIN("ROLE_ADMIN"), ROLE_VISITOR("ROLE_VISITOR"), ROLE_CUSTOMER("ROLE_CUSTOMER");

    private final String text;

    private UserAuthorizationType(final String text) {
	this.text = text;
    }

    @Override
    public String toString() {
	return text;
    }

    public static Set<UserAuthorizationType> getValues() {
	Set<UserAuthorizationType> niveis = new HashSet<UserAuthorizationType>();
	niveis.add(ROLE_ADMIN);
	niveis.add(ROLE_VISITOR);
	niveis.add(ROLE_CUSTOMER);
	return niveis;
    }

    public static List<String> getStringValues() {
	List<String> lista = new ArrayList<String>();
	for (UserAuthorizationType tipo : getValues()) {
	    lista.add(tipo.toString());
	}
	return lista;
    }

    public static UserAuthorizationType[] getArrayValues() {
	List<String> lista = new ArrayList<String>();
	for (UserAuthorizationType tipo : getValues()) {
	    lista.add(tipo.toString());
	}
	return (UserAuthorizationType[]) lista.toArray();
    }

}
