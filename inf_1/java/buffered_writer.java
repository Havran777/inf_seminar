import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class buffered_writer {

	public static void main(String[] args) {
		try {
			//file z do ktoreho sa uloží vstup, je treba mat dostatocne povolenia na pristup k folderu kde sa subor bude nachadzat		
			//preto je to aj cele v try-catch code 
			File file = new File("src/vstup");
			//bufferedwriter object
			BufferedWriter wr = new BufferedWriter(new FileWriter(file));
			//.append() prida na zaciatok subor string
			wr.append("ahoj\n");
			wr.append("cau cau");
			//ako scanner, je treba ho zavriet
			wr.close();
		}
		catch (Exception er) {
			//vypise chybu ak nej dojde
			er.printStackTrace();
		}
		
	}
}
