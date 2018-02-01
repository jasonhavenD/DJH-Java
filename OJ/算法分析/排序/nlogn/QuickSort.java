package nlogn;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] a = { 0, 3, 6, 8, 2, 4, 6, 9, 7, 5 };
		new QuickSort().sort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}

	public void sort(int[] a, int low, int high) {
		if (low < high) {
			int pivotIndex = position(a, low, high);
			sort(a, low, pivotIndex - 1);
			sort(a, pivotIndex + 1, high);
		}
	}

	public int position(int a[], int low, int high) {
		int pivot = a[low];
		while (low < high) {
			while (low < high && pivot <= a[high]) {
				high--;
			}
			a[low] = a[high];
			while (low < high && a[low] <= pivot) {
				low++;
			}
			a[high] = a[low];
		}
		a[low] = pivot;
		return low;
	}
}
