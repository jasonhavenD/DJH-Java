import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 会场安排 {
	public static void main(String[] args) {
		// start[]: 6 8 3 5 8 2 12 1 3 0 5
		// end []: 10 11 8 9 12 13 14 4 5 6 7
		/*
		 * 6 10 8 11 3 8 5 9 8 12 2 13 12 14 1 4 3 5 0 6 5 7
		 */
		Scanner in = new Scanner(System.in);
		System.out.println("�������ĸ���:");
		int n = in.nextInt();
		Meet[] meets = new Meet[n];
		for (int i = 0; i < n; i++) {
			meets[i] = new Meet();
			meets[i].mid = i;
			meets[i].start = in.nextInt();
			meets[i].end = in.nextInt();
		}
		System.out.println(Arrays.toString(meets));
		// ����,���ս���ʱ������Ǽ���
		for (int j = 1; j < n; j++) {
			Meet k = meets[j];
			int i = j - 1;
			while (i >= 0 && meets[i].compareTo(k) > 0) {
				meets[i + 1] = meets[i];
				i--;
			}
			meets[i + 1] = k;
		}
		System.out.println(Arrays.toString(meets));
		//
		Set<Meet> set = new HashSet<>();
		set.add(meets[0]);
		int k = 0;
		for (int i = 1; i < n; i++) {
			if (meets[i].start >= meets[k].end) {
				set.add(meets[i]);
				k = i;
			}
		}
		System.out.println(set);
	}
}

class Meet implements Comparable<Meet> {
	int mid;
	int start;
	int end;

	@Override
	public int compareTo(Meet o) {
		if (end > o.end) {
			return 1;
		}
		if (end == o.end) {
			return 0;
		}
		return -1;
	}

	@Override
	public String toString() {
		return "����-" + mid + "-��ʼ-" + start + "-����-" + end + ";";
	}
}