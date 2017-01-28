package rbn.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rbn.edu.dao.IProductDAO;
import rbn.edu.model.Product;
import rbn.edu.service.IProductService;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductDAO productDAO;

    @Override
    @Transactional
    public Product add(Product t) {
	return productDAO.add(t);
    }

    @Override
    @Transactional
    public Product update(Product t) {
	return productDAO.update(t);
    }

    @Override
    @Transactional
    public List<Product> getAll() {
	return productDAO.getAll();
    }

    @Override
    @Transactional
    public Product getById(long id) {
	return productDAO.getById(id);
    }

    @Override
    @Transactional
    public void remove(long id) {
	productDAO.remove(id);
    }

}