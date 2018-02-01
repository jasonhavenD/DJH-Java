import java.util.Scanner;

/*
 * ��������N(N>1)���������ĸ����� ��ͬ����������Ҫ�ظ����㡣��120=2*2*2*3*5������5���������� 
 * */
public class 质因数的个数 {
	public static void main(String[] args) {
		// ����һ
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			long n = in.nextInt();
			int count = 0;
			int factor = 2;
			while (factor <= n) {
				if (n % factor == 0) {
					count++;
					n /= factor;
				} else {
					factor++;
				}
			}
			System.out.println(count);
		}
		
		// ������
		// Scanner in = new Scanner(System.in);
		// while (in.hasNext()) {
		// long n = in.nextInt();
		// int count = 0;
		// long x = n;
		// while (true) {
		// boolean flag = false;
		// for (int i = 2; i <= Math.sqrt(n); i++) {
		// if (n % i == 0) {
		// n /= i;
		// count++;
		// flag = true;
		// break;
		// }
		// }
		// if (!flag) {
		// count++;
		// break;
		// }
		// }
		// System.out.println(count);
		// }

	}
}
