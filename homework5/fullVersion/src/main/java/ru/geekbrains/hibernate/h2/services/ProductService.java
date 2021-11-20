package ru.geekbrains.hibernate.h2.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.hibernate.h2.dao.ProductDaoImpl;
import ru.geekbrains.hibernate.h2.model.Product;

import java.util.List;

@Service
public class ProductService {
    private ProductDaoImpl productDao;

    public ProductService(ProductDaoImpl productDao) {
        this.productDao = productDao;
    }

    public List<Product> findAllProducts() {
        return productDao.findAllProducts();
    }

    public Product findProductById(Long id) {
        return productDao.findProductById(id);
    }

    public Product saveOrUpdate(Product product) {
        return productDao.saveOrUpdateProduct(product);
    }

    public void deleteProductById(Long id) {
        productDao.deleteProductById(id);
    }

    public void changeCost(Long productId, Integer delta) {
        Product product = productDao.findProductById(productId);
        product.setCost(product.getCost() + delta);
        productDao.saveOrUpdateProduct(product);
    }
}
