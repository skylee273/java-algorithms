import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BackJoon_1991 {

	private static Map<String, List<String>> map = new HashMap<>();
	private static StringBuilder sb;
	private static String NEW_LINE = "\n";
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		while(n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<String> list = new ArrayList<String>();
			String root = st.nextToken();
			list.add(st.nextToken());
			list.add(st.nextToken());
			map.put(root, list);
		}
		sb = new StringBuilder();
		preorder("A"); sb.append(NEW_LINE);
		inorder("A"); sb.append(NEW_LINE);
		postorder("A"); sb.append(NEW_LINE);
		System.out.print(sb);
	}
	private static void preorder(String v) {
		if(v.equals(".")) return;
		sb.append(v);
		preorder(map.get(v).get(0));
		preorder(map.get(v).get(1));
	}
	private static void inorder(String v) {
		if(v.equals(".")) return;
		
		inorder(map.get(v).get(0));
		sb.append(v);
		inorder(map.get(v).get(1));
	}
	private static void postorder(String v) {
		if(v.equals(".")) return;
		
		postorder(map.get(v).get(0));
		postorder(map.get(v).get(1));
		sb.append(v);
	}
}
