package third;

/**
 * @author Yannick Huber 208827
 */

import java.util.*;

public class ZpathsMain {

  public static void main(String[] Args){
    //Variablen deklarieren
    int n = 0;
    boolean tryok = true;
    Scanner sc = new Scanner(System.in);    //Scanner implementieren
    System.out.println("\nBitte Ganzzahl für n eingeben!");
    do {
      try {
        n = sc.nextInt();   //Wert für n einlesen
        tryok = true;
      } catch (Exception e) {     // Falls keine ganze Zahl sondern etwas anderes eingegeben wird,
        tryok = false;            // soll die Exception abgefangen und eine erneute Eingabe gefordert werden.
        String s = sc.next();
        System.out.println("\nFehler!!! Bitte Ganzzahl für n eingeben!");
      }
    }while(!tryok);
    Zpaths p = new Zpaths(n);     // Erstellung eines Zpaths Objekt, welches den Wert n mitbekommt
    p.berechneA();    //Methode zur Berechnung von a(n)
  }
}
