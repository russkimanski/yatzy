import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

class Model {
    private StringProperty diced = new SimpleStringProperty();

    public final void rollDice() {
        String diced1;
        Dice dice = new Dice(5);
        diced1 = dice.getResult();
        diced.setValue(diced1);
    }

    public final String getDiced() {
        return diced.get();
    }

}
