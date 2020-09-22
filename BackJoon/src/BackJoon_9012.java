import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BackJoon_9012 {

	static String OK = "YES";
	static String NOT = "NO";
	static String NEW_LINE = "\n";
	static char OPEN = '(';

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (n-- > 0) {
			sb.append(isVps(br.readLine().toCharArray()) ? OK : NOT).append(NEW_LINE);
		}
		System.out.print(sb.toString());
	}

	private static boolean isVps(char[] vps) {
		int cnt = 0;
		for (int i = 0; i < vps.length; ++i) {
			if (cnt < 0)
				return false;
			cnt += vps[i] == OPEN ? 1: -1;
		}
		return cnt == 0;

	}

}
