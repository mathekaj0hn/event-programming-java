
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PropertyChangeDemo {

    static class Person {

        private String name;

        private PropertyChangeSupport support =
                new PropertyChangeSupport(this);

        public void addPropertyChangeListener(
                PropertyChangeListener listener) {
            support.addPropertyChangeListener(listener);
        }

        public void setName(String name) {
            String oldName = this.name;
            this.name = name;

            support.firePropertyChange("name", oldName, name);
        }
    }

    public static void main(String[] args) {

        Person person = new Person();

        // Listener A
        person.addPropertyChangeListener(event -> {
            System.out.println("Listener A: "
                    + event.getOldValue()
                    + " -> "
                    + event.getNewValue());
        });

        // Listener B
        person.addPropertyChangeListener(event -> {
            System.out.println("Listener B: Name changed to "
                    + event.getNewValue());
        });

        person.setName("Alice");
        person.setName("Bob");
    }
}
