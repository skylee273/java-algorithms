import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BackJoon_6588 {

	static String EQUL = " = ";
	static String PLUS = " + ";
	static String NEW_LINE = "\n";
	static String ERROR = "Goldbach's conjecture is wrong.";

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = 0;
		StringBuilder sb = new StringBuilder();

		boolean[] prime = new boolean[1000001];

		Arrays.fill(prime, true);

		for (int i = 2; i <= 1000000; ++i)
			for (int j = 2; i * j <= 1000000; ++j)
				prime[i * j] = false;

		while ((n = Integer.parseInt(br.readLine())) != 0) {
			int idx = 3;
			while (true) {
				if ((n - idx) < 0) {
					sb.append(ERROR).append(NEW_LINE);
					break;
				}
				if (prime[idx] && prime[n - idx]) {
					sb.append(n).append(EQUL).append(idx).append(PLUS).append(n - idx).append(NEW_LINE);
					break;
				}
				idx++;
			}
		}
		System.out.print(sb);
	}
}
