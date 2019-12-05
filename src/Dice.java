

/* Zufallszahlen werden an der Stelle i gespeichert.
 * Diese Zufallszahlen sind dann allerdings Kommazahlen zwischen 0 und 1.
 * Wenn der Rückgabewert der Methode Math.Random() mit sechs multiplizierst wird, gibt es die Würfelzahlen.
 * Dieser Wert wird um eins erhöht um die NULL auszuschliessen.
 * Der Kommawert muss für die Würfelzahlen in einen Integerwert umgewandlet werden - (int).
 * Die grösse des Arrays wird mit dem Übergabewert anzahlWuerfe bestimmt.
 */

import java.util.Arrays;

public class Dice {
    private int result;

    public Dice() {
    }

    public int getResult() {
        return result;
    }

    public void printOut() {
        System.out.println(result);
    }

    public void roll() {
      result  = (int) (Math.random() * 6) + 1;
    }

}

