import java.util.Scanner;

public class bin_to_dec {
	//funkcia na umocnovanie cisel 
	//da sa pouzit miesto toho  Math.pow(cislo, exponent) - pozor vracia naspat double 
	public static int power(int cislo, int exponent) {
		int vysledok = 1;
		for(int i = 0; i < exponent; i++) {
			vysledok = vysledok * cislo;
		}
		return vysledok;
	}

///univerzalna metoda na prevod cez for loop 
public static void bin_to_dec_universal (int bin) {
	int result = 0;
	for (int k = 0; k < (bin + "").length(); k++) {
		//Character.getNumericValue() - prevod char do int - to iste ako Integer.parseInt() 
		result = result + Character.getNumericValue((bin + "").charAt((bin + "").length() - k - 1)) * power(2, k);
	}
	System.out.println(result);
}
//najjednoduchsia metoda na prevod bin to dek 
public static void bin_to_dec_light_v (int bin) {
	String binString = bin + "";
	//.parseInt() - sa da pouzit aj na prevod ak sa pouzije druhy argument co je cielova sustava (napr.: binarna, hexadecimalna)
	System.out.println(Integer.parseInt(binString, 2));
}

//pouzitie pola na iteraciu prvkov v bin 
public static void bin_to_dec_pole (int bin) {
	String binString = bin + "";
	int res = 0;
	//.toCharArray() - vytvori pole na zaklade stringu - kazdy prvok pola je char v stringu
	char[] binArray = binString.toCharArray();
	for (int k = 0; k < binArray.length; k++) {
		res = res + Integer.parseInt(binArray[k] + "") * power(2, Integer.parseInt(binArray.length - k - 1 + ""));
	}
	System.out.println(res);
	
}

	public static void main(String[] args) {
		//scanner
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		sc.close(); 
		
	//volanie roznych metod
		//bin_to_dec_universal(input);
		//bin_to_dec_light_v(input);
		bin_to_dec_pole(input);
	

	}

}
