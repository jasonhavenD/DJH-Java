package nlogn;

import java.util.Arrays;
/** 
* @param nums ´ýÅÅÐòÊý×é 
* @return Êä³öÓÐÐòÊý×é 
*/  
public class MergeSort {

public static void main(String[] args) {
int a[] = { 0, 3, 6, 2, 4, 9, 7, 5, 8, 1 };
new MergeSort().sort(a, 0, a.length - 1);
System.out.println(Arrays.toString(a));
}
public void sort(int[] a, int left, int right) {
if (left < right) {
int mid = (left + right) / 2;		sort(a, left, mid);
sort(a, mid + 1, right);
merge(a, left, mid, right);
}
}

public void merge(int[] arr, int left, int mid, int right) {
System.out.println(Arrays.toString(arr));
int a[], b[], c[];
int n1, n2;
n1 = mid - left + 1;
n2 = right - mid;
a = new int[n1];
b = new int[n2];
c = new int[n1 + n2];

int i = 0, j = 0, k = 0;

for (i = 0; i < n1; i++) {
a[i] = arr[left + i];
}

for (i = 0; i < n2; i++) {
b[i] = arr[mid + 1 + i];
}
i = 0;
while (i < n1 && j < n2) {
if (a[i] < b[j]) {
c[k++] = a[i++];
} else {
c[k++] = b[j++];
}
}
while (i < n1) {
c[k++] = a[i++];
}
while (j < n2) {
c[k++] = b[j++];
}
for (i = 0; i < c.length; i++) {
arr[left + i] = c[i];
}
}

}
