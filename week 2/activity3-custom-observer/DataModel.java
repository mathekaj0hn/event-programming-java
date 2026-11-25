import java.util.ArrayList;
import java.util.List;

public class DataModel implements DataSubject {

    private int value;
    private List<DataObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(DataObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(DataObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (DataObserver observer : observers) {
            observer.onDataChanged(value);
        }
    }

    public void setValue(int value) {
        this.value = value;
        notifyObservers();
    }
}