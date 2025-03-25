import java.util.Scanner;

public class cezar_sifra {
	/*
	 * Cezarova sifra - posuvanie kazdeho pismena v texte o urcite miesto v abecede, napr.: a -> c; b -> d (posunutie od 2 miesta dopredu)
	 * algoritmus je dost zjednoduseni lebo posuva kazdy charakter o 2 miesta okrem whitespacu 
	 * (25.03.2025) Viac na https://en.wikipedia.org/wiki/Caesar_cipher
	 */
	
	//sifrovanie -> posuvanie o 2 miesta dopredu v abecede
	//pouzitie stringbuilderu ako vstupneho parametru metody
	public static String cypher(StringBuilder in) {
		char whitespace = ' ';
		for (int k = 0; k < in.length(); k++) {
			
			if (in.charAt(k) != whitespace) {
				//premena povodneho char na k-tej pozicii na int  
				int original = (int) in.charAt(k);
				//definovanie noveho charu ktory je posunuty o 2 pozicie 
				char New = (char) (original + 2);
				//.setCharAt() -> urci aky charakter bude na danej pozicii
				in.setCharAt(k, New);
			}
		}
		//pozor: metoda vracia string nie stringbuilder preto treba premena na string
		//da sa pouzit aj .toString() 
		return in + "";
	}

	//desifrovanie -> posuvanie o 2 miesta dozadu v abecede -> tym padom vie desifrovat text zasifrovany hornym algoritmom
	//kod je takmer zhodny az na urcovanie noveho charakteru - posunutie o 2 pozicie dozadu
	public static String decypher(StringBuilder in) {
		char whitespace = ' ';
		for (int k = 0; k < in.length(); k++) {
			if (in.charAt(k) != whitespace) {
				int original = (int) in.charAt(k);
				char New = (char) (original - 2);
				in.setCharAt(k, New);
			}
		}
		return in + "";
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		scanner.close();

		StringBuilder test = new StringBuilder(input);
		
		//volanie skusobnych metod
		System.out.println(decypher(test));
		// System.out.println(cypher(test));

	}

}
