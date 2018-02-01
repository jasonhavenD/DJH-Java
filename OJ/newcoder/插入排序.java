import java.util.Arrays;

public class  插入排序 {
	public static void main(String[] args) {
		int a[] = { 6,0, 3, 2, 1, 6, 8, 5, 4, 9, 7 };
		for (int i = 1; i < a.length; i++) {
			int k = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] > k) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = k;
		}
		System.out.println(Arrays.toString(a));

	}
}
