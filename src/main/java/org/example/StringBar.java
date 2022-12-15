package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringBar extends Bar{
    private boolean isHappyHour=false;
    public StringBar() {
        this(new ArrayList<>());
    }
    public StringBar(List<BarObserver> barObserverList){super(barObserverList);}
    @Override
    public boolean isHappyHour(){return isHappyHour;}
    @Override
    public void startHappyHour() {
        isHappyHour = true;
        notifyObservers();
    }
    @Override
    public void endHappyHour() {
        isHappyHour = false;
        notifyObservers();
    }
    public void order(StringDrink stringDrink, StringRecipe stringRecipe) {
        stringRecipe.mix(stringDrink);
    }
}
