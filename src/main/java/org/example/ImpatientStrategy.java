package org.example;

public class ImpatientStrategy implements OrderingStrategy{
    @Override
    public void wants(StringDrink stringDrink, StringRecipe stringRecipe, StringBar stringBar) {
        stringBar.order(stringDrink, stringRecipe);
    }
    @Override
    public void happyHourStarted(StringBar stringBar) {
    }
    @Override
    public void happyHourEnded(StringBar stringBar) {
    }
}
