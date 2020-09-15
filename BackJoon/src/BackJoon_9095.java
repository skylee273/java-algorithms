import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_9095 {

	static String NEW_LINE = "\n";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int testCase = Integer.parseInt(st.nextToken());
		int[] dp = new int[12];
		
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int j = 3; j <= 11; ++j) {
			dp[j] = dp[j-1] + dp[j-2] + (dp[j-3]);
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < testCase; ++i) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			sb.append(dp[n]).append(NEW_LINE);
		}
		System.out.println(sb.toString());

	}

}
