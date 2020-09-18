import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon_2133 {

	static int n;
	static int [] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		
		if(n%2  == 0)
			System.out.print(cntTile());
		else
			System.out.print(0);
	}
	
	public static int cntTile() {
		if(n == 2)
			return 3;
		
		dp[0] = 1;
		dp[2] = 3;
		for(int i = 4; i <= n; i+=2) {
			for(int j = 2; j <= i; j+=2) {
				int stand = j == 2 ? 3 : 2;
				dp[i] += stand * dp[i-j];
			}
		}
		return dp[n];
	}

}
