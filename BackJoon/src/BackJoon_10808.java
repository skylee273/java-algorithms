import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BackJoon_10808 {

	static String SPACE = " ";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char [] alpha = br.readLine().toCharArray();
		int [] histo = new int[26];
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < alpha.length; ++i) {
			histo[(alpha[i] - 'a')]++;	
		}
		
		for(int i = 0; i < 26; ++i) {
			sb.append(histo[i]).append(SPACE);
		}
		System.out.print(sb);
	}

}
