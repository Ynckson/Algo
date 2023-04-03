package third;

import java.util.Scanner;

public class SumSevenSquaresMain {

    public static void main(String[] Args){
        //Variablen deklarieren
        int n = 0;
        boolean tryok = true;
        Scanner sc = new Scanner(System.in);    //Scanner implementieren
        System.out.println("\nBitte Ganzzahl fuer n eingeben!");
        do {
            try {
                n = sc.nextInt();   //Wert für n einlesen
                tryok = true;
            } catch (Exception e) {     // Falls keine ganze Zahl, sondern etwas anderes eingegeben wird,
                tryok = false;            // soll die Exception abgefangen und eine erneute Eingabe gefordert werden.
                String s = sc.next();
                System.out.println("\nFehler!!! Bitte Ganzzahl fuer n eingeben!");
            }
        }while(!tryok);
        SumSevenSquares s = new SumSevenSquares(n);     // Erstellung eines SumSevenSquares Objekt, welches den Wert n mitbekommt
        s.berechne();    //Methode zur Berechnung der Möglichkeiten von n
    }
}
