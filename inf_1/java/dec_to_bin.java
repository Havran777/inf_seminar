import java.util.Scanner;

public class dec_to_bin {


//pouzitie pola s max 8 prvkami - 8 prvkov je pre max 8 binarnych miest (max. 11111111(bin) = 255(dec))
	public static void dec_to_bin_pole(int input) {
		
		int j = 1;
		int pole []= new int [8];
		int poloha = 7;
		for(int a = 8; a > 0 ; a--){
			j = input % 2;
			input = input / 2;
			pole[poloha - 1] = j;
			continue;
		}
		poloha = 0;
		for(int b = 8 ; b > 0; b--) {
			System.out.print(pole[poloha++]);
		}
		
	}

	// metoda nie je viazana na pocet binarnych miest 
	//pouzitie stringbuilderu - "menitelny string" - nie je fixny 
	//referencia [20.03.2025] https://www.geeksforgeeks.org/string-vs-stringbuilder-vs-stringbuffer-in-java/
	public static void dec_to_bin_universal(int input) {
		StringBuilder vysledok = new StringBuilder(); 
		int vstup = input;
		while (vstup > 0) {
			vysledok.append(vstup % 2);
			vstup = vstup / 2;
			}
	//.reverse() - prehodi na ruby string napr.: "ahoj" bude "joha"
		System.out.println(vysledok.reverse());
		
	}
	
	//scanner - vstup do konzoly - bere iba int
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int i = sc.nextInt();
		sc.close();
  //volanie metod na skusku
		//dec_to_bin_pole(i);
		dec_to_bin_universal(i);
	}

}
