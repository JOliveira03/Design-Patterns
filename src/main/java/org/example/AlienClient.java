package org.example;

public abstract class AlienClient implements Client {
    private OrderingStrategy orderingStrategy;
    public AlienClient(){this.orderingStrategy=createOrderingStrategy();}
    @Override
    public void happyHourStarted(Bar bar) {
        orderingStrategy.happyHourStarted((StringBar) bar);
    }
    @Override
    public void happyHourEnded(Bar bar) {
        orderingStrategy.happyHourEnded((StringBar) bar);
    }
    @Override
    public void wants(StringDrink stringDrink, StringRecipe stringRecipe, StringBar stringBar) {
        orderingStrategy.wants(stringDrink, stringRecipe, stringBar);
    }
    protected abstract  OrderingStrategy createOrderingStrategy();
}
