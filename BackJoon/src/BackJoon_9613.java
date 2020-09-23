import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_9613 {

	static String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int testCase = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		while (testCase-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] nums = new int[n];

			long sum = 0;
			for (int i = 0; i < n; ++i)
				nums[i] = Integer.parseInt(st.nextToken());

			for (int i = 0; i < n; ++i)
				for (int j = i + 1; j < n; ++j)
					sum += getGcd(nums[i], nums[j]);

			sb.append(sum).append(NEW_LINE);
		}
		System.out.print(sb.toString());
	}

	private static int getGcd(int x, int y) {
		if (y == 0)
			return x;
		return getGcd(y, x % y);
	}

}
