package rbn.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rbn.edu.dao.IProductDAO;
import rbn.edu.exceptions.BusinessException;
import rbn.edu.model.Product;
import rbn.edu.service.IProductService;

@Service
public class ProductService implements IProductService {

    private static final long serialVersionUID = -5974871729758393939L;

    @Autowired
    private IProductDAO productDAO;

    @Override
    @Transactional
    public void add(Product t) throws BusinessException {
	try {
	    productDAO.add(t);
	} catch (Exception e) {
	    new BusinessException(e.getMessage());
	}
    }

    @Override
    @Transactional
    public void update(Product t) throws BusinessException {
	productDAO.update(t);
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
    public void remove(long id) throws BusinessException {
	productDAO.remove(id);
    }

}