package third;

import java.util.Scanner;

class PermTwoUpDown extends Thread{
    private int[] a; // a Arbeitsarray
    private int max; // maximaler Index
    private boolean mayread = false; // Kontrolle
    private int cnt = 0;  // Counter
    PermTwoUpDown(int n){ // Konstruktor
        a = new int[n]; // Indices: 0 .. n-1
        max = n-1; // Maximaler Index
        for (int i=0; i<=max;i++) a[i]=i+1; // a fuellen
        this.start (); // run-Methode beginnt zu laufen
    } // end Konstruktor
    public void run (){// die Arbeits-Methode
        perm (0); // permutiere ab 0
        a = null; // Anzeige, dass fertig
        put (); // ausliefern
    } // end run

    private void perm (int i){ // permutiere ab Index i
        if (i >= max) put (); // eine Permutation fertig
        else {
            for (int j=i; j <= max; j++){ // jedes nach Vorne
                swap (i,j); // vertauschen
                perm (i+1); // und Rekursion
            }
            int h = a[i]; // restauriere Array
            System.arraycopy (a,i+1,a,i,max-i); // shift links
            a[max] = h;
        }
    } // end perm
    private void swap (int i, int j){ // tausche a[i] <-> a[j]
        if (i != j)
        { int h = a[i]; a[i] = a[j]; a[j] = h; }
    } // end swap

    synchronized int[] getNext (){ // liefert naechste Permutation
        mayread = false; // a darf geaendert werden
        notify (); // wecke anderen Thread
        try{ while (!mayread) wait (); // non busy waiting
        } catch (InterruptedException e){}
        return a; // liefere Permutationsarray
    } // end getNext
    private synchronized void put (){ // uebergebe array
        mayread = true; // a wird gelesen
        notify (); // wecke anderen Thread
        try{ if (a!=null)
            while (mayread) wait (); // non busy waiting
        } catch (InterruptedException e){}
    } // end put

    public boolean checkPerm(int[] a){ // checkt ob Permutation passend zur Bedingung
        boolean bigger;         //wenn true vergleich ob nächste Zahl größer, bei false ob kleiner
        for(int i = 0; i < a.length-2; i++){
            bigger = i % 4 < 2;    //Jedes zweite mal ändern ob größer oder kleiner
            if(bigger){             //Checkt ob Bedingung erfüllt falls nicht return false
                if(a[i] > a[i+2]) return false;
            } else
                if(a[i] < a[i+2]) return false;
        }
        return true; //Bedingung erfüllt return true
    } // end checkPerm

    public static void main(String[] arg) {
        //Variablen deklarieren
        int n = 0;
        boolean tryok;
        Scanner sc = new Scanner(System.in);    //Scanner implementieren
        System.out.println("\nBitte Ganzzahl für n eingeben!");
        do {
            try {
                n = sc.nextInt();   //Wert fÃ¼r n einlesen
                tryok = true;
            } catch (
                    Exception e) {     // Falls keine ganze Zahl sondern etwas anderes eingegeben wird,
                tryok = false;            // soll die Exception abgefangen und eine erneute Eingabe gefordert werden.
                System.out.println("\nFehler!!! Bitte Ganzzahl für n eingeben!");
            }
        } while (!tryok);
        PermTwoUpDown p = new PermTwoUpDown(n); // Liefert Permutationen von 0 .. N-1 mit 0 fix
        while ((p.a = p.getNext()) != null) { // Naechste Permutation
            boolean checked = p.checkPerm(p.a);  // Checken ob Permutation Bedingung erfüllt
            if (checked) {
                for (int i = 0; i < p.a.length; i++) {   // Ausgabe der Permutation
                    System.out.print(" " + p.a[i]);
                }
                System.out.print("\n");
                p.cnt++;   // Counter erhöhen
            }
        }
        System.out.println("Es gab genau " + p.cnt + " Permutationen in {1,...," + n + "} die der Bedingung gehorchten.");
    }// end Main
} // end Perm


