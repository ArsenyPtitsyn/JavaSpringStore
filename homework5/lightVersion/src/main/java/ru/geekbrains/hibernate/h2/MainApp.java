package ru.geekbrains.hibernate.h2;

public class MainApp {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);
            System.out.println(productDao.findAllProducts());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }
}