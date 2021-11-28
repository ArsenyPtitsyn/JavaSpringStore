package ru.geekbrains.hibernate.h2.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.hibernate.h2.models.Customer;
import ru.geekbrains.hibernate.h2.models.Product;
import ru.geekbrains.hibernate.h2.utils.SessionFactoryUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDao implements Dao<Customer> {
    private SessionFactoryUtils sessionFactoryUtils;

    @Autowired
    public CustomerDao(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Customer findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            session.getTransaction().commit();
            return customer;
        }
    }

    @Override
    public List<Customer> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Customer> customers = session.createQuery("from Customer").getResultList();
            session.getTransaction().commit();
            return customers;
        }
    }

    @Override
    public Customer saveOrUpdate(Customer customer) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(customer);
            session.getTransaction().commit();
            return customer;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM Customer WHERE id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    public List<Product> findCustomerProducts(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            List<Product> products = new ArrayList<>(customer.getProducts());
            session.getTransaction().commit();
            return products;
        }
    }
}
