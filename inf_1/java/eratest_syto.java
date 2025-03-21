
import java.util.Scanner;
import java.util.ArrayList;

/*eratestonovo syto: algoritmus kt. najde prvocisla tak, ze zacina od 2 a postupne skrta vsetky jeho nasobky, 
potom pokracuje s dalsim nevyskrtnutym cislo a robi to iste - na konci ostanu iba prvocisla*/

public class eratest_syto {
	public static void main(String[] args) {
		// Scanner - n je horna hranica intervalu
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

        //Mnozina cisel od 2 po n
	    //ArrayList - "menitelny" pole (array) - nema presnu a nemenitelnu velkost - je dynamicky
		//(21.03.2025) referencia: https://www.geeksforgeeks.org/array-vs-arraylist-in-java/
		ArrayList<Integer> mnozina = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			mnozina.add(i);
		}

		// urcenie prvocisla
		for (int i = 0; i < mnozina.size(); i++) {
			
			int prvocislo = mnozina.get(i);

			// odstranovanie nasobkov prvocisel okrem toho daneho prvocisla
			for (int j = i + 1; j < mnozina.size(); j++) {
				if (mnozina.get(j) % prvocislo == 0) {
					mnozina.remove(j);
					j--; // zmena indexu po odstranovani elementu z mnoziny
				}
			}
		}
		//vysledok - iba konkretne prvocisla od 2 po n kde n je hranica
		StringBuilder vysledok = new StringBuilder();
		for (int cisla : mnozina) {
			vysledok.append("" + cisla + " ");
		}
		System.out.print("Prvocisla od 2 po " + n + ": ");
		System.out.print(vysledok);

	}
}

