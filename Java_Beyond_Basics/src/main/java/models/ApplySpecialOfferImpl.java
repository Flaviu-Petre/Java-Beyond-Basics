package models;

import Interfaces.ApplySpecialOffer;

public class ApplySpecialOfferImpl implements ApplySpecialOffer {
    @Override
    public double applyOffer(MenuItem menuItem, double originalPrice) {
        return switch (menuItem.getCategory()) {
            case STARTER -> originalPrice * 0.90;
            case MAIN_COURSE -> originalPrice * 0.85;
            case DESSERT -> originalPrice * 0.80;
            case BEVERAGE -> originalPrice * 0.95;
            default -> originalPrice;
        };
    }
}
