package common;

import java.util.ArrayList;
import java.util.List;

abstract public class BaseObservable implements Observable {
    public List<Observer> observers;

    public BaseObservable() {
        observers = new ArrayList<>();
    }

    @Override
    public boolean addObserver(Observer observer) {
        return observers.add(observer);
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public boolean removeObserver(Observer observer) {
        return observers.remove(observer);
    }
}
