import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_2193 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		System.out.print(dfs(n));
	}

	public static long dfs(int n) {
		long [] dp = new long[n+1];
		if(n == 1)
			return 1;
		if(n == 2)
			return 1;
		dp[1] = 1;
		dp[2] = 1;
		for(int i = 3; i <= n; ++i) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
}
