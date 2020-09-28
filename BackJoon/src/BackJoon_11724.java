import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_11724 {

	private static boolean[] visited;
	private static LinkedList<Integer>[] nodeList;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		nodeList = new LinkedList[n+1];
		visited = new boolean[n+1];
		for(int i = 0; i <= n; ++i)
			nodeList[i] = new LinkedList<Integer>();
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			nodeList[node1].add(node2);
			nodeList[node2].add(node1);
		}
		for(int i = 0; i <= n; ++i)
			Collections.sort(nodeList[i]);
		
		int ans = 0;
		for(int i = 1; i<=n; ++i) {
			if(!visited[i]) {
				dfs(i);
				ans++;
			}
		}
		System.out.print(ans);
	}
	
	
	private static void dfs(int node) {
		if(visited[node]) return;
		visited[node] = true;
		
		for(int nextNode : nodeList[node]) {
			if(visited[nextNode]) continue;
			dfs(nextNode);
		}
	}

}
