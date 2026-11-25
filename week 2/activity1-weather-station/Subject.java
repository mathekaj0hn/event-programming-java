// ============================================================
// SUBJECT INTERFACE
// ============================================================
// Defines the operations that any publisher (Subject) must
// support in the Observer pattern.

public interface Subject {

    // Add an observer to the notification list.
    void registerObserver(Observer o);

    // Remove an observer from the notification list.
    void removeObserver(Observer o);

    // Notify all registered observers when data changes.
    void notifyObservers();
}