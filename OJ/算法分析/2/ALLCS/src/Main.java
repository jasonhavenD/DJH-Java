import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public int[] generateRandomArray(int expectedSum, int expectedNum) {

		Set<Integer> set = new TreeSet<Integer>();
		set.add(0);
		set.add(expectedSum);
		Random random = new Random();
		while (set.size() < expectedNum + 1) {
			set.add(random.nextInt(expectedSum - 1) + 1);
		}
		Integer[] locations = new Integer[set.size()];
		set.toArray(locations);
		int[] result = new int[expectedNum];

		for (int i = 0; i < result.length; i++) {
			result[i] = locations[i + 1] - locations[i];
		}
		Arrays.sort(result);
		return result;
	}

	private void printArray(int[] data) {
		for (int i : data) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
	 Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int l=in.nextInt();
		Main util = new Main();
		int count=l+1;
		for(count=l+1;;count++){
			  util.printArray(util.generateRandomArray(n, count));
			  break;
		}
 }
}