package rbn.edu.service;

import rbn.edu.model.User;
import rbn.edu.model.UserLevel;

public interface IUserService extends IGenericService<User> {

    boolean isUserLogged();

    UserLevel getUserLevelById(long id);

}
