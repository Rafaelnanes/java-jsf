package rbn.edu.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rbn.edu.dao.IUserLevelDAO;
import rbn.edu.model.UserLevel;

@Repository
@Transactional
public class UserLevelDAO extends GenericDAO<UserLevel> implements IUserLevelDAO {

    @Override
    protected Class<UserLevel> getPersistenceClass() {
	return UserLevel.class;
    }

}
