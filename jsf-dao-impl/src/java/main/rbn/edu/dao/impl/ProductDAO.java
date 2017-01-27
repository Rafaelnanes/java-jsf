package rbn.edu.dao.impl;

import org.springframework.stereotype.Repository;

import rbn.edu.dao.IProductDAO;
import rbn.edu.model.Product;

@Repository
public class ProductDAO extends GenericDAO<Product> implements IProductDAO {

    @Override
    protected Class<Product> getPersistenceClass() {
	return Product.class;
    }

}
