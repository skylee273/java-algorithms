import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon_9461 {

	static int testCase;
	static long[] dp;
	static String NEW_LINE = "\n";
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCase = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(testCase-- > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append(maxTriangle(n) + NEW_LINE);
		}
		System.out.print(sb);
		
	}
	public static long maxTriangle(int n) {
		dp = new long[n+1];
		if(n <= 3)
			return 1;
		dp[1] = dp[2] = dp[3] = 1;
		
		for(int i = 4; i <=n; ++i) {
			dp[i] = dp[i-3] + dp[i-2];
		}
		return dp[n];
	}

}
