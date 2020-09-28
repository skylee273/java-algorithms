import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_2331 {

	private static LinkedList<Integer> nodeList;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		nodeList = new LinkedList<Integer>();
		visited = new boolean[10_000_001];
		System.out.println(nodeList.indexOf(dfs(A, P)));

	}

	private static int dfs(int node, int P) {
		if (visited[node])
			return node;
		nodeList.add(node);
		visited[node] = true;

		int nextNode = 0;
		while (node != 0) {
			nextNode += (int) Math.pow(node % 10, (double) P);
			node /= 10;
		}
		return dfs(nextNode, P);
	}

}
