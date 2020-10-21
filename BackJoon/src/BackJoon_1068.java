import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BackJoon_1068 {

	private static LinkedList<Integer>[] list;
	private static boolean [] visited;
	private static final int ROOT = -1;
	private static int answer = 0;
	private static int deleteNode;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		list = new LinkedList[n];
		visited = new boolean[n];
		for(int i = 0; i < n; ++i) {
			list[i] = new LinkedList<Integer>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int root = 0;
		
		for(int i = 0; i < n; ++i) {
			int parent = Integer.parseInt(st.nextToken());
			if(parent == ROOT) root = i; 
			else {
				list[parent].add(i);
				list[i].add(parent);
			}
		}
		deleteNode = Integer.parseInt(br.readLine());
		if(deleteNode == root) System.out.print(0);
		else {
			remove(root);
			System.out.print(answer);
		}
		
		
	}
	private static void remove(int v) {
		visited[v] = true;
		int cnt = 0;
		for(int i = 0; i < list[v].size(); ++i) {
			int nextNode = list[v].get(i);
			if(!visited[nextNode] && nextNode != deleteNode) {
				cnt++;
				remove(nextNode);
			}
		}
		if(cnt == 0) answer++;
	}
}
