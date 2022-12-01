package third;

import java.util.*;

public class DLXPentominoNUZ {
  static int cnt;
  static DLXNode h;
  int y;
  int n;
  int count = 0;
  ArrayList<Integer> xlist = new ArrayList<>();
  ArrayList<Integer[]> slist = new ArrayList<>();
  public DLXPentominoNUZ(int n){
    this.n = n;
    y = 5 * n;
    if(n > 5) {
      for (int i = 0; i < y; i++) {
        xlist.add(i);
      }
      for (int i = 0; i < 8; i++) {
        for (int j = 0; j < y; j++) {
          slist.add(allNPos(j));
          if (i < 4) {
            slist.add(allUPos(j));
            slist.add(allZPos(j));
          }
          count++;
        }
      }
    }
    slist.removeAll(Arrays.asList("", null));
    for (Integer i[] : slist) {
      System.out.println(Arrays.toString(i));
    }
    int s = slist.size();
    System.out.println(s);
  }

  public Integer[] allNPos(int x){
    Integer n[] = new Integer[5];
    if(count < y){
      if((this.n) - 1 == x || (this.n * 2) - 1 == x){
        return null;
      }
      else {
        n[0] = x;
        n[1] = x + this.n;
        n[2] = x + this.n + 1;
        n[3] = x + (this.n * 2) + 1;
        n[4] = x + (this.n * 3) + 1;
      }
    }
    else  if(count < y * 2){
      if(0 == x || (this.n) == x || (this.n * 2) == x){
        return null;
      }
      else {
        n[0] = x;
        n[1] = x + this.n;
        n[2] = x + this.n - 1;
        n[3] = x + (this.n * 2) - 1;
        n[4] = x + (this.n * 3) - 1;
      }
    }
    else  if(count < y * 3){
      if(x <= 1 || (this.n) - 1 == x || (this.n * 2) - 1 == x || (this.n * 3) - 1 == x || (this.n * 4) - 1 == x || (this.n) == x ||
              (this.n) + 1 == x || (this.n * 2) == x || (this.n * 2) + 1 == x || (this.n * 3) == x || (this.n * 3) + 1 == x){
        return null;
      }
      else {
        n[0] = x;
        n[1] = x + 1;
        n[2] = x + this.n - 2;
        n[3] = x + this.n - 1;
        n[4] = x + this.n;
      }
    }
    else  if(count < y * 4){
      if(x >= (this.n) - 3 && x <= (this.n) - 1 || x >= (this.n * 2) - 3 && x <= (this.n * 2) - 1 ||
              x >= (this.n * 3) - 3 && x <= (this.n * 3) - 1 || x >= (this.n * 4) - 3 && x <= (this.n * 4) - 1){
        return null;
      }
      else {
        n[0] = x;
        n[1] = x + 1;
        n[2] = x + 2;
        n[3] = x + this.n + 2;
        n[4] = x + this.n + 3;
      }
    }
    else  if(count < y * 5){
      if(x >= (this.n) - 3 && x <= (this.n) - 1 || x >= (this.n * 2) - 3 && x <= (this.n * 2) - 1 ||
              x >= (this.n * 3) - 3 && x <= (this.n * 3) - 1 || x >= (this.n * 4) - 3 && x <= (this.n * 4) - 1){
        return null;
      }
      else {
        n[0] = x;
        n[1] = x + 1;
        n[2] = x + this.n + 1;
        n[3] = x + this.n + 2;
        n[4] = x + this.n + 3;
      }
    }
    else  if(count < y * 6){
      if(x == 0 || x >= (this.n) - 2 && x <= (this.n) - 1 || x == (this.n) || x >= (this.n * 2) - 2 && x <= (this.n * 2) - 1 ||
              x == (this.n * 2) || x >= (this.n * 3) - 2 && x <= (this.n * 3) - 1 || x == (this.n * 3) || x >= (this.n * 4) - 2 && x <= (this.n * 4) - 1){
        return null;
      }
      else {
        n[0] = x;
        n[1] = x + 1;
        n[2] = x + 2;
        n[3] = x + this.n - 1;
        n[4] = x + this.n;
      }
    }
    else  if(count < y * 7){
      if(0 == x || (this.n) == x || (this.n * 2) == x){
        return null;
      }
      else {
        n[0] = x;
        n[1] = x + this.n;
        n[2] = x + (this.n * 2);
        n[3] = x + (this.n * 2) - 1;
        n[4] = x + (this.n * 3) - 1;
      }
    }
    else  if(count < y * 8){
      if((this.n) - 1 == x){
        return null;
      }
      else {
        n[0] = x;
        n[1] = x + this.n;
        n[2] = x + (this.n * 2);
        n[3] = x + (this.n * 2) + 1;
        n[4] = x + (this.n * 3) + 1;
      }
    }
    for(int i = 0; i < 5; i++){
      if(n[i] >= y) return null;
    }
    return n;
  }

  public Integer[] allUPos(int x){
    Integer u[] = new Integer[5];
    if(count < y){
      if((this.n) - 1 == x || (this.n * 2) - 1 == x || (this.n * 3) - 1 == x || (this.n * 4) - 1 == x ||
          (this.n) - 2 == x || (this.n * 2) - 2 == x || (this.n * 3) - 2 == x || (this.n * 4) - 2 == x ){
        return null;
      }
      else {
        u[0] = x;
        u[1] = x + this.n;
        u[2] = x + this.n + 1;
        u[3] = x + this.n + 2;
        u[4] = x + 2;
      }
    }
    else  if(count < y * 2){
      if(0 == x || (this.n) == x || (this.n * 2) == x){
        return null;
      }
      else {
        u[0] = x;
        u[1] = x - 1;
        u[2] = x + this.n - 1;
        u[3] = x + (this.n * 2) - 1;
        u[4] = x + (this.n * 2);
      }
    }
    else  if(count < y * 3){
      if((this.n) - 1 == x || (this.n * 2) - 1 == x || (this.n * 3) - 1 == x || (this.n * 4) - 1 == x ||
          (this.n) - 2 == x || (this.n * 2) - 2 == x || (this.n * 3) - 2 == x || (this.n * 4) - 2 == x ){
        return null;
      }
      else {
        u[0] = x;
        u[1] = x + 1;
        u[2] = x + 2;
        u[3] = x + this.n;
        u[4] = x + this.n + 2;
      }
    }
    else  if(count < y * 4){
      if((this.n) - 1 == x || (this.n * 2) - 1 == x || (this.n * 3) - 1 == x || (this.n * 4) - 1 == x){
        return null;
      }
      else {
        u[0] = x;
        u[1] = x + 1;
        u[2] = x + this.n + 1;
        u[3] = x + (this.n * 2) + 1;
        u[4] = x + (this.n * 2);
      }
    }
    for(int i = 0; i < 5; i++){
      if(u[i] >= y) return null;
    }
    return u;
  }

  public Integer[] allZPos(int x){
    Integer z[] = new Integer[5];
    if(count < y){
      if((this.n) - 1 == x || (this.n * 2) - 1 == x || (this.n * 3) - 1 == x || (this.n * 4) - 1 == x ||
              (this.n) - 2 == x || (this.n * 2) - 2 == x || (this.n * 3) - 2 == x || (this.n * 4) - 2 == x ){
        return null;
      }
      else {
        z[0] = x;
        z[1] = x + 1;
        z[2] = x + this.n + 1;
        z[3] = x + (this.n * 2) + 1;
        z[4] = x + (this.n * 2) + 2;
      }
    }
    else  if(count < y * 2){
      if(x <= 1 || (this.n) == x || (this.n * 2) == x || (this.n * 3) == x || (this.n * 4) == x ||
              (this.n) + 1 == x || (this.n * 2) + 1 == x || (this.n * 3) + 1 == x || (this.n * 4) + 1 == x){
        return null;
      }
      else {
        z[0] = x;
        z[1] = x + this.n;
        z[2] = x + this.n - 1;
        z[3] = x + this.n - 2;
        z[4] = x + (this.n * 2) - 2;
      }
    }
    else  if(count < y * 3){
      if(x <= 1 || (this.n) == x || (this.n * 2) == x || (this.n * 3) == x || (this.n * 4) == x ||
              (this.n) + 1 == x || (this.n * 2) + 1 == x || (this.n * 3) + 1 == x || (this.n * 4) + 1 == x){
        return null;
      }
      else {
        z[0] = x;
        z[1] = x - 1;
        z[2] = x + this.n - 1;
        z[3] = x + (this.n * 2) - 1;
        z[4] = x + (this.n * 2) - 2;
      }
    }
    else  if(count < y * 4){
      if((this.n) - 1 == x || (this.n * 2) - 1 == x || (this.n * 3) - 1 == x || (this.n * 4) - 1 == x ||
              (this.n) - 2 == x || (this.n * 2) - 2 == x || (this.n * 3) - 2 == x || (this.n * 4) - 2 == x ){
        return null;
      }
      else {
        z[0] = x;
        z[1] = x + this.n;
        z[2] = x + this.n + 1;
        z[3] = x + this.n + 2;
        z[4] = x + (this.n * 2) + 2;
      }
    }
    for(int i = 0; i < 5; i++){
      if(z[i] >= y) return null;
    }
    return z;
  }

  public static void main(String[] arg) {
    //Variablen deklarieren
    int n = 0;
    boolean tryok;
    Scanner sc = new Scanner(System.in);    //Scanner implementieren
    System.out.println("\nBitte Ganzzahl >= 0 eingeben!");
    do {
      try {
        n = sc.nextInt();   //Wert für n einlesen
        tryok = true;
      } catch (
          Exception e) {     // Falls keine ganze Zahl sondern etwas anderes eingegeben wird,
        tryok = false;            // soll die Exception abgefangen und eine erneute Eingabe gefordert werden.
        String s = sc.next();
        System.out.println("\nFehler!!! Bitte Ganzzahl >= 0 eingeben!");
      }
    } while (!tryok);
    new DLXPentominoNUZ(n);
  }

}
