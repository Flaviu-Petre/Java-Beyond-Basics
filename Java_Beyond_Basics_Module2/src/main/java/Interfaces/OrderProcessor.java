package Interfaces;

import models.Item;
import models.Cart;

public interface OrderProcessor extends DiscountCalculator {

    default void addItemToCart(Cart cart, Item item) {
        if (cart != null && item != null) {
            cart.getItems().add(item);
            System.out.println("Added " + item.getName() + " to cart");
        } else {
            System.out.println("Cannot add item: Cart or Item is null");
        }
    }

    default void removeItemFromCart(Cart cart, Item item) {
        if (cart != null && item != null && cart.getItems().contains(item)) {
            cart.getItems().remove(item);
            System.out.println("Removed " + item.getName() + " from cart");
        } else {
            System.out.println("Cannot remove item: Cart or Item is null, or Item not in Cart");
        }
    }

    default double calculateTotalPrice(Cart cart) {
        if (cart == null) {
            System.out.println("Cart is null");
            return 0.0;
        }
        return cart.getItems().stream().mapToDouble(Item::getPrice).sum();
    }

    default double calculateDiscountPrice(Cart cart) {
        if (cart == null) {
            System.out.println("Cart is null");
            return 0.0;
        }

        double totalPrice = calculateTotalPrice(cart);
        double discountRate = 0.1;

        return DiscountCalculator.applyDiscount(totalPrice, discountRate);
    }

    default void applyBOGOOffer(Cart cart) {
        DiscountCalculator.buyOneGetOneFree(cart);
    }


}
