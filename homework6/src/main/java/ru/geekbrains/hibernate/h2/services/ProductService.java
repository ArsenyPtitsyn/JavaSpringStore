package ru.geekbrains.hibernate.h2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.hibernate.h2.dao.ProductDao;
import ru.geekbrains.hibernate.h2.models.Product;

import java.util.List;

@Service
public class ProductService {
    private ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product findById(Long id) {
        return productDao.findById(id);
    }

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public Product saveOrUpdate(Product product) {
        return productDao.saveOrUpdate(product);
    }

    public void deleteById(Long id) {
        productDao.deleteById(id);
    }
}

