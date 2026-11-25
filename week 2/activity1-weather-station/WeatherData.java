import java.util.ArrayList;
import java.util.List;

// ============================================================
// CONCRETE SUBJECT - WeatherData
// ============================================================

public class WeatherData implements Subject {

    // List of registered observers
    private List<Observer> observers;

    // Weather measurements
    private float temperature;
    private float humidity;
    private float pressure;

    // Constructor
    public WeatherData() {
        observers = new ArrayList<>();
    }

    // Register an observer
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);

        System.out.println("[WeatherData] Observer registered: "
                + o.getClass().getSimpleName());
    }

    // Remove an observer
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);

        System.out.println("[WeatherData] Observer removed: "
                + o.getClass().getSimpleName());
    }

    // Notify all registered observers
    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature, humidity, pressure);
        }
    }

    // Update weather measurements
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        System.out.println("\n[WeatherData] New measurements received!");

        notifyObservers();
    }
}