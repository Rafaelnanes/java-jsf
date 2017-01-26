package rbn.edu.enums;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum UserAuthorizationType {

    ADMIN("ADMIN"), VISITOR("VISITOR"), CLIENT("CLIENT");

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
	niveis.add(ADMIN);
	niveis.add(VISITOR);
	niveis.add(CLIENT);
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
