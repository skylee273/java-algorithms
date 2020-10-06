import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BackJoon_1967 {

	private static List<Node>[] list;
	private static boolean[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		list = new LinkedList[n+1];
		visit = new boolean[n+1];
		for (int i = 1; i <= n; ++i)
			list[i] = new LinkedList<Node>();

		for (int i = 1; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[parent].add(new Node(child, weight));
			list[child].add(new Node(parent, weight));
		}
		
		Arrays.fill(visit, false);
		Node maxNode = dfs(new Node(1, 0));
		Arrays.fill(visit, false);
		Node max = dfs(new Node(maxNode.v, 0));
		System.out.print(max.w);
	}
	
	private static Node dfs(Node curNode) {
		visit[curNode.v] = true;
		Node res = new Node(curNode.v, curNode.w);
		
		for (Node nextNode : list[curNode.v]) {
			if (visit[nextNode.v]) continue;
				Node tmp = dfs(new Node(nextNode.v, nextNode.w + curNode.w));
				if(res.w < tmp.w) res = tmp;
		}
		return res;
	}

	private static class Node {
		public int v;
		public int w;

		private Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

	}

}
