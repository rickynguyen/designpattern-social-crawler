package common;

public interface Observable {
    public boolean addObserver(Observer observer);

    public boolean removeObserver(Observer observer);
}
