package org.example;

public interface Client extends BarObserver{
    void wants(StringDrink stringDrink, StringRecipe stringRecipe, StringBar stringBar);
}
