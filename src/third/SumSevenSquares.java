package third;

import java.lang.Math;

public class SumSevenSquares {
    //Variablen deklarieren
    int n;
    int count;

    //SumSevenSquares Objekt Konstruktor
    public SumSevenSquares(int n){
        this.n = n;
    }

    //Methode zur Berechnung möglicher Lösungen für n
    public void berechne(){
        int r = (int)Math.floor(Math.sqrt(n));
        for(int s = -r; s <= r; s++){
            for(int t = -r; t <= r; t++){
                for(int u = -r; u <= r; u++){
                    for(int v = -r; v <= r; v++){
                        for(int w = -r; w <= r; w++){
                            for(int x = -r; x <= r; x++){
                                for(int y = -r; y <= r; y++){
                                    if(Math.pow(s,2) + Math.pow(t,2) + Math.pow(u,2) + Math.pow(v,2) + Math.pow(w,2) //Check, ob die Lösung gleich n ist.
                                            + Math.pow(x,2) + Math.pow(y,2) == n){
                                        count++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("\nEs gibt genau a(" + n + ")= " + count + " Moeglichkeiten, wenn n = " + n);    // Ausgabe Lösungen für n
    }
}
