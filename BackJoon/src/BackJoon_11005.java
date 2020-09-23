import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_11005 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		int div;
		while (n > 0) {
			div = n % x;
			sb.append(div >= 10 ? (char) (div - 10 + 'A') : (char) (div + '0'));
			n /= x;
		}
		System.out.print(sb.reverse());
	}

}
