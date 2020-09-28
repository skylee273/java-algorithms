import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon_11653 {

	static String NEW_LINE = "\n";

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (n != 1) {
			int div = 2;
			while (n % div != 0) div++;
			n /= div;
			sb.append(div).append(NEW_LINE);
		}
		System.out.print(sb);
	}
}
