import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BackJoon_2606 {

	private static String SPACE = " ";
	private static LinkedList<Integer> [] list;
	private static boolean [] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		list = new LinkedList[n+1];
		visit = new boolean[n+1];
		for(int i = 1; i <= n; i++ ) {
			list[i] = new LinkedList<Integer>();
		}
		while(k-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			list[node1].add(node2);
			list[node2].add(node1);
		}
		
		dfs(1);
		int ans = 0;
		for(int i = 1; i <= n; ++i) {
			if(visit[i]) ans++; 
		}
		System.out.print(ans-1);
	}
	
	private static void dfs(int node) {
		
		visit[node] = true;
		
		for(int nextNode : list[node]) {
			if(visit[nextNode]) continue;
			dfs(nextNode);
		}
	}

}
