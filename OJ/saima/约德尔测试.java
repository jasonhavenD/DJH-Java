package saima;

import java.util.Scanner;

public class Ô¼µÂ¶û²âÊÔ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1, s2;
		s1 = in.nextLine();
		s2 = in.nextLine();
		int a = 0, b = s2.length();
		for (int i = 0; i < b; i++) {
			char x = s1.charAt(i);
			if (x >= 'a' && x <= 'z' || x >= 'A' && x <= 'Z' || x >= '0' && x <= '9') {
				x = '1';
			} else {
				x = '0';
			}
			if (x == s2.charAt(i)) {
				a++;
			}
		}

		System.out.printf("%.2f%%", 100.0 * a / b);
	}
}
