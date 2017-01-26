package rbn.edu.enums;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum TipoAutorizacaoUsuario {

    ADMIN("ADMIN"), VISITOR("VISITOR"), CLIENT("CLIENT");

    private final String text;

    private TipoAutorizacaoUsuario(final String text) {
	this.text = text;
    }

    @Override
    public String toString() {
	return text;
    }

    public static Set<TipoAutorizacaoUsuario> getValues() {
	Set<TipoAutorizacaoUsuario> niveis = new HashSet<TipoAutorizacaoUsuario>();
	niveis.add(ADMIN);
	niveis.add(VISITOR);
	niveis.add(CLIENT);
	return niveis;
    }

    public static List<String> getStringValues() {
	List<String> lista = new ArrayList<String>();
	for (TipoAutorizacaoUsuario tipo : getValues()) {
	    lista.add(tipo.toString());
	}
	return lista;
    }

    public static TipoAutorizacaoUsuario[] getArrayValues() {
	List<String> lista = new ArrayList<String>();
	for (TipoAutorizacaoUsuario tipo : getValues()) {
	    lista.add(tipo.toString());
	}
	return (TipoAutorizacaoUsuario[]) lista.toArray();
    }

}
