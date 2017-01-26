package rbn.edu.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rbn.edu.model.UserLevel;

@Repository
@Transactional
public class UserLevelDAO extends GenericDAO<UserLevel> {

    @Override
    protected Class<UserLevel> getPersistenceClass() {
	return UserLevel.class;
    }

}
