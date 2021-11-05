package com.geekbrains.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

    // http://localhost:8080/Spring1homework/cart
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product(1, "milk", 100));
        products.add(new Product(2, "bread", 50));
        products.add(new Product(3, "potato", 30));
        products.add(new Product(4, "carrot", 25));
        products.add(new Product(5, "onion", 20));
        products.add(new Product(6, "beer", 70));
        products.add(new Product(7, "cookies", 150));
        products.add(new Product(8, "olive oil", 500));
        products.add(new Product(9, "sunflower oil", 90));
        products.add(new Product(10, "beet", 40));

        for (Product p: products) {
            resp.getWriter().println("<h1>" + p.toString() + "</h1>");
        }
    }
}
