package third;

import java.util.*;

public class DLXPentominoNUZ {
  int y = 0;
  int n;
  int count = 0;
  ArrayList<Integer> xlist = new ArrayList<Integer>();
  ArrayList<Integer[]> slist = new ArrayList<Integer[]>();
  public DLXPentominoNUZ(int n){
    this.n = n;
    y = 5 * n;
    for(int i = 0; i < y; i++){
      xlist.add(i);
    }
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < y; j++) {
        slist.add(allNPos(j));
        slist.add(allUPos(j));
        slist.add(allZPos(j));
        count++;
      }
    }
    for (Integer i[] : slist) {
      System.out.println(Arrays.toString(i));
    }
  }

  public Integer[] allNPos(int x){
    Integer n[] = new Integer[5];
    if(count < y){
      n[0] = x;
      n[1] = x + this.n;
      n[2] = x + this.n + 1;
      n[3] = x + (this.n * 2) + 1;
      n[4] = x + (this.n * 3) + 1;
    }
    else  if(count < y * 2){
      n[0] = x + 1;
      n[1] = x + this.n;
      n[2] = x + this.n + 1;
      n[3] = x + (this.n * 2);
      n[4] = x + (this.n * 3);
    }
    else  if(count < y * 3){
      n[0] = x + 2;
      n[1] = x + 3;
      n[2] = x + this.n;
      n[3] = x + this.n + 1;
      n[4] = x + this.n + 2;
    }
    else  if(count < y * 4){
      n[0] = x;
      n[1] = x + 1;
      n[2] = x + 2;
      n[3] = x + this.n + 2;
      n[4] = x + this.n + 3;
    }
    else  if(count < y * 5){
      n[0] = x;
      n[1] = x + 1;
      n[2] = x + this.n + 1;
      n[3] = x + this.n + 2;
      n[4] = x + this.n + 3;
    }
    else  if(count < y * 6){
      if(count < 1) {
        n[0] = x + 1;
        n[1] = x + 2;
        n[2] = x + 3;
        n[3] = x + this.n;
        n[4] = x + this.n + 1;
      }
    }
    else  if(count < y * 7){

    }
    else  if(count < y * 8){

    }


      return n;
  }

  public Integer[] allUPos(int x){
    Integer u[] = new Integer[5];
    return u;
  }

  public Integer[] allZPos(int x){
    Integer z[] = new Integer[5];
    return z;
  }

  public static void main(String[] arg) {
    //Variablen deklarieren
    int n = 0;
    boolean tryok = true;
    Scanner sc = new Scanner(System.in);    //Scanner implementieren
    System.out.println("\nBitte Ganzzahl größer gleich 0 für n eingeben!");
    do {
      try {
        n = sc.nextInt();   //Wert für n einlesen
        tryok = true;
      } catch (
          Exception e) {     // Falls keine ganze Zahl sondern etwas anderes eingegeben wird,
        tryok = false;            // soll die Exception abgefangen und eine erneute Eingabe gefordert werden.
        String s = sc.next();
        System.out.println("\nFehler!!! Bitte Ganzzahl größer gleich 0 für n eingeben!");
      }
    } while (!tryok);
    new DLXPentominoNUZ(n);
  }

}
