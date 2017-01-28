package rbn.edu.validators;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("rbn.edu.validators.ProductValueValidator")
public class ProductValueValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent component, Object obj) throws ValidatorException {

	BigDecimal bigDecimal = (BigDecimal) obj;

	if (bigDecimal.compareTo(BigDecimal.ONE) == -1) {
	    FacesMessage msg = new FacesMessage("Product value error.", "The number must be bigger than 1.");
	    msg.setSeverity(FacesMessage.SEVERITY_ERROR);
	    throw new ValidatorException(msg);
	}

    }

}
