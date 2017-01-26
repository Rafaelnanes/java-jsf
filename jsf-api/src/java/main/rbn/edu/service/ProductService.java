package rbn.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rbn.edu.dao.ProductDAO;
import rbn.edu.model.Product;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    public void add(Product product) {
	productDAO.add(product);
    }

}