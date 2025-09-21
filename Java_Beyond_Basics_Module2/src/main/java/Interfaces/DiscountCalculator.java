package Interfaces;

import models.Cart;

public interface DiscountCalculator {

    static double applyDiscount(double totalPrice, double discountRate) {
        if (discountRate < 0 || discountRate > 1) {
            throw new IllegalArgumentException("Discount rate must be between 0 and 1");
        }
        return totalPrice * (1 - discountRate);
    }

    static void buyOneGetOneFree(Cart cart) {
        if (cart == null || cart.getItems().isEmpty()) {
            System.out.println("Cart is empty or null");
            return;
        }

        int itemCount = cart.getItems().size();
        if (itemCount < 2) {
            System.out.println("Not enough items for BOGO offer");
            return;
        }

        for (int i = 1; i < itemCount; i += 2) {
            cart.getItems().remove(i);
            itemCount--;
        }
        System.out.println("Applied BOGO offer");
    }
}
