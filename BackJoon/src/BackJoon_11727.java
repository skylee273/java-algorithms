import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_11727 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int [] dp = new int[n+1];
		
		dp[0] = 1;
		dp[1] = 1;

		for(int i = 2; i <= n; ++i) {
			dp[i] = (2 * dp[i-2]  + dp[i-1]  ) % 10007  ;
		}
		
		System.out.print(dp[n]);
	}

}
