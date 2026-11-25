import java.util.Observable;

// ============================================================
// LEGACY SUBJECT USING Observable
// ============================================================

@SuppressWarnings("deprecation")
public class LegacyWeatherData extends Observable {

    private float temperature;
    private float humidity;

    // Update measurements
    public void setMeasurements(float temperature, float humidity) {

        this.temperature = temperature;
        this.humidity = humidity;

        // Mark the object as changed
        setChanged();

        // Notify all registered observers
        notifyObservers();
    }

    // Getter for temperature
    public float getTemperature() {
        return temperature;
    }

    // Getter for humidity
    public float getHumidity() {
        return humidity;
    }
}