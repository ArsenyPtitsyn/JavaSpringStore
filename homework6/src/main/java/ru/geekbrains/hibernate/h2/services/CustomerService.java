package ru.geekbrains.hibernate.h2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.hibernate.h2.dao.CustomerDao;
import ru.geekbrains.hibernate.h2.entities.Customer;
import ru.geekbrains.hibernate.h2.entities.Product;

import java.util.List;

@Service
public class CustomerService {
    private CustomerDao customerDao;

    @Autowired
    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public Customer findById(Long id) {
        return customerDao.findById(id);
    }

    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    public Customer saveOrUpdate(Customer Customer) {
        return customerDao.saveOrUpdate(Customer);
    }

    public void deleteById(Long id) {
        customerDao.deleteById(id);
    }

    public List<Product> findCustomersProducts(Long id) {
        return customerDao.findProductsOfCertainCustomer(id);
    }
}
