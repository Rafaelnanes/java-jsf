package rbn.edu.util;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class UtilJSF {

    public static Map<String, String> getParameters() {
	FacesContext fc = FacesContext.getCurrentInstance();
	return fc.getExternalContext().getRequestParameterMap();
    }

    public static void FaceMessage(String mensagem) {
	FacesMessage msg = new FacesMessage(mensagem);
	FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public static void FaceMessageError(String mensagem) {
	FacesContext.getCurrentInstance().addMessage(null,
		new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", mensagem));
    }

}
