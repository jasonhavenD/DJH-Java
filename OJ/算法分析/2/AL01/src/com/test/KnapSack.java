package com.test;

import java.util.Scanner;

/* 
2 6 
2 3 
6 5 
5 4 
4 6
*
*/
public class KnapSack {
	private int W;// 背包总重
	private int c[][];
	private int n;// 物品个数，重量
	private Goods[] goods;
	private int x[];

	public KnapSack(int W, Goods[] goods) {
		super();
		this.W = W;
		this.c = c;
		this.goods = goods;
		n = goods.length;// +1
		n = n - 1;
		x = new int[n + 1];
		c = new int[n + 1][W + 1];
		for (int i = 0; i <= n; i++) {
			c[i][0] = 0;
		}
		for (int i = 0; i <= W; i++) {
			c[0][i] = 0;
		}
		caculator();
	}

	public void caculator() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= W; j++) {
				if (goods[i] == null) {
					System.out.println("null" + i);
				}

				if (j < goods[i].getW()) {
					c[i][j] = c[i - 1][j];
				} else {
					c[i][j] = max(c[i - 1][j], c[i - 1][j - goods[i].getW()] + goods[i].getV());
				}
			}
		}

	}

	public int max(int a, int b) {
		return a >= b ? a : b;
	}

	public void show() {
		int j = W;
		for (int i = n; i > 0; i--) {
			if (c[i][j] > c[i - 1][j]) {
				x[i] = 1;
				j -= goods[i].getW();
			} else {
				x[i] = 0;
			}
		}
		System.out.println("算法结果:");
		for (int i = 1; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
		System.out.println("\n背包最大价值为："+c[n][W]);
	}


	public static void main(String[] args) {
		System.out.println("0-1背包问题\n");
		Scanner in = new Scanner(System.in);
		int n;
		System.out.println("输入物品的个数：");
		n = in.nextInt();
		Goods[] goods = null;
		goods = new Goods[n + 1];
		goods[0] = new Goods();
		System.out.println("输入物品的重量和价值：");
		for (int i = 1; i <= n; i++) {
			goods[i] = new Goods();
			int w, v;
			w = in.nextInt();
			v = in.nextInt();
			goods[i].setW(w);
			goods[i].setV(v);
		}
		int w;
		System.out.println("输入背包的容量：");
		w = in.nextInt();
		KnapSack knapSack = new KnapSack(w, goods);
		knapSack.show();
	}

}
