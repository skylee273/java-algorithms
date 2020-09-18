import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon_2579 {

	static int n;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		dp = new int[n + 1];

		for (int i = 1; i <= n; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		System.out.print(minStep(n));

	}

	public static int minStep(int num) {
		if (num == 1) {
			return arr[1];
		}
		if (num == 2) {
			return arr[2] + arr[1];
		}

		dp[1] = arr[1];
		dp[2] = arr[2] + arr[1];

		for (int i = 3; i <= num; ++i) {
			dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
		}

		return dp[num];
	}

}
