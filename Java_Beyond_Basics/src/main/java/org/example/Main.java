package org.example;

import Enums.MenuTypeItem;
import Interfaces.ApplySpecialOffer;
import Interfaces.CategorizeMenuItem;
import models.ApplySpecialOfferImpl;
import models.CategorizeMenuItemImpl;
import models.MenuItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(new MenuItem("Pasta", 250.0, MenuTypeItem.BEVERAGE));
        menuItems.add(new MenuItem("Caesar Salad", 150.0, MenuTypeItem.STARTER));
        menuItems.add(new MenuItem("Grilled Chicken", 350.0, MenuTypeItem.MAIN_COURSE));
        menuItems.add(new MenuItem("Chocolate Cake", 200.0, MenuTypeItem.DESSERT));

        CategorizeMenuItem categorizeMenuItem = new CategorizeMenuItemImpl();

        List<String> categories = new ArrayList<>();
        for (MenuItem item : menuItems) {
            categories.add(categorizeMenuItem.returnCategoryOfMenuItem(item));
        }

        ApplySpecialOffer applySpecialOffer = new ApplySpecialOfferImpl();

        menuItems.get(0).setPrice(applySpecialOffer.applyOffer(menuItems.get(0), menuItems.get(0).getPrice()));

        System.out.println(menuItems.get(0).getPrice());


        String month = "June"; String season = switch (month) { case "January", "February", "March" -> "Winter";
            case "April", "May", "June" -> "Spring";
            case "July", "August", "September" -> "Fall";
            case "October", "November", "December" -> "Spring";
            default -> "Unknown";
        };

        System.out.println("Season: " + season);

    }
}