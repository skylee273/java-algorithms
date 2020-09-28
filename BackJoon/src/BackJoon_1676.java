import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon_1676 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.print(Math.min(getCount(n, 2), getCount(n, 5)));
	}

	private static int getCount(int n, int k) {
		int count = 0;
		while (n >= k) {
			count += n / k;
			n /= k;
		}
		return count;
	}

}
