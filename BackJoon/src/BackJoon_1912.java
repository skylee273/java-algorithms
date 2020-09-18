import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BackJoon_1912 {

	static int n;
	static long[] arr;
	static long[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new long[n+1];
		dp = new long[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//Arrays.fill(dp, -1001);
		long max = -1001;
		for(int i = 1; i <= n; ++i) {
			dp[i] = arr[i];
			dp[i] = Math.max(dp[i], dp[i-1] + arr[i]);
			max = Math.max(dp[i], max);
		}
		System.out.print(max);
	}
}
