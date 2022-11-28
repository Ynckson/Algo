package third;

/**
 * @author Yannick Huber 208827
 */

import java.util.*;

public class PermParity extends Thread {
	// gerade nur größer ungerade nur kleiner als vorgänger
	int[] a; // a Arbeitsarray
	int[][] ges;
	int max; // maximaler Index
	boolean mayread = false; // Kontrolle

	PermParity(int n) { // Konstruktor
		a = new int[n]; // Indices: 0 .. n-1
		max = n - 1; // Maximaler Index
		for (int i = 0; i <= max; i++) a[i] = i + 1; // a fuellen
		perm(n, a);
	} // end Konstruktor

	public void perm(int n, int[] x) {
		if(n == 1) {
			if(x[0] % 2 == 0 && x[1] > x[0]){
				arrStr(x);
			}
			else{
				arrStr(x);
			}
		} else {
			for(int i = 0; i < n-1; i++) {
				perm(n - 1, x);
				if(n % 2 == 0) {
					swap(x, i, n-1);
				} else {
					swap(x, 0, n-1);
				}
			}
			perm(n - 1, x);
		}
	}

//	private void perm (){ // permutiere ab Index i
//		for (int i=0; i <= max; i++){
//			for (int j=0; j <= max; j++){
//				arrStr(a);
//			}
//		}
//	} // end perm
	private void swap(int[] x, int a, int b) {
		int tmp = x[a];
		x[a] = x[b];
		x[b] = tmp;
	}
	public void arrStr(int[] x) {
		System.out.print("\n[");
		for (int i = 0; i <= x.length - 1; i++) {
			if (i == x.length - 1) System.out.print(x[i]);
			else System.out.print(x[i] + ",");
		}
		System.out.print("]");
	}

	public static void main(String[] arg) {
		//Variablen deklarieren
		int n = 0;
		boolean tryok = true;
		Scanner sc = new Scanner(System.in);    //Scanner implementieren
		System.out.println("\nBitte Ganzzahl für n eingeben!");
		do {
			try {
				n = sc.nextInt();   //Wert fÃ¼r n einlesen
				tryok = true;
			} catch (
					Exception e) {     // Falls keine ganze Zahl sondern etwas anderes eingegeben wird,
				tryok =
						false;            // soll die Exception abgefangen und eine erneute Eingabe gefordert werden.
				String s = sc.next();
				System.out.println("\nFehler!!! Bitte Ganzzahl für n eingeben!");
			}
		} while (!tryok);
		new PermParity(n);
	}
}

