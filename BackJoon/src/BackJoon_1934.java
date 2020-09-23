import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_1934 {

	static String NEW_LINE = "\n";

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int lcd = getGcd(x, y) * (x * y);
			sb.append(lcd).append(NEW_LINE);
		}
		System.out.print(sb.toString());
	}

	private static int getGcd(int x, int y) {

		if (y == 0) {
			return x;
		}
		return getGcd(y, x % y);
	}

}
