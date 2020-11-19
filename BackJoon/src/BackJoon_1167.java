import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class BackJoon_1167 {

	private static List<Node>[] list;
	private static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int v = Integer.parseInt(br.readLine());

		list = new ArrayList[v + 1];
		visit = new boolean[v+1];
		
		for (int i = 1; i <= v; ++i)
			list[i] = new ArrayList<Node>();

		for (int i = 1; i <= v; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2;
			while ((node2 = Integer.parseInt(st.nextToken())) != -1) {
				int distance = Integer.parseInt(st.nextToken());
				list[node1].add(new Node(node2, distance));
			}
		}
		
		Arrays.fill(visit, false);
		Node maxNode = dfs(1,0);
		Arrays.fill(visit, false);
		Node max = dfs(maxNode.edge,0);
		System.out.print(max.dist);
		
	}

	private static Node dfs(int v, int dist) {
		visit[v] = true;
		Node res = new Node(v, dist);
		for (Node nextNode : list[v]) {
			if(visit[nextNode.edge]) continue;
			Node tmp = dfs(nextNode.edge, nextNode.dist + dist);
			if(res.dist < tmp.dist) res = tmp;
		}
		return res;
	}

	private static class Node {
		public int edge;
		public int dist;

		private Node(int edge, int dist) {
			this.edge = edge;
			this.dist = dist;
		}
	}

}
