package com.test;

import java.util.Arrays;
import java.util.Scanner;

//图着色问题回溯法
/*
0 1 1 0 0
0 1 1 0 1
1 1 0 0 1
0 1 0 0 1
0 1 1 1 0
*/

/*
0 1 1 1 1
1 0 1 0 0
1 1 0 1 0
1 1 0 0 1
1 0 0 1 0
*/

/*
0 1 1 1 0
1 0 1 1 1
1 1 0 1 0
0 1 1 0 1
0 1 0 1 0
*/
public class GCP {
	private int n;// 顶点个数
	private int m;// 可用颜色个数
	private int a[][];// 图的邻接矩阵
	private int x[];// 存储着色解向量

	public GCP(int n, int m, int[][] a, int[] x) {
		super();
		this.n = n;
		this.m = m;
		this.a = a;
		this.x = x;
	}

	public void backtrack(int t) {
		if (t > n) {
			// 输出
			for(int i=1;i<=n;i++){
				System.out.print(x[i]+" ");
			}
			System.out.println();
		} else {
			for (int i = 1; i <= m; i++) {
				x[t] = i;
				if (colorPlace(t)) {
					backtrack(t + 1);
				}
			}
		}
	}

	public boolean colorPlace(int k) {
		for (int j = 1; j <= k - 1; j++) {
			if (a[k][j] == 1 && x[j] == x[k]) // 邻接且着不同的颜色
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int n;// 顶点个数
		int m;// 可用颜色个数
		int a[][];// 图的邻接矩阵
		int x[];// 存储着色解向量
		Scanner in = new Scanner(System.in);
		System.out.println("输入顶点个数");
		n = in.nextInt();
		a = new int[n + 1][n + 1];
		System.out.println("输入邻接矩阵");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a[i][j] = in.nextInt();
			}
		}
		System.out.println("输入颜色个数");
		m = in.nextInt();
		x = new int[n + 1];
		GCP gcp = new GCP(n, m, a, x);
		gcp.backtrack(1);
	}
}
