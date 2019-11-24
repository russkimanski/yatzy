package game;

public class Dice {
    int[] rollDice;
    String result = "";

    public Dice(int numberOfThrows) {
        int[] rollDice = new int[numberOfThrows]; // Die grösse des Arrays wird mit dem Übergabewert anzahlWuerfe bestimmt.
        for (int i = 0; i < rollDice.length; i++) { //Schleife zum Füllen des Arrays
            rollDice[i] = (int) (Math.random() * 6) + 1;
            /* Zufallszahlen werden an der Stelle i gespeichert.
             * Diese Zufallszahlen sind dann allerdings Kommazahlen zwischen 0 und 1. Da du Zufallszahlen eines Würfels simulieren möchtest, müssen diese aber zwischen 1 und 6 sein.
               Wenn du den Rückgabewert der Methode Math.Random() mit sechs multiplizierst, erhältst du Kommazahlen zwischen 0 und 6 => "Math.Random()*6".
             * Indem du diesen Wert um eins erhöhst "(Math.random()*6)+1", schließt du die NULL als Zufallszahl aus. Die Zahlen beginnen dann erst bei eins.
             * Da du bei einem Würfelwurf keine Kommazahlen haben möchtest, musst du den Kommawert in einen Integerwert wandeln "(int)(Math.random()*6)+1".
             * Und diese Rückgabe speicherst du dann in dem Array „wuerfe“ unter dem entsprechenden Index ab  => "wuerfe[i]=(int)(Math.random()*6)+1;".
             */
        }
        this.rollDice = rollDice;

        //Schleife zum Lesen des Arrays und in einen String schreiben.
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
    }

    public void printOut() {
        System.out.println(result);
    }
}

