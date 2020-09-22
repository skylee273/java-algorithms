import java.io.InputStreamReader;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;

public class BackJoon_10799 {

	static char OPEN_PARENTHESIS = '(';

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int ans = 0;
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			if(c == OPEN_PARENTHESIS) {
				st.push(c);
				continue;
			}
			else {
				if(st.isEmpty()) continue;
				st.pop();
				ans += str.charAt(i-1) == OPEN_PARENTHESIS ? st.size() : 1;
			}
		}
		System.out.print(ans);
	}

	

}
