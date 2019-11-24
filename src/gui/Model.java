package gui;

import game.Dice;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
    //private List<String> destinations = new LinkedList<>();
    private StringProperty destination = new SimpleStringProperty();

    /*public Model() {
        destinations.add("1. Wurf");
        destinations.add("2. Wurf");
        destinations.add("3. Wurf");
    }

   public List<String> getDestinations() {
        return new LinkedList<>(destinations);
    } */

    public final void setDestination() {
        String diced1;
        Dice dice = new Dice(5);
        diced1 = dice.getResult();
        destination.setValue(diced1);
    }

    public final String getDestination() {
        return destination.get();
    }

    /*public StringProperty destinationProperty() {
        return destination;
    }*/
}
