import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_1389 {

	private static LinkedList<Integer>[] list;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		list = new LinkedList[n + 1];
		for(int i = 1; i <= n; ++i) {
			list[i] = new LinkedList<Integer>();
		}
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			list[node1].add(node2);
			list[node2].add(node1);
		}
		
		bfs(n);
		
	}
	
	
	private static void bfs(int n) {
		int minIdx = 1;
		int min = Integer.MAX_VALUE;
		
		for(int i = 1; i <= n; ++i) {
			int sum = 0;
			int [] isVisited = new int[n+1];
			isVisited[i] = 1;
			Queue<Integer> que = new LinkedList<Integer>();
			que.offer(i);
			
			while(!que.isEmpty()) {
				int curNode = que.poll();
				for(final int nextNode : list[curNode]) {
					if(isVisited[nextNode] != 0) continue;
					sum += isVisited[nextNode] = isVisited[curNode] + 1;
					que.offer(nextNode);
				}
			}
			
			if(min > sum) {
				min = sum;
				minIdx = i;
			}
		}
		System.out.print(minIdx);
	}

}
