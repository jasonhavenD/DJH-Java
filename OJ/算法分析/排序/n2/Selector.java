package n2;

import java.util.Arrays;

import sort.ISortAble;

public class Selector implements ISortAble{

	@Override
	public void sort(int[] a) {
		int n=a.length;
		for(int i=0;i<n;i++){
			int k=i;
			for(int j=i+1;j<n;j++){
				if(a[k]>a[j]){
					int t=a[k];
					a[k]=a[j];
					a[j]=t;
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		int[] a = { 0, 3, 6, 8, 2, 4, 6, 9, 7, 5 };
		new Selector().sort(a);
		System.out.println(Arrays.toString(a));
	}
}
