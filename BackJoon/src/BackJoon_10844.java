import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_10844 {

	static long DIV = 1000000000;
	static int NUMS = 10;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		long[][] dp = new long[n + 1][NUMS];

		for (int i = 1; i < NUMS; ++i) {
			dp[1][i] = 1;
		}
		System.out.print(dp[1][0]);
		for (int i = 2; i <= n; ++i) {
			for (int j = 0; j < NUMS; ++j) {
				long sum = 0;
				if (j + 1 <= 9) {
					sum += dp[i-1][j+1];
				}
				
				if (j - 1 >= 0) {
					sum += dp[i-1][j-1];
				}
				dp[i][j] = sum % DIV;
			}
		}

		long sum = 0;
		for (int i = 0; i < NUMS; ++i) {
			sum += dp[n][i];
		}
		System.out.print(sum % DIV);
	}
}
