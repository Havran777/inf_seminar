import java.util.Scanner;

public class hex_to_dek {
	//pomocna metoda na pocitanie jedneho kroku vypoctu v prevodu dec to hex - cinitel * konkretne 16^exponent * cinitel (napr.: 65 = 5 * 16 ^ 0 + 6 * 16 ^ 1)
	//jeden scitanec (napr.: 5 * 16 ^ 0) je vlastne jeden krok
	public static int hex_dec_partial(int exponent, int multiplier) {
		return multiplier * (int) Math.pow(16, exponent);
	}
	
	//hlavna metoda na prevod 
	public static void hex_to_dec_universal(String input) {
		String in = input;
		int result = 0;
		//ak je posledny charakter input male 'h' - oznacenie hex. cisla - odstrani ho
		if (input.charAt(input.length() - 1) == 'h') {
			//String.substring(n, m) - od n-pozicie v stringu (vratane) do m-tej (m-ta nie je zahrnuta) - vyberie urcitu cast stringu
			in = input.substring(0, input.length() - 1);
		//ak su prve dva charaktery '0x' alebo '0X' - tiez mozne oznacenie hex. cilsa - odstrani ho
		} else if ((input.charAt(0) == '0' && input.charAt(1) == 'x') || (input.charAt(0) == '0' && input.charAt(1) == 'X')) {
			in = input.substring(2, input.length());
		}	
		for (int k = 0; k < in.length(); k++) {
			//Character.isDigit() je check ci je charakter na danej pozicii cislo
			if (Character.isDigit(in.charAt(k))) {
				result += hex_dec_partial(k, Integer.parseInt(in.charAt(k) + ""));
			} else {
				//switch stamement - zjednodusene if-elseif-else statementy
				//(28.03.2025) Ref.: https://www.geeksforgeeks.org/switch-statement-in-java/
				// zmysel - ak su hodnoty A, B, C, D, E, F na pozicii v inpute, priradia sa im hodnoty a vypocita sa medzivysledok (ten jeden scitanie) 
				switch (in.charAt(k)) {
				//!! pri case keyworde nesmu byt premenne (variable) - iba primitivne datatypy s urcitiou hodnotou
				case 'A', 'a':
					result += hex_dec_partial(k, 10);
					break;
				case 'B', 'b':
					result += hex_dec_partial(k, 11);
					break;
				case 'C', 'c':
					result += hex_dec_partial(k, 12);
					break;
				case 'D', 'd':
					result += hex_dec_partial(k, 13);
					break;
				case 'E', 'e':
					result += hex_dec_partial(k, 14);
					break;
				case 'F', 'f':
					result += hex_dec_partial(k, 15);
					break;
					//bezi ak sa nezhodne nic s casom (nieco ako else pri podmienkach)
				default:
					//vytvori exception - program vyhodi chybu z dovodu neplatneho argumentu
					//neplatny argurment je vlastne urceny kodom 
					throw new IllegalArgumentException("neplatný vstup pre: " + in.charAt(k));
				}

			}
		}
		System.out.println(result);

	}

	public static void main(String[] args) {
		//Scanner
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		sc.close();
		
		//test volania metody
		hex_to_dec_universal(input);
	}
}
