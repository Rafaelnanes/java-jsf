package rbn.edu.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rbn.edu.model.Product;

@Repository
@Transactional
public class ProductDAO extends GenericDAO<Product> {

    @Override
    protected Class<Product> getPersistenceClass() {
	return Product.class;
    }

}
