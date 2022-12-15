package org.example;

public class HumanClient implements Client{
    private OrderingStrategy orderingStrategy;
    public HumanClient(OrderingStrategy orderingStrategy) {
        this.orderingStrategy = orderingStrategy;
    }
    @Override
    public void happyHourStarted(Bar bar) {
        if (bar instanceof StringBar)
            orderingStrategy.happyHourStarted((StringBar) bar);
    }
    @Override
    public void happyHourEnded(Bar bar) {
        if (bar instanceof StringBar) {
            orderingStrategy.happyHourStarted((StringBar) bar);
        }
    }
    @Override
    public void wants(StringDrink stringDrink, StringRecipe stringRecipe, StringBar stringBar) {
        orderingStrategy.wants(stringDrink, stringRecipe, stringBar);
    }
}
