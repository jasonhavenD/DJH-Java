package n2;

import java.util.Arrays;

import sort.ISortAble;

public class Bubble implements ISortAble {

	@Override
	public void sort(int a[]) {
		int n = a.length;
		int t = 0;
		for (int i = n - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					t = a[j];
					a[j] = a[j + 1];
					a[j + 1] = t;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 0, 3, 6, 8, 2, 4, 6, 9, 7, 5 };
		new Bubble().sort(a);
		System.out.println(Arrays.toString(a));
	}
}
