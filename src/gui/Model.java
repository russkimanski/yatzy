package gui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private List<String> destinations = new LinkedList<>();
    private StringProperty destination = new SimpleStringProperty();

    public Model() {
        destinations.add("Athen");
        destinations.add("Berlin");
        destinations.add("Chicago");
        destinations.add("Dubai");
    }

    public final List<String> getDestinations() {
        return new LinkedList<>(destinations);
    }

    public final void setDestination(String value) {
        destination.setValue(value);
    }

    public final String getDestination() {
        return destination.get();
    }

    public StringProperty destinationProperty() {
        return destination;
    }
}
