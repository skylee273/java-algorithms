import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon_1212 {

	private static final String[] bin = { "000", "001", "010", "011", "100", "101", "110", "111" };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String num = br.readLine();

		StringBuilder sb = new StringBuilder();

		boolean isPre = true;
		for (char c : num.toCharArray()) {
			if (isPre) {
				sb.append(Integer.parseInt(bin[c - 48]));
				isPre = false;
				continue;
			}	
			sb.append(bin[c - 48]);
		}
		System.out.println(sb.toString());
	}

}
