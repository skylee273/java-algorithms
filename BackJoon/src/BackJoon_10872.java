import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon_10872 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long [] dp = new long[13];
		
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 1; i <= 12; ++i) {
			dp[i] = dp[i-1] * i;
		}
			
		System.out.print(dp[n]);
		
	}
}
