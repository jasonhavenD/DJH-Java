import java.util.Scanner;

public class 最长回文Palindrome {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String string = in.next();
			if (string == null) {
				continue;
			}
			System.out.println(getLongestPalindrome(string, string.length()));
		}
	}

	public static int getLongestPalindrome(String A, int n) {
		int max = 0;
		String result = "";
		for (int i = 0; i < n; i++) {
			String sub;
			for (int j = i + 1; j <= n; j++) {
				sub = A.substring(i, j);
				if (isHuiWen(sub)) {
					if (max < sub.length()) {
						max = sub.length();
						result = sub;
					}
				}
			}
		}
		return max;
	}

	public static boolean isHuiWen(String string) {
		boolean flag = true;
		char[] cs = string.toCharArray();
		int n = cs.length;
		for (int i = 0; i < n / 2; i++) {
			if (cs[i] != cs[n - i - 1]) {
				flag = false;
			}
		}
		return flag;
	}
}
