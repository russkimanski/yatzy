package game;

public class Dice {

    static void throwDice(int numberOfThrows) {
        int[] rollDice = new int[numberOfThrows]; // Die grösse des Arrays wird mit dem Übergabewert anzahlWuerfe bestimmt.

//Schleife zum Füllen des Arrays
        for (int i = 0; i < rollDice.length; i++) {
            rollDice[i] = (int) (Math.random() * 6) + 1;
            /* Zufallszahlen werden an der Stelle i gespeichert.
             * Diese Zufallszahlen sind dann allerdings Kommazahlen zwischen 0 und 1. Da du Zufallszahlen eines Würfels simulieren möchtest, müssen diese aber zwischen 1 und 6 sein.
               Wenn du den Rückgabewert der Methode Math.Random() mit sechs multiplizierst, erhältst du Kommazahlen zwischen 0 und 6 => "Math.Random()*6".
             * Indem du diesen Wert um eins erhöhst "(Math.random()*6)+1", schließt du die NULL als Zufallszahl aus. Die Zahlen beginnen dann erst bei eins.
             * Da du bei einem Würfelwurf keine Kommazahlen haben möchtest, musst du den Kommawert in einen Integerwert wandeln "(int)(Math.random()*6)+1".
             * Und diese Rückgabe speicherst du dann in dem Array „wuerfe“ unter dem entsprechenden Index ab  => "wuerfe[i]=(int)(Math.random()*6)+1;".
             */
        }

//Schleife zum Lesen des Arrays
        for (int i = 0; i < rollDice.length; i++) {
            System.out.println(rollDice[i]); //Ausgabe des Wertes im Fach i
        }
    }

    public static void main(int numberOfThrows) {
        throwDice(numberOfThrows); //Aufruf der übergebenen Würfe
    }
}

