import java.util.Arrays;

public class 归并排序 {
	public static void main(String[] args) {
		int a[] = { 0, 3, 1, 5, 2, 6, 4, 9, 8, 7 };
		mergeSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	public static void merge(int a[], int left, int mid, int right) {
		int n1, n2;
		n1 = mid - left + 1;
		n2 = right - mid;
		int[] x = new int[n1];// left-mid
		int y[] = new int[n2];// mid+1-right
		int i = 0, j = 0;
		for (i = 0; i < n1; i++) {
			x[i] = a[left + i];
		}
		for (i = 0; i < n2; i++) {
			y[i] = a[mid + i + 1];
		}
		i = j = 0;
		int k = 0;
		int z[] = new int[right - left + 1];
		while (i < n1 && j < n2) {
			if (x[i] < y[j]) {
				z[k++] = x[i++];
			} else {
				z[k++] = y[j++];
			}
		}
		while (i < n1) {
			z[k++] = x[i++];
		}
		while (j < n2) {
			z[k++] = y[j++];
		}
		for (i = 0; i < k; i++) {
			a[left + i] = z[i];
		}
	}

	public static void mergeSort(int a[], int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(a, left, mid);
			mergeSort(a, mid + 1, right);
			merge(a, left, mid, right);
		}
	}

}
