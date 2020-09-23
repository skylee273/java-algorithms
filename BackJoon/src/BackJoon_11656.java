import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BackJoon_11656 {

	static String NEW_LINE = "\n";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		
		Suffix [] suffix = new Suffix[word.length()];
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < word.length(); ++i) {
			suffix[i] = new Suffix(word.substring(i, word.length()));
			
		}
		Arrays.sort(suffix, Suffix.comparator);
		
		for(Suffix su : suffix) {
			sb.append(su.word).append(NEW_LINE);
		}
		System.out.print(sb.toString());
	}
	
	private static class Suffix{
		public String word;
		
		private Suffix(String word) {
			this.word = word;
		}
		
		private static Comparator<Suffix> comparator = new Comparator<Suffix>() {

			@Override
			public int compare(Suffix s1, Suffix s2) {
				// TODO Auto-generated method stub
				return s1.word.compareTo(s2.word);
			}
			
		};
	}

}
