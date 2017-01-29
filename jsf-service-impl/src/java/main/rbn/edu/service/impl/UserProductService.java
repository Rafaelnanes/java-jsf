package rbn.edu.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rbn.edu.dao.IUserProductDAO;
import rbn.edu.exceptions.BusinessException;
import rbn.edu.model.UserProduct;
import rbn.edu.service.IUserProductService;

@Service
public class UserProductService implements IUserProductService {

    private static final long serialVersionUID = -3666577666403707888L;

    @Autowired
    private IUserProductDAO userProductDAO;

    @Override
    @Transactional
    public void save(List<UserProduct> list) throws BusinessException {
	userProductDAO.save(list);
    }

    @Override
    @Transactional
    public void clear(long userId) throws BusinessException {
	userProductDAO.clear(userId);
    }

    @Override
    public List<UserProduct> getByUser(long userId) {
	return userProductDAO.getByUserId(userId);
    }

}
