package com.demo.gaminggears.service;

import java.util.List;

import com.demo.gaminggears.entity.Product;

public interface IProductService {

	List<Product> getAllProducts();

	void addProduct(Product p);

	void deleteById(int pid);

	Product getProductById(int pid);

	List<Product> getProductsByCategory(int catid);

	List<Product> getProductsbyDis(int disid);

}
