package Interfaces;

import models.MenuItem;

@FunctionalInterface
public interface CategorizeMenuItem {
    String returnCategoryOfMenuItem(MenuItem menuItem);
}
