import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BackJoon_10825 {

	static String SPACE = " ";
	static String NEW_LINE = "\n";

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Student[] stu = new Student[n];
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			int lan = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			stu[i] = new Student(name, lan, eng, math);
		}
		br.close();
		Arrays.sort(stu, Student.comparator);

		StringBuilder sb = new StringBuilder();
		for (Student s : stu) {
			sb.append(s.name).append(NEW_LINE);
		}
		System.out.print(sb.toString());
	}

	private static class Student {
		public String name;
		public int lanScore;
		public int engScore;
		public int mathScore;

		private Student(String name, int s1, int s2, int s3) {
			this.name = name;
			this.lanScore = s1;
			this.engScore = s2;
			this.mathScore = s3;
		}

		private static Comparator<Student> comparator = new Comparator<Student>() {

			@Override
			public int compare(Student s1, Student s2) {
				// TODO Auto-generated method stub
				if (s1.lanScore < s2.lanScore)
					return 1;
				else if(s1.lanScore == s2.lanScore) {
					if(s1.engScore > s2.engScore) 
						return 1;
					else if(s1.engScore == s2.engScore) {
						if (s1.mathScore < s2.mathScore)
							return 1;
						else if(s1.mathScore == s2.mathScore) {
							return s1.name.compareTo(s2.name);
						}
					}
				}
				return -1;
			}

		};
	}
}
