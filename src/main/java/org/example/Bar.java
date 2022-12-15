package org.example;

import java.util.List;

public abstract class Bar {
    protected List<BarObserver> barObserverList;
    public Bar(List<BarObserver> barObserverList){
        this.barObserverList=barObserverList;
    }
    abstract public boolean isHappyHour();
    abstract public void startHappyHour();
    abstract public void endHappyHour();
    public void addObserver(BarObserver barObserver) {
        barObserverList.add(barObserver);
    }
    public void removeObserver(BarObserver barObserver) {
        barObserverList.remove(barObserver);
    }
    public void notifyObservers() {
        for (BarObserver barObserver : barObserverList)
            if (isHappyHour()){
                barObserver.happyHourStarted(this);
            }
            else {
                barObserver.happyHourEnded(this);
            }
    }
}
