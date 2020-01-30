import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Dice {
    private IntegerProperty value = new SimpleIntegerProperty();
    //ToDo: Review Pesche
    private boolean hold;

    public void roll() {
        value.setValue((int) (Math.random() * 6) + 1);
    }

    public IntegerProperty getValue() {
        return value;
    }

    //ToDo: Review Pesche
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

