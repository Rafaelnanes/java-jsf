package rbn.edu.service;

import java.io.Serializable;
import java.util.List;

import rbn.edu.exceptions.BusinessException;
import rbn.edu.model.UserProduct;

public interface IUserProductService extends Serializable {

    void save(List<UserProduct> list) throws BusinessException;

    void clear(long userId) throws BusinessException;

}
