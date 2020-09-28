import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon_2089 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.print(n == 0 ? 0 : getBin(n));
	}

	private static StringBuilder getBin(int n) {
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			sb.append(Math.abs(n % -2));
			n = (int) Math.ceil((double) n / (-2));
		}
		return sb.reverse();
	}
}
