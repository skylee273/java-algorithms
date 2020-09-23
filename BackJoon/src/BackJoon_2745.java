import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_2745 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		int b = Integer.parseInt(st.nextToken());

		int ans = 0;
		for (int i = 0; i < str.length(); ++i) {
			char c = str.charAt(str.length()-i-1);
			c += c > '9' ? 10 - 'A' : 0-'0'; 
			ans += (c * Math.pow(b, i));
		}
		System.out.print(ans);
	}

}
