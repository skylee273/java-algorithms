import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_11721 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String str = st.nextToken();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); ++i) {
			sb.append(str.charAt(i));
			if((i+1) % 10 == 0)
				sb.append("\n");
		}
		System.out.print(sb);
		
	}

}
