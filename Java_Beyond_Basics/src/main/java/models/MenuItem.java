package models;

import Enums.MenuTypeItem;

public class MenuItem {
    //region Attributes
    private String name;
    private double price;
    private MenuTypeItem category;
    //endregion

    //region Constructors
    public MenuItem(String name, double price, MenuTypeItem category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    //endregion

    //region Getters

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public MenuTypeItem getCategory() {
        return category;
    }

    //endregion

    //region Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(MenuTypeItem category) {
        this.category = category;
    }

    //endregion

}
