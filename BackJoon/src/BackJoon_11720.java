import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_11720 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int testCase = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		int sum = 0;
		for(int i = 0; i < testCase; ++i) {
			sum += Integer.parseInt(String.valueOf(str.charAt(i)));
		}
		System.out.print(sum);
		
	}

}
