package rbn.edu.service;

import org.springframework.stereotype.Service;

import rbn.edu.entity.Product;

@Service
public class ProductService {

    public boolean add(Product product) {
	return product != null;
    }

}