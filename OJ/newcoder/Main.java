import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
	}
	
	public static void F1(){
		int total = 0;
		int[][] save = new int[300][];
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		int stack[] = new int[n];
		for (int i = 0; i < stack.length; i++) {
			stack[i] = i + 1;

		}
		for (int i = 0; i < 300; i++) {
			save[i] = new int[stack.length + 1];

		}
		InnArr(stack, save);
		System.out.println("The result is: ");
		for (; save[total][0] != 0; total++) {
			for (int j = 0; j < save[total].length - 2; j++) {
				System.out.print(save[total][j] + " ");

			}
			System.out.println(save[total][save[total].length - 2]);

		}
		System.out.println("Total: " + total);
	}

	public static void InnArr(int[] stack, int[][] save) {
		int k = 1;
		int p = 1;
		save[0][0] = stack[0];
		while (k < stack.length) {
			p = inset(stack, save, k, p);
			k++;
		}
	}

	public static int inset(int[] stack, int[][] save, int k, int p) {
		int f = p;
		for (int i = 0; i < p; i++) {
			for (int j = 0; j < k; j++) {
				if (save[i][j] == stack[k - 1]) {
					int temp[] = new int[save[i].length];
					System.arraycopy(save[i], 0, temp, 0, save[i].length);
					set(save[i], j + 1, stack[k], temp);
					set(save[f], j, stack[k], temp);
					f++;
					for (int m = j + 2; m <= k; m++) {
						set(save[f], m, stack[k], temp);
						f++;

					}
					break;
				}

			}

		}
		return f;
	}

	public static void set(int[] save, int m, int k, int[] arr) {
		System.arraycopy(arr, 0, save, 0, save.length);
		for (int i = save.length - 2; i >= m; i--) {
			save[i + 1] = save[i];

		}
		save[m] = k;
	}
}