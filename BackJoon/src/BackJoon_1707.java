import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BackJoon_1707 {

	private static LinkedList<Integer>[] nodeList;
	private static int[] color;
	private static String NEW_LINE = "\n";
	private static String Y = "YES";
	private static String N = "NO";

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (k-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			nodeList = new LinkedList[v + 1];
			for (int i = 0; i <= v; ++i) {
				nodeList[i] = new LinkedList<Integer>();
			}

			while (e-- > 0) {
				st = new StringTokenizer(br.readLine());
				int node1 = Integer.parseInt(st.nextToken());
				int node2 = Integer.parseInt(st.nextToken());
				nodeList[node1].add(node2);
				nodeList[node2].add(node1);
			}
			for (int i = 0; i <= v; ++i)
				Collections.sort(nodeList[i]);

			color = new int[v + 1];

			int ans = 0;
			for (int i = 1; i <= v; ++i) {
				if (color[i] == 0) {
					dfs(i, i % 2 != 0 ? 1 : -1);
					ans++;
				}
			}
			boolean ok = true;
			for (int i = 1; i <= v; ++i) {
				for (int nextNode : nodeList[i]) {
					if (color[i] == color[nextNode]) {
						ok = false;
						break;
					}
				}
			}
			if (ok)
				sb.append(Y).append(NEW_LINE);
			else
				sb.append(N).append(NEW_LINE);
		}
		System.out.print(sb);
	}

	private static void dfs(int node, int paint) {
		if (color[node] != 0)
			return;
		color[node] = paint;

		for (int nextNde : nodeList[node]) {
			if (color[nextNde] != 0)
				continue;
			dfs(nextNde, paint == 1 ? -1 : 1);
		}
	}
}
