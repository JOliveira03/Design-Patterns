package org.example;

public interface OrderingStrategy {
    void wants(StringDrink stringDrink, StringRecipe stringRecipe, StringBar stringBar);
    void happyHourStarted(StringBar stringBar);
    void happyHourEnded(StringBar stringBar);
}
