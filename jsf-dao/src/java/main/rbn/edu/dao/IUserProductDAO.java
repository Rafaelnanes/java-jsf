package rbn.edu.dao;

import java.io.Serializable;
import java.util.List;

import rbn.edu.model.UserProduct;

public interface IUserProductDAO extends Serializable {

    void save(List<UserProduct> list);

    void clear(long userId);

}
