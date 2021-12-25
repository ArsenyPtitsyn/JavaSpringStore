package ru.geekbrains.spring.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Cart cart = context.getBean("cart", Cart.class);

        Scanner scanner = new Scanner(System.in);
        String str;

        while (!(str = scanner.nextLine()).equals("exit")) {
            if (str.startsWith("/add")) {
                Long id = Long.parseLong(str.split("\\s")[1]);
                cart.addProductInCartById(id);
            } else if (str.startsWith("/del")) {
                Long id = Long.parseLong(str.split("\\s")[1]);
                cart.deleteProductFromCartById(id);
            } else if (str.equals("/show")) {
                System.out.println(cart.showProductsInCart());
            }
        }

        scanner.close();
        context.close();
    }
}
