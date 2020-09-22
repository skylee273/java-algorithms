import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon_11655 {

	static final int ROT13 = 13;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] line = br.readLine().toCharArray();

		StringBuilder sb = new StringBuilder();
		for (char word : line) {
			if (word >= 'a' && word <= 'z') {
				int ctoi = word + ROT13;
				sb.append(ctoi <= 'z' ? (char) ctoi : (char) (ctoi - 26));
			} else if (word >= 'A' && word <= 'Z') {
				int ctoi = word + ROT13;
				sb.append(ctoi <= 'Z' ? (char) ctoi : (char) (ctoi - 26));
			} else {
				sb.append(word);
			}
		}
		System.out.print(sb.toString());
	}

}
