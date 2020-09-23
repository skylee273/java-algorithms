import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_1850 {

	static long x = 0;
	static long y = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		x = Long.parseLong(st.nextToken());
		y = Long.parseLong(st.nextToken());
		long gcd = getGcd(x, y);

		StringBuilder sb = new StringBuilder();
		while (gcd-- > 0) {
			sb.append(1);
		}
		System.out.print(sb.toString());
	}

	private static long getGcd(long x, long y) {

		if (y == 0)
			return x;
		return getGcd(y, x % y);
	}

}
