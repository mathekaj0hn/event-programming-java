// ============================================================
// OBSERVER INTERFACE
// ============================================================
// Any class that wants to receive updates from the WeatherData
// subject must implement this interface.
//
// The update() method will be called whenever new weather
// measurements are received.

public interface Observer {

    // Receives updated weather information.
    void update(float temperature, float humidity, float pressure);
}