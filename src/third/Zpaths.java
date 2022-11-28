package third;

/**
 * @author Yannick Huber 208827
 */

import java.math.BigInteger;
import java.util.*;

public class Zpaths {
  //Variablen deklarieren
  int n;
  BigInteger a = new BigInteger("0");
  int z = 0;
  int[] x = new int[500];
  int[] y = new int[500];

  //Zpaths Objekt Konstruktor
  public Zpaths(int n){
    this.n = n;
  }

  //Methode zur Berechnung möglicher Lösungen von n
  public void berechneLoesungenN(){
    for(int i = 0; i <= n/2; i++){
      for(int j = 0; j <= i; j++){
        if(i * 2 + j == n){
          x[z] = i;
          y[z] = j;
          z++;
        }
      }
    }
  }

  //Methode zur Berechnung von a(n)
  public void berechneA(){
    berechneLoesungenN();       // Ausführen der Methode zur Berechnung der möglichen Lösungen von n
    int maxx = Arrays.stream(x).max().getAsInt();
    int maxy = Arrays.stream(y).max().getAsInt();   //Maximum Werte der x und y Arrays
    BigInteger[][] k = new BigInteger[maxx + 1][maxx + 1];
    for(int y = 0; y <= maxy; y++){                 //Berechnung aller Pfade zum Punkt k[y][x]
      for(int x = y; x <= maxx; x++){
        k[y][x] = new BigInteger("0");
        if(y == 0){
          k[y][x] = k[y][x].add(BigInteger.ONE);
        }
        else {
          if (x == y) {
            k[y][x] = k[y - 1][x];
          }
          else{
            k[y][x] = k[y][x - 1].add(k[y - 1][x]);
          }
        }
      }
    }
    if(n == 1) a.add(BigInteger.ZERO);
    else{
      for(int i = 0; i < z; i++){           //Berechnung der Summe aller möglichen Pfade für alle möglichen Lösungen von n
        a = a.add(k[y[i]][x[i]]);
      }
    }
    System.out.println("\nLösung für a(" + n + "): " + a);    // Ausgabe Lösung von a(n)
  }
}
