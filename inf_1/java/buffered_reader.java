import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class buffered_reader {

	public static void Reader_test() {
		//...new File([cesta k suboru - absolutna alebo relativna])
		//File file = new File("!! dopln cestu");
		File file = new File("src/vstup.txt");
		//Relativna cesta - napr. ak je v rovnakom adresari ako tento subor (subor)
		//File file = new File("src/vstup.txt");
		java.io.BufferedReader br = null; 
		try {
			//vytvorenie bufferedreaderu
			br = new BufferedReader(new FileReader(file));
			String str = null;
			//premenne na ratanie hlasok + viet 
			int samohlasky = 0;
			int spoluhlasky = 0;
			int interpunkt = 0;
			int vety = 0;
			//loop na na vypisovanie textu zo suboru - riadok po riadku 
			while ((str = br.readLine()) != null) {
				System.out.println(str);
				//loop na ratanie hlasok + poctu viet
				for (int k = 0; k < str.length(); k++) {
					switch(str.charAt(k)) {
					case 'A','a','I','i','o','O','e','E','u','U','Y','y':
						samohlasky++;
						break;
					case 'Q','q','w','W','r','R','t','T','z','Z','p','P','S','s','d','D','f','F','G','g','h','H','j','J','k','K','L','l','X','x','C','c','v','V','b','B','n','N','m','M':
						spoluhlasky++;
						break;
					case '"',':','-','—',';',',','’','\'','”','“':
						interpunkt++;
					    break;
					case '.','?','!':
						interpunkt++;
						vety++;
						break;
					default:
						break;
					}
				}
			}
			//sprava kt. vypise pocet hlasok + viet
			System.out.println("samohlasky: " + samohlasky + '\n' + "spoluhlasky: " + spoluhlasky + '\n' + "interpunkt: " + interpunkt + '\n' + "vety: " + vety);
			br.close();
			//vypise working directory - forma kontroly - ak sa pouziva relativna cesta
			//System.out.println("Working directory: " + System.getProperty("user.dir"));
		}
		catch(Exception er) {
			System.out.print(er);
		}
	}
	
	public static void main(String[]args) {
		Reader_test();
	}

}
