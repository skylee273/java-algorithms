import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    private static int DIV = 100;
	private static int MILLION = 10000;
	private static String NEW_LINE = "\n";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int cost, goods, profit, fees, defect;
		Question question = new Question();
		while(true) {
			question.printTotalQuestion();
			int page = sc.nextInt();
			if(page == 1) {
				question.printProfitOne();
				cost = sc.nextInt(); goods = sc.nextInt(); profit = sc.nextInt(); fees = sc.nextInt();
				Profit p = new Profit(cost, goods, profit, fees);
				p.printSum();
			}
			if(page == 2) {
				question.printProfitTwo();
				cost = sc.nextInt(); goods = sc.nextInt(); profit = sc.nextInt();
				Profit p = new Profit(cost, goods, profit);
				p.printSum2();
			}
			if(page == 3) {
				question.printProfitThree();
				cost = sc.nextInt(); goods = sc.nextInt(); profit = sc.nextInt(); fees = sc.nextInt();
				defect = sc.nextInt();
				Profit p = new Profit(cost, goods, profit, fees, defect);
				p.printProfit();
			}
			if(page == 4) {
				question.printMax();
				int bundleCnt, bundlePrice, piecePrice, maxPrice;
				bundleCnt = sc.nextInt(); bundlePrice = sc.nextInt(); piecePrice = sc.nextInt();
				maxPrice = sc.nextInt();
				Max max = new Max(bundleCnt, bundlePrice, piecePrice, maxPrice);
				max.printGetMax();
			}
			if(page == 5) {
				question.printData();
				int data; double percentage;
				data = sc.nextInt(); percentage = sc.nextDouble();
				Data d = new Data(data, percentage);
				d.printCount();
			}
			if(page == 6) {
				question.printDataTwo();
				int data, data2;
				double percentage, percentage2;
				data = sc.nextInt();  percentage = sc.nextDouble(); data2 = sc.nextInt(); percentage2 = sc.nextDouble();
				Data d = new Data(data, percentage, data2, percentage2);
				d.printMulti();
			}
			if(page == 7) {
				question.printDataThree();
				int data, data2;
				double percentage, percentage2;
				data = sc.nextInt();  percentage = sc.nextDouble(); data2 = sc.nextInt(); percentage2 = sc.nextDouble();
				Data d = new Data(data, percentage, data2, percentage2);
				d.printCompare();
			}
			if(page == 8) {
				question.printDataFour();
				int data, data2, totalData, totalCompareData;
				totalData = sc.nextInt();  data = sc.nextInt(); totalCompareData = sc.nextInt(); data2 = sc.nextInt();
				Data d = new Data(totalData, data, totalCompareData, data2);
				d.printPercentage();
			}
			if(page == 9) {
				question.printDataFive();
				int n = sc.nextInt();
				double [] arr = new double[n];
				for(int i = 0; i < n; ++i) {
					question.printDataFive_One();
					int total = sc.nextInt(); int data = sc.nextInt();
					arr[i] = 100 * data / total;
				}
				Data data = new Data(arr);
				data.printAllPercent();
			}
			if(page == 10) {
				question.printDataFive();
				int n = sc.nextInt();
				double [] arr = new double[n];
				for(int i = 0; i < n; ++i) {
					question.printDataFive_One();
					double total = sc.nextDouble(); double data = sc.nextDouble();
					arr[i] = 100.0 * data / total;
				}
				Data data = new Data(arr);
				data.printAllPercent2();
			}
			if(page == 11) {
				question.printDataSix();
				int data, nextData, compareData, compareNextData;
				data = sc.nextInt(); nextData = sc.nextInt(); compareData = sc.nextInt(); compareNextData = sc.nextInt();
				Data d = new Data(data, nextData, compareData, compareNextData);
				d.printIncrease();
			}
			if(page == 12) {
				question.printDataSeven();
				int w, h, wh, len;
				w = sc.nextInt(); h = sc.nextInt(); wh = sc.nextInt(); len = sc.nextInt();
				Rectangle rectangle = new Rectangle(w, h, wh, len);
				rectangle.printMaxCount();
			}
			
			if(page == -1) {
				break;
			}
		}
		
	
	}

	private static class Question{
		public void printTotalQuestion() {
			StringBuilder sb = new StringBuilder();
			
			sb.append("1.이윤의 총합 구하기 ( 원가, 개수, 이윤, 수수료 )").append(NEW_LINE);
			sb.append("2.이윤의 총합 구하기 ( 원가, 개수, 이윤 )").append(NEW_LINE);
			sb.append("3.하자발생시 이윤 구하기").append(NEW_LINE);
			sb.append("4.최대 가능한 개수  구하기").append(NEW_LINE);
			sb.append("5.비율 * 자료 구하기 ").append(NEW_LINE);
			sb.append("6.두 자료 비교 하기 (몇배 이상) ").append(NEW_LINE);
			sb.append("7.두 자료 비교하기 (무엇 이 더 많은지 )").append(NEW_LINE);
			sb.append("8.두 데이터 비율 구하기 ").append(NEW_LINE);
			sb.append("9.전체 데이터 비율 보기").append(NEW_LINE);
			sb.append("10.전체 데이터 비율 (소수점 첫째 자리 반올림) ").append(NEW_LINE);
			sb.append("11.증가율 비교하기").append(NEW_LINE);
			sb.append("12.직사각형 채우기 문제 ").append(NEW_LINE);
			sb.append("-1.종료").append(NEW_LINE);
			
			System.out.print(sb);
		}
		public void printProfitOne() {
			System.out.println("원가, 상품개수, 이윤, 수수료 입력");
		}
		public void printProfitTwo() {
			System.out.println("원가, 상품개수, 이윤");
		}
		public void printProfitThree() {
			System.out.println("원가, 상품개수, 이윤, 수수료, 불량제품 수 ");
		}
		public void printMax() {
			System.out.println("묶음 개수, 묶음 금액, 낱개 금액, 최대 사용 가능 금액 ");
		}
		public void printData() {
			System.out.println("데이터 개수, 비율 입력");
		}
		public void printDataTwo() {
			System.out.println("데이터 개수, 비율, 비교 데이터 개수, 비교 비율 입력 ");
		}
		public void printDataThree() {
			System.out.println("데이터 개수, 비율, 비교 데이터 개수, 비교 비율 입력 ");
		}
		public void printDataFour() {
			System.out.println("전체 데이터, 부분 데이터, 비교 전체 데이터, 비교 부분 데이터 ");
		}
		public void printDataFive() {
			System.out.println("비교하고자 하는 대상의 수 입력");
		}
		public void printDataFive_One() {
			System.out.println("전체 데이터, 부분 데이터  ");
		}
		public void printDataSix() {
			System.out.println("전년도  개수, 현 년도 개수, 비교 데이터 전년도 개수, 비교 데이터 현 년도 개수 ");
		}
		public void printDataSeven() {
			System.out.println("직사각형 가로, 직사각형 세로, 정사각형 길이, 간격 길이");
		}
		
	}
	private static class MathLCD{
		int workTime, workCnt;
		private MathLCD(int workTime, int workCnt, int breakTime) {
			this.workTime = workTime + breakTime;
			this.workCnt = workCnt;
		}
	}
	private static class Math{
		 MathLCD [] arr;
		
		private int gcd() {
			int result;
			if(arr.length <= 1) return arr[0].workTime;
			result = gcd(arr[0].workTime, arr[1].workTime);
			for(int i = 2; i < arr.length; ++i) {
				result = gcd(result, arr[i].workTime);
			}
			return result;
		}
		
		private int gcd(int A, int B) {
			if(B == 0) return A;
			return gcd(B, A%B);
		}
		private int lcd() {
			int gcd = gcd();
			int lcm = gcd;
			for(int i = 0; i < arr.length; ++i) {
				arr[i].workTime /= gcd;
				lcm *= arr[i].workTime;
			}
			return lcm;
		}
		
	}
	
	private static class Rectangle{
		int w,h, wh, len;
		
		public Rectangle(int w, int h, int wh, int len) {
			this.w = w;
			this.h = h;
			this.wh = wh;
			this.len = len;
		}
		
		public int getMaxCount() {
			return (w * h) / ((wh + len) * (wh + len));
		}
		
		public void printMaxCount() {
			System.out.println("최대 개수는 = " + getMaxCount());
		}
	}
	
	private static class Data{
		double [] percentageArr;
		int totalData, totalCompareData;
		int data, data2;

		double percentage, percentage2;
		
		public Data(double[] percentageArr) {
			this.percentageArr = percentageArr;
		}
		
		public Data(int data, double percentage) {
			this.data = data;
			this.percentage = percentage;
		}
		
		public Data(int data, double percentage, int data2, double percentage2) {
			this.data = data;
			this.percentage = percentage;
			this.data2 = data2;
			this.percentage2 = percentage2;
		}
		public Data(int totalData, int data, int totalCompareData, int data2) {
			this.totalData = totalData;
			this.data = data;
			this.totalCompareData = totalCompareData;
			this.data2 = data2;
		}
		
		private String getPercentage() {
			percentage = 100 * data / totalData;
			percentage2 =100 *  data2 / totalCompareData;
			return "첫번째 데이터 비율 = " + percentage  + "%," + "두번째 데이터 비율 = " + percentage2 + "%입니다.";
		}
		
		private String getIncrease() {
			double increase = ((double)(data - totalData) / (double) totalData) * 100.0;
			double compareIncrease = ((double)(data2 - totalCompareData) / (double)totalCompareData) * 100.0;
			DecimalFormat decimalFormat = new DecimalFormat("##0.0");
			return "첫번째 데이터 증가율 = " + decimalFormat.format(increase) + "%," + "두번째 데이터 증가율 = " + decimalFormat.format(compareIncrease) + "%입니다.";
		}
		private double getDataOne() {
			return data * ( percentage / DIV);
		}
		private double getDataTwo() {
			return data2 * ( percentage2 / DIV);
		}
		private double getMulti() {
			return getDataOne() / getDataTwo();
		}
		private double getCount() {
			return data * ( percentage / DIV);
		}
		
		private int datCompare() {
			if(getDataOne() > getDataTwo()) return 1;
			else if(getDataOne() < getDataTwo()) return -1;
			return 0;
		}
		private void printCompare() {
			switch (datCompare()) {
			case 1: {
				System.out.println("첫 번째 데이터가 크다.");
				break;
			}
			case 0: {
				System.out.println("같다");
				break;
			}
			case -1: {
				System.out.println("두 번째 데이터가 크다.");
				break;
			}
			}
		}
		private void printMulti() {
			System.out.println(String.format("첫 번째 자료 값은 = %f, 두번째 자료값은 =%f \n"
					+ "첫번째 자료는 두번째 자료에 %f배이다.",getDataOne(), getDataTwo(), getMulti()));
		}
		private void printCount() {
			System.out.println("조건에 만족하는 개수는 = " + getCount());
		}
		private void printPercentage() {
			System.out.println(getPercentage());
		}
		private void printAllPercent2() {
			StringBuilder sb = new StringBuilder();
			DecimalFormat decimalFormat = new DecimalFormat("##0.0");
			for(int i = 0; i < percentageArr.length; ++i) {
				sb.append(decimalFormat.format(percentageArr[i])).append(NEW_LINE);
			}
			System.out.print(sb);
		}
		private void printAllPercent() {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < percentageArr.length; ++i) {
				sb.append(percentageArr[i]).append(NEW_LINE);
			}
			System.out.print(sb);
		}
		private void printIncrease() {
			System.out.println(getIncrease());
		}
	}
	private static class Max{
		int bundleCnt, bundlePrice, piecePrice, maxPrice;
		private Max(int bundleCnt, int bundlePrice, int piecePrice, int maxPrice) {
			this.bundleCnt = bundleCnt;
			this.bundlePrice = bundlePrice;
			this.piecePrice = piecePrice;
			this.maxPrice = maxPrice;
		}
		
		private int getPossibleBundleCnt() {
			return maxPrice / bundlePrice;
		}
		private int getPossiblePieceCnt() {
			return (maxPrice - getPossibleBundleCnt() * bundlePrice) / piecePrice;
		}
		private int getMaxCnt() {
			return getPossiblePieceCnt() + getPossibleBundleCnt() * bundleCnt;
		}
		public void printGetMax() {
			System.out.println("가능한 최대 구매 개수 = " + String.format("%d", getMaxCnt()));
		}
	}
	
	private static class Profit{
		private int  goods, defect;
		private double profit, fees, cost;
		
		public Profit(double cost, int goods, double profit, double fees) {
			this.cost = cost; this.goods = goods; this.profit = profit; this.fees = fees;
		}
		public Profit(double cost, int goods, double profit, double fees, int defect) {
			this.cost = cost; this.goods = goods; this.profit = profit; this.fees = fees; this.defect = defect;
		}
		public Profit(double cost, int goods, double profit) {
			this.cost = cost; this.goods = goods; this.profit = profit;
		}
		private double getSum() {
			return ((cost * goods) * (1 + profit / DIV));
		}
		private double sumIncome() {
			return ((cost * goods) * (1 + profit / DIV) * (1 - fees / DIV));	
		}
		private double getProfit() {
			return (DIV * (sumIncome() / (1 - fees / DIV) / (cost * (goods- defect)) - 1 ));
		}
		
		public void printSum2() {
			System.out.println("총 수익금 = " + String.format("%.2f", getSum()));
		}
		public void printSum() {
			System.out.println("총 수익금 = " + String.format("%.2f", sumIncome()));
		}
		public void printProfit() {
			System.out.println("이윤 = " + String.format("%.2f", getProfit()));
		}
		
	}
	
}