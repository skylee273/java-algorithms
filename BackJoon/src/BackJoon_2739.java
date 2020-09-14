import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_2739 {

	static String NEW_LINE = "\n";
	static String MULTI = " * ";
	static String EQUL = " = ";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int result = 1;
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= 9; ++i) {
			result = n * i;
			sb.append(n + MULTI +  i + EQUL + result + NEW_LINE);
		}
		System.out.print(sb);
	}

}
