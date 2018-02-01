import java.util.Scanner;
import java.util.Vector;

public class FinaPath {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int times = scanner.nextInt();
		Vector<Integer> arry = new Vector<>();
		Vector<Integer> arry2 = new Vector<>();
		int x;
		for (int i = 0; i < num; i++) {
			x = scanner.nextInt();
			arry.add(x);
			arry2.add(0);
		}
		for (int j = 0; j < times; j++) {
			for (int i = 0; i < num; i++) {
				if (i == num - 1) {
					arry2.set(i, count(arry.get(i), arry.get(0)));
				} else {
					arry2.set(i, count(arry.get(i), arry.get(i + 1)));
				}
			}

			for (int i = 0; i < num; i++) {
				arry.set(i, arry2.get(i));
			}
		}
		output(arry, num);
	}

	public static void output(Vector<Integer> arry, int num) {
		for (int i = 0; i < arry.size() - 1; i++) {
			System.out.print(arry.get(i) + " ");
		}
		System.out.println(arry.get(num - 1));
	}

	public static int count(int a, int b) {
		int c = a + b;
		return c % 100;
	}
	/*
	 * 3 2 1 2 3
	 */
}
