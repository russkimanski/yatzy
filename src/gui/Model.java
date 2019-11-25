package gui;

import game.Dice;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

class Model {
    private StringProperty diced = new SimpleStringProperty();

    public final void setDestination() {
        String diced1;
        Dice dice = new Dice(5);
        diced1 = dice.getResult();
        diced.setValue(diced1);
    }

    public final String getDestination() {
        return diced.get();
    }

}
