import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_10430 {

	static String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();

		sb.append((A + B) % C).append(NEW_LINE).append(((A % C) + (B % C)) % C).append(NEW_LINE).append((A * B) % C)
				.append(NEW_LINE).append(((A % C) * (B % C)) % C);

		System.out.print(sb.toString());
	}

}
