import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BackJoon_11725 {

	private static LinkedList<Integer>[] list;
	private static int[] parent;
	private static boolean[] visited;
	private static String NEW_LINE = "\n";

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		list = new LinkedList[n + 1];
		parent = new int[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= n; ++i)
			list[i] = new LinkedList<Integer>();

		for (int i = 0; i < n - 1; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			list[node1].add(node2);
			list[node2].add(node1);
		}
		StringBuilder sb = new StringBuilder();
		dfs(1);
		for (int i = 2; i <= n; ++i)
			sb.append(parent[i]).append(NEW_LINE);
		System.out.print(sb);
	}

	private static void dfs(int v) {
		visited[v] = true;

		for (int nextNode : list[v]) {
			if (visited[nextNode])
				continue;
			parent[nextNode] = v;
			dfs(nextNode);
		}
	}

}
