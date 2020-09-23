import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_2609 {

	static String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int gcd = getGcd(x, y);
		int lcd = (x * y) / gcd;

		sb.append(gcd).append(NEW_LINE).append(lcd);
		System.out.print(sb.toString());

	}

	private static int getGcd(int x, int y) {
		if (y == 0)
			return x;
		return getGcd(y, x % y);
	}

}
