import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_9465 {

	static int test_case, n;
	static int[][] arr;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n + 1][2];
			dp = new int[n + 1][3];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					arr[j][i] = Integer.parseInt(st.nextToken());
				}
			}

			
			dp[1][0] = 0;
			dp[1][1] = arr[1][0];
			dp[1][2] = arr[1][1];

			for (int i = 2; i <= n; i++) {
				dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
				dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + arr[i][0];
				dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + arr[i][1];

			}
			int ans = Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2]));
			System.out.println(ans);
		}

	}

}
