package models;

import Interfaces.CategorizeMenuItem;

public class CategorizeMenuItemImpl implements CategorizeMenuItem {
    @Override
    public String returnCategoryOfMenuItem(MenuItem menuItem) {
        return switch (menuItem.getCategory()) {
            case STARTER -> "This is a starter item.";
            case MAIN_COURSE -> "This is a main course item.";
            case DESSERT -> "This is a dessert item.";
            case BEVERAGE -> "This is a beverage item.";
            default -> "Unknown category.";
        };
    }
}
