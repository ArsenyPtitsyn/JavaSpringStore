package ru.geekbrains.hibernate.h2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.hibernate.h2.services.CustomerService;
import ru.geekbrains.hibernate.h2.services.ProductService;
import ru.geekbrains.hibernate.h2.utils.SessionFactoryUtils;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext("ru.geekbrains.hibernate.h2.dao"
                , "ru.geekbrains.hibernate.h2.services", "ru.geekbrains.hibernate.h2.utils");
        CustomerService customerService = context.getBean(CustomerService.class);
        ProductService productService = context.getBean(ProductService.class);
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        try {
            customerService.deleteById(1L);
//            System.out.println(customerService.findCustomersProducts(1L));
//            productService.deleteById(1L);
//            Customer customer = new Customer("Bill");
//            customerService.saveOrUpdate(customer);
//            System.out.println(customerService.findCustomersProducts(1L));
//            System.out.println(productService.findAll());
//            System.out.println(productService.findAll());
//            System.out.println(customerService.findById(3L));
            System.out.println(customerService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }
}
