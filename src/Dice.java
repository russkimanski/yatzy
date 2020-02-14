import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Dice {
    private IntegerProperty value = new SimpleIntegerProperty();
    private boolean hold;

    public void roll() {
        value.setValue((int) (Math.random() * 6) + 1);
    }

    public IntegerProperty getValue() {
        return value;
    }

    public void setDiceValueNull() {
        value.set(0);
    }

    public void setOnHold() {
        this.hold = true;
    }

    public void setActive() {
        this.hold = false;
    }

    public boolean isHold() {
        return hold;
    }
}

