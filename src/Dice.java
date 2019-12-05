

/* Zufallszahlen werden an der Stelle i gespeichert.
 * Diese Zufallszahlen sind dann allerdings Kommazahlen zwischen 0 und 1.
 * Wenn der Rückgabewert der Methode Math.Random() mit sechs multiplizierst wird, gibt es die Würfelzahlen.
 * Dieser Wert wird um eins erhöht um die NULL auszuschliessen.
 * Der Kommawert muss für die Würfelzahlen in einen Integerwert umgewandlet werden - (int).
 * Die grösse des Arrays wird mit dem Übergabewert anzahlWuerfe bestimmt.
 */

import java.util.Arrays;

public class Dice {
    private String result = "";
    private final int[] rollDice;

    public Dice(int numberOfThrows) {
        rollDice = new int[numberOfThrows];
        setRollDice();
    }

    private void setResult() {
        for (int i = 0; i < rollDice.length; i++) {
            if (i + 1 < rollDice.length) {
                result += rollDice[i] + ", ";
            } else {
                result += rollDice[i] + "";
            }
        }
    }

    private void setRollDice() {
        Arrays.setAll(rollDice, i -> (int) (Math.random() * 6) + 1);
        setResult();
    }

    public String getResult() {
        return result;
    }

    public void printOut() {
        System.out.println(result);
    }
}

