package com.main;

public class RoundRobinCalendar {
	int k;
	int n;
	int[][] a;

	public RoundRobinCalendar(int k) {
		super();
		this.k = k;
		if (k != 0) {
			n = (int) Math.pow(2, k);
		} else {
			this.k = 1;
			n = 2;
		}
		a = new int[n + 1][n + 1];
		gameTable();
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int[][] getA() {
		return a;
	}

	public void setA(int[][] a) {
		this.a = a;
	}

	public void gameTable() {// 时间复杂度为:k*(求和logn)*m^2
		for (int i = 1; i <= n; i++)
			a[1][i] = i;// 设置日程表第一行
		int m = 1;// 每次填充时，起始填充位置
		int n1 = n;
		for (int s = 1; s <= k; s++) {
			n1 /= 2;
			for (int t = 1; t <= n1; t++) {
				for (int i = m + 1; i <= 2 * m; i++) {
					for (int j = m + 1; j <= 2 * m; j++) {
						a[i][j + (t - 1) * m * 2] = a[i - m][j + (t - 1) * m * 2 - m];
						a[i][j + (t - 1) * m * 2 - m] = a[i - m][j + (t - 1) * m * 2];
					}
				}
			}
			m *= 2;
		}
	}

	public void show() {
		System.out.println("\n日程表:\n(第i行第j列表示和第i个选手在第j天比赛的选手序号)");
		System.out.print(" 天数:\t");
		for(int i=1;i<=n-1;i++){
			System.out.print("\t第"+i+"天");
		}
		System.out.println();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (j == 1) {
					System.out.print("参赛者" + i+"\t");
				} else {
					System.out.print("\t 　" + a[i][j]);
				}
			}
			System.out.println();
		}
	}

}
