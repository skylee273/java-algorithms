import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_1260 {

	public static LinkedList<Integer>[] nodeList;
	private static boolean[] visited;
	private static StringBuilder sb;
	private static String SPACE = " ";
	private static String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		nodeList = new LinkedList[n + 1];

		for (int i = 0; i <= n; ++i) {
			nodeList[i] = new LinkedList<Integer>();
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			nodeList[node1].add(node2);
			nodeList[node2].add(node1);

		}

		for (int i = 0; i <= n; ++i) {
			Collections.sort(nodeList[i]);
		}

		sb = new StringBuilder();
		visited = new boolean[n + 1];
		dfs(v);

		sb.append(NEW_LINE);

		visited = new boolean[n + 1];
		bfs(v);

		System.out.print(sb);
	}

	private static void dfs(int node) {
		if (visited[node])
			return;
		visited[node] = true;
		sb.append(node).append(SPACE);

		for (int nextNode : nodeList[node]) {
			if (visited[nextNode])
				continue;
			dfs(nextNode);
		}
	}

	private static void bfs(int node) {
		Queue<Integer> que = new LinkedList<Integer>();

		que.offer(node);

		while (!que.isEmpty()) {
			node = que.poll();
			if (visited[node])
				continue;
			visited[node] = true;

			sb.append(node).append(SPACE);
			for (int nextNode : nodeList[node]) {
				if (visited[nextNode])
					continue;
				que.add(nextNode);
			}
		}
	}

}
