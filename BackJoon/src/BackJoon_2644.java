import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BackJoon_2644 {

	private static LinkedList<Integer>[] nodeList;
	private static boolean[] visit;
	private static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());

		nodeList = new LinkedList[n + 1];
		visit = new boolean[n + 1];
		for (int i = 1; i <= n; ++i) {
			nodeList[i] = new LinkedList<Integer>();
		}
		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			nodeList[node1].add(node2);
			nodeList[node2].add(node1);
		}
		dfs(start, end, 0);
		ans = ans == 0 ? -1 : ans;
		System.out.print(ans);

	}

	private static void dfs(int v, int e, int cnt) {
		if (v == e) {
			ans = cnt;
			return;
		}
		visit[v] = true;

		for (int nextNode : nodeList[v]) {
			if(visit[nextNode]) continue;
			dfs(nextNode, e, cnt + 1);
		}
		
	}
}
