package third;

/**
 * @author Yannick Huber 208827
 */

import java.util.ArrayList;
import java.util.Arrays;

class Perm extends Thread {
  // a Arbeitsarray
  private int[] a;
  // maximaler Index
  private final int max;
  // Kontrolle
  private boolean mayRead = false;

  // perm()-Zähler
  private int permc = 0;
  private int counter = 0;
  private int total = 0;
  private ArrayList<Integer> permutationCalls = new ArrayList<>();

  /*
  Konstruktor
  */

  Perm(int n) {
    // Indices: 0 .. n-1
    a = new int[n];
    // Maximaler Index
    max = n - 1;
    // a füllen
    for (int i = 0; i <= max; ) {
      a[i] = i++;
    }
    // run-Methode beginnt zu laufen
    this.start();
  }

  /*
  Arbeitsmethode
  */

  public void run() {
    // a[0] bleibt fest; permutiere ab 1
    // call perm()
    // SET TO 1 FOR TSP, SET TO 0 FOR ALL PERMUTATIONS
    perm(0);
    counter++;
    total++;
    // Anzeige, dass fertig
    a = null;
    // ausliefern
    put();
    System.out.println("Aufrufe für Permutation:" + counter);
    permutationCalls.add(counter);
    counter = 0;
  }
  // ...

  /*
  Perm
  */

  private void perm(int i) {
    // permutiere ab Index i
    permc++;
    if (i >= max) {
      // eine Permutation fertig
      put();
      permutationCalls.add(counter);
      System.out.println("Aufrufe für Permutation:" + counter);
      counter = 0;
    } else {
      // jedes nach Vorne
      for (int j = i; j <= max; j++) {
        swap(i, j);
        perm(i + 1);
        // call perm()
        counter++;
        total++;
      }
      int h = a[i];
      // shift links
      System.arraycopy(a, i + 1, a, i, max - i);
      a[max] = h;
    }
  }

  private void swap(int i, int j) {
    if (i != j) {
      // tausche a[i] <-> a[j]
      int h = a[i];
      a[i] = a[j];
      a[j] = h;
    }
  }

  synchronized int[] getNext() {
    // liefert naechste Permutation,
    // a darf geändert werden
    mayRead = false;
    // wecke anderen Thread
    notify();
    try {
      while (!mayRead) {
        // non-busy waiting
        wait();
      }
    } catch (InterruptedException ignored) {
    }
    // liefere Permutations-Array
    return a;
  }

  private synchronized void put() {
    // übergebe Array,
    // a wird gelesen,
    mayRead = true;
    // wecke anderen Thread
    notify();
    try {
      if (a != null) {
        while (mayRead) {
          // non-busy waiting
          wait();
        }
      }
    } catch (InterruptedException ignored) {
    }
  }

  /*
  Generiere Matrix for n Zahlen
   */
  private static int[][] erzeugeMatrix(int n) {
    int[][] mat = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        mat[i][j] = i == j ? 0 : (int) (Math.random() * 100 + 1);
      }
    }
    return mat;
  }

  /*
  Main
   */

  public static void main(String[] arg) {
    System.out.println("TSP");
    // Matrix der Kosten
    int[][] mat = Perm.erzeugeMatrix(9);
    int[][] mat2 = {
        {0, 2, 2, 5, 4},
        {3, 0, 5, 2, 2},
        {6, 7, 0, 1, 6},
        {3, 2, 7, 0, 3},
        {5, 4, 3, 8, 0}
    };
    // Zahl der Städte
    int N = mat.length;
    // Liefert Permutationen von 0 ... N-1 mit 0 fix
    Perm p = new Perm(N);
    int cost = Integer.MAX_VALUE;
    int[] c, best = {};
    // Naechste Permutation
    while ((c = p.getNext()) != null) {
      int actcost = 0;
      for (int j = 0; j < N; j++) {
        actcost += mat[c[j]][c[(j + 1) % N]];
      }
      System.out.println(Arrays.toString(c) + " --> " + actcost);
      if (actcost < cost) {
        cost = actcost;
        best = c.clone();
      }
    }
    System.out.println("Die geringsten Kosten " + cost +
        " verursacht " + Arrays.toString(best));
    System.out.println("Die Methode perm() wurde insgesamt " + p.total + " mal aufgerufen.");
    System.out.println("Es entfielen durchschnittlich " +
        ((double) p.total)/getFactorial(N));
    System.out.println("Aufrufe für Permutation Ynck:" + p.permc);
  }
  public static int getFactorial(int f) {
    int result = 1;
    for (int i = 1; i <= f; i++) {
      result = result * i; // Ermitteln der Fakultät mit Schleifen
    }
    return result;
  }
}

