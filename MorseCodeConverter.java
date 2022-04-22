import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

public class MorseCodeConverter {

	static MorseCodeTree  m = new MorseCodeTree();

	public MorseCodeConverter() {

	}

	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		
		Scanner scanner = new Scanner(codeFile);
		String f = "";
		
		while(scanner.hasNextLine()) {
			f += scanner.nextLine();
		}
		
		scanner.close();
		return convertToEnglish(f.trim());

	}

	public static String convertToEnglish(String code) {
		String[] l;
		String[] w =  code.split("/");
		String s = "";

		for(String b: w) {
			l = b.split(" ");
			for(String c: l) {
				s += m.fetch(c);
			}
			s += " ";
		}
		return s.trim();
	}

	public static String printTree() {
		ArrayList<String> a = m.toArrayList();
		String s = "";
		for(String v: a) {
			s+= v += " ";
		}
		return	s.trim();
	}
}
