package org.example;

public class SmartStrategy implements OrderingStrategy{
    private StringOrder stringOrder;
    @Override
    public void wants(StringDrink stringDrink, StringRecipe stringRecipe, StringBar stringBar) {
        if (stringBar.isHappyHour()) {
            stringBar.order(stringDrink, stringRecipe);
        } else {
            this.stringOrder = new StringOrder(stringBar, stringRecipe, stringDrink);
        }
    }
    @Override
    public void happyHourStarted(StringBar stringBar) {
        if (stringOrder != null && stringOrder.stringBar.equals(stringBar)) {
            stringBar.order(stringOrder.stringDrink, stringOrder.stringRecipe);
        }
    }
    @Override
    public void happyHourEnded(StringBar stringBar) {
    }
    private static class StringOrder {
        private final StringBar stringBar;
        private final StringRecipe stringRecipe;
        private final StringDrink stringDrink;

        public StringOrder(StringBar stringBar, StringRecipe stringRecipe, StringDrink stringDrink) {
            this.stringBar = stringBar;
            this.stringRecipe = stringRecipe;
            this.stringDrink = stringDrink;
        }
    }
}
