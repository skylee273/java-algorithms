import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_1168 {
	static String COMMA = ", ";
	static String OPEN = "<";
	static String CLOSE = ">";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken()) - 1;

		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		sb.append(OPEN);
		while(!list.isEmpty()) {
			idx += k;
			if(idx >= list.size())
				idx %= list.size();
			sb.append(list.remove(idx)).append(COMMA);
		}
		System.out.print(sb.substring(0, sb.length()-2) + CLOSE);
	}

}
