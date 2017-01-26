package rbn.edu.util;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class UtilJSF {

    public static Map<String, String> getParameters() {
	FacesContext fc = FacesContext.getCurrentInstance();
	Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
	return params;
    }

    public static void FaceMessage(String mensagem) {
	FacesMessage msg = new FacesMessage(mensagem);
	FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public static void FaceMessage(String mensagem, String detalheMensagem, String idComponente) {
	detalheMensagem = detalheMensagem == null ? mensagem : detalheMensagem;
	FacesContext.getCurrentInstance().addMessage(idComponente,
		new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, detalheMensagem));
    }

}
