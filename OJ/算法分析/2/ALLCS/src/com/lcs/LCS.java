package com.lcs;

import java.util.Scanner;

public class LCS {
	private int m;
	private int n;
	private char[] x;
	private char[] y;
	private int[][] c;
	private int[][] b;
	private StringBuilder result;

	public static void main(String[] args) {
	}

	public LCS() {
		// System.out.println("最长公共子序列问题");
		init();
		LCSLength();
		LCS(m, n);
		System.out.println(result.length());
		// System.out.println("最长公共子序列的长度为："+result.length()+"\neg:"+result);
	}

	public void init() {
		Scanner in = new Scanner(System.in);
		result = new StringBuilder();
		// System.out.println("输入序列X的长度m:");
		// m = in.nextInt();
		// System.out.println("输入序列Y的长度n:");
		// n = in.nextInt();
		// x = new char[m + 1];
		// y = new char[n + 1];
		// c = new int[m + 1][n + 1];
		// b = new int[m + 1][n + 1];
		// char c;
		String[] ts = in.nextLine().split("[\\s]");
		m = ts[0].length();
		n = ts[1].length();
		x = new char[m + 1];
		y = new char[n + 1];
		c = new int[m + 1][n + 1];
		b = new int[m + 1][n + 1];
		// System.out.println("输入序列X的元素：");
		for (int i = 1; i <= m; i++) {
			// c = in.next().charAt(0);
			x[i] = ts[0].charAt(i - 1);
		}
		// System.out.println("输入序列Y的元素：");
		for (int i = 1; i <= n; i++) {
			// c = in.next().charAt(0);
			y[i] = ts[1].charAt(i - 1);
		}
	}

	public void LCSLength() {
		for (int i = 0; i <= m; i++) {
			c[i][0] = 0;
		}
		for (int i = 0; i <= n; i++) {
			c[0][i] = 0;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x[i] == y[j]) {
					c[i][j] = c[i - 1][j - 1] + 1;
					b[i][j] = 1;
				} else if (c[i - 1][j] >= c[i][j - 1]) {
					c[i][j] = c[i - 1][j];
					b[i][j] = 3;
				} else {
					c[i][j] = c[i][j - 1];
					b[i][j] = 2;
				}
			}
		}

	}

	public void LCS(int i, int j) {
		if (i == 0 || j == 0) {
			return;
		}
		if (b[i][j] == 1) {
			LCS(i - 1, j - 1);
			result.append(x[i]);
		} else if (b[i][j] == 2) {
			LCS(i, j - 1);
		} else {
			LCS(i - 1, j);
		}
	}

	public void showXY() {
		System.out.println("序列X和Y：");
		for (int i = 0; i < x.length; i++) {
			System.out.print("" + x[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < y.length; i++) {
			System.out.print("" + y[i] + " ");
		}
	}

}
