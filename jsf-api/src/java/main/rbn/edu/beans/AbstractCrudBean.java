package rbn.edu.beans;

import rbn.edu.config.AppConstants;
import rbn.edu.enums.OperationEnum;
import rbn.edu.util.UtilJSF;

public abstract class AbstractCrudBean extends AbstractBean {

    private static final long serialVersionUID = -5125902510965340624L;

    protected OperationEnum operationName;

    public AbstractCrudBean() {
	String operation = UtilJSF.getParameters().get(AppConstants.PARAM_OPERATION);
	// String id = UtilJSF.getParameters().get("id");
	// if (id != null) {
	// getBydId(Long.valueOf(id));
	// }
	if (operation != null) {
	    operationName = OperationEnum.valueOf(operation);
	} else {
	    operationName = OperationEnum.CREATE;
	}
    }

    public String getActionName() {
	String name = "";
	if (isOperationCreate()) {
	    name = "Create";
	} else {
	    name = "Update";
	}
	return name;
    }

    public void executeOperation() {
	if (isOperationCreate()) {
	    create();
	} else {
	    update();
	}
    }

    private boolean isOperationCreate() {
	return operationName == null || operationName.equals(OperationEnum.CREATE);
    }

    // protected abstract void getBydId(long id);

    public abstract void create();

    public abstract void update();

}
