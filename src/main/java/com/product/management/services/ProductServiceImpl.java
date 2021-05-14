package com.product.management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.product.management.model.Product;
import com.product.management.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub\
		return productRepository.findAll();

	}

	public float getPriceByProductId(Long productId) {

		Optional<Product> optional = productRepository.findById(productId);
		optional.orElseThrow(() -> new ProductNotFoundException("product not found with " + productId));
		return optional.map(Product::getPrice).orElse(productId);

	}
	public Optional<Product> getProductById(Long productId) {
		return productRepository.findById(productId);
	}
}
