package Interfaces;

import models.MenuItem;

@FunctionalInterface
public interface ApplySpecialOffer {
    double applyOffer(MenuItem menuItem, double originalPrice);
}
