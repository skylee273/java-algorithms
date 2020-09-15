import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_1463 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());

		int[] dp = new int[x+1];
		dp[1] = 0;
		for (int i = 2; i <= x; ++i) {
			dp[i] = dp[i-1] + 1;
			if(i % 3 == 0 && dp[i/3] < dp[i-1] + 1) {
				dp[i] = dp[i/3] + 1;
			}
			else if(i % 2 == 0 && dp[i/2] < dp[i-1] + 1) {
				dp[i] = dp[i/2] + 1;
			}
		}
		System.out.print(dp[x]);

	}



}
