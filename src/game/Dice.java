package game;

public class Dice {
    private String result = "";

    public Dice(int numberOfThrows) {
        int[] rollDice = new int[numberOfThrows]; //Die grösse des Arrays wird mit dem Übergabewert anzahlWuerfe bestimmt.
        for (int i = 0; i < rollDice.length; i++) { //Schleife zum Füllen des Arrays.
            rollDice[i] = (int) (Math.random() * 6) + 1;
            /* Zufallszahlen werden an der Stelle i gespeichert.
             * Diese Zufallszahlen sind dann allerdings Kommazahlen zwischen 0 und 1.
             * Wenn der Rückgabewert der Methode Math.Random() mit sechs multiplizierst wird, gibt es die Würfelzahlen.
             * Dieser Wert wird um eins erhöht um die NULL auszuschliessen.
             * Der Kommawert muss für die Würfelzahlen in einen Integerwert umgewandlet werden - (int).
             */
        }

        //Schleife zum Lesen des Arrays:
        for (int i = 0; i < rollDice.length; i++) {
            if (i + 1 < rollDice.length) {
                result += rollDice[i] + ", "; //Ausgabe des Wertes im Fach i
            } else {
                result += rollDice[i] + "";
            }
        }

    }

    public String getResult() {
        return result;
    } //Methode zur Ausgabe als String

    public void printOut() {
        System.out.println(result);
    } //Methode zur Ausgabe in Konsole
}

