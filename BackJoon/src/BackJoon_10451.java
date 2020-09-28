import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BackJoon_10451 {

	public static LinkedList<Integer>[] nodeList;
	private static String NEW_LINE = "\n";
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (testCase-- > 0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			nodeList = new LinkedList[n + 1];
			visited = new boolean[n + 1];
			
			for (int i = 0; i <= n; ++i) {
				nodeList[i] = new LinkedList<Integer>();
			}

			for (int i = 1; i <= n; ++i) {
				nodeList[i].add(Integer.parseInt(st.nextToken()));
			}

			for (int i = 1; i <= n; ++i)
				Collections.sort(nodeList[i]);

			int ans = 0;
			for (int i = 1; i <= n; ++i) {
				if (visited[i] == false) {
					dfs(i);
					ans++;
				}
			}
			sb.append(ans).append(NEW_LINE);
			
		}
		System.out.print(sb);
	}

	private static void dfs(int node) {
		if (visited[node]) return;
		visited[node] = true;

		for (int nextNode : nodeList[node]) {
			if (visited[nextNode]) continue;
			dfs(nextNode);
		}
	}

}
