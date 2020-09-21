import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BackJoon_10814 {

	static String SPACE = " ";
	static String NEW_LINE = "\n";

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Person[] person = new Person[n];

		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			person[i] = new Person(i,Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		br.close();
		Arrays.sort(person, Person.comparator);

		StringBuilder sb = new StringBuilder();
		for (Person p : person) {
			sb.append(p.age).append(SPACE).append(p.name).append(NEW_LINE);
		}
		System.out.print(sb.toString());
	}

	private static class Person {
		public int idx;
		public int age;
		public String name;

		private Person(int idx, int age, String name) {
			this.idx = idx;
			this.age = age;
			this.name = name;
		}

		private static Comparator<Person> comparator = new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				// TODO Auto-generated method stub
				if (p1.age > p2.age) {
					return 1;
				}else if(p1.age == p2.age) {
					if(p1.idx > p2.idx)
						return 1;
				}
				return -1;
			}
		};
	}

}
