import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_1158 {
	static String COMMA = ", ";
	static String OPEN = "<";
	static String CLOSE = ">";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i = 1; i <= n; ++i) {
			que.add(i);
		}
		
		long idx = 1;
		StringBuilder sb = new StringBuilder();
		sb.append(OPEN);
		while(!que.isEmpty()) {
			int val = que.poll();
			if(que.isEmpty())
				sb.append(val).append(CLOSE);
			else if(idx % k == 0)
				sb.append(val).append(COMMA);
			else
				que.add(val);
			++idx;
		}
		System.out.print(sb.toString());
	}

}
