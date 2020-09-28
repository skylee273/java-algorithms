import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BackJoon_1929 {

	static String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		boolean[] prime = new boolean[n + 1];

		Arrays.fill(prime, true);

		for (int i = 2; i <= n; ++i)
			for (int j = 2; i * j <= n; ++j)
				prime[i * j] = false;

		for (int i = m; i <= n; ++i) {
			if (i == 1) continue;
			if (prime[i])
				sb.append(i).append(NEW_LINE);
		}
		System.out.print(sb);	

	}

}
