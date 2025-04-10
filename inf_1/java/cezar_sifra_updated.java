import java.util.Scanner;

public class cezar_sifra_updated {
	
	// A -> C, ... , Y -> A, Z -> B 
	//podobny subor ako cezar_sifra ale berie do uvahy zmenu 'y' na 'a' a 'z' a 'b' (upper + lowercase)
	public static String cypher(StringBuilder in) {
		for (int k = 0; k < in.length(); k++) {			
			switch(in.charAt(k)) {
			case 'z':
				in.setCharAt(k, 'b');	
				break;
			case 'Z':
				in.setCharAt(k, 'B');	
				break;	
			case 'y':
				in.setCharAt(k, 'a');	
				break;	
			case 'Y':
				in.setCharAt(k, 'A');	
				break;	
			case ' ':
				break;
			default:
				int original = (int) in.charAt(k);
				
				char New = (char) (original + 2);
			
				in.setCharAt(k, New);
			}
			
		
		}
		
		return in + "";
	}
	public static String decypher(StringBuilder in) {
		for (int k = 0; k < in.length(); k++) {			
			switch(in.charAt(k)) {
			case 'b':
				in.setCharAt(k, 'z');	
				break;
			case 'B':
				in.setCharAt(k, 'Z');	
				break;	
			case 'a':
				in.setCharAt(k, 'y');	
				break;	
			case 'A':
				in.setCharAt(k, 'y');	
				break;	
			case ' ':
				break;
			default:
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
		//System.out.println(decypher(test));
		System.out.println(cypher(test));
	}
}
