package rbn.edu.service;

import rbn.edu.model.User;

public interface IUserService extends IGenericService<User>{
	
	boolean isUserLogged();

}
