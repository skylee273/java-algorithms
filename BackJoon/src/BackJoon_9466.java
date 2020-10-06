import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BackJoon_9466 {

	private static int [] project;
	private static boolean [] visited;
	private static boolean [] cycle;
	private static int DIV = 1000000;
	private static int cnt;
	private static String NEW_LINE = "\n";
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(testCase-- > 0) {
			
			int n = Integer.parseInt(br.readLine());
			
			project = new int[n+1];
			visited = new boolean[n+1];
			cycle = new boolean[n+1];
			cnt = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 1; i <= n; ++i) project[i] = Integer.parseInt(st.nextToken());
			
			for(int i = 1; i <= n; ++i)	{
				if(cycle[i]) continue; 
				dfs(i);
			}
			sb.append((n - cnt) % DIV).append(NEW_LINE);
		}
		System.out.print(sb);
	}
	private static void dfs(int v) {
		if(visited[v]) {
			cycle[v] = true;
			cnt++;
		}else {
			visited[v] = true;
		}
		
		if(!cycle[project[v]]) dfs(project[v]);
		visited[v] = false; cycle[v] = true;
	}

}
