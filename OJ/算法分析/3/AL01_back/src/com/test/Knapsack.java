package com.test;

import java.util.Scanner;
/*
11 7
2 8
4 8
8 12
9 13
6 4
10 14
 */

/*
 

8 34
12 32
24 56
16 67
6 54
9 32
35 45
21 56
18 46
19 70 
 */
public class Knapsack {
	private int n;// 物品数量
	private double W;// 背包容量
	private Goods goods[];
	private double cw = 0.0;// 当前背包重量
	private double cp = 0.0;// 当前背包中物品价值
	private double bestp = 0.0;// 当前最优价值
	private double perp[];// 单位物品价值排序后
	private int order[];// 物品编号
	private int x[];// 设置是否装入,解向量

	public Knapsack() {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入物品的数量和背包容量：");
		n = in.nextInt();
		W = in.nextDouble();
		System.out.println("请输入物品的重量和价值：");
		goods = new Goods[n + 1];

		order = new int[n + 1];
		perp = new double[n + 1];
		x = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int x;
			double y;
			x = in.nextInt();
			y = in.nextDouble();
			goods[i] = new Goods();
			goods[i].setW(x);
			goods[i].setV(y);
			order[i] = i;
		}
	}

	public void knapsack() {
		int i, j;
		int temporder = 0;
		double temp = 0.0;
		for (i = 1; i <= n; i++)
			perp[i] = goods[i].getV() / goods[i].getW();
		for (i = 1; i <= n - 1; i++) {
			for (j = i + 1; j <= n; j++)
				if (perp[i] < perp[j])// 冒泡排序perp[],order[],sortv[],sortw[]
				{
					temp = perp[i];
					perp[i] = perp[i];
					perp[j] = temp;

					temporder = order[i];
					order[i] = order[j];
					order[j] = temporder;
					temp = goods[i].getV();
					goods[i].setV(goods[j].getV());
					goods[j].setV(temp);

					temp = goods[i].getW();
					goods[i].setW(goods[j].getW());
					goods[j].setW(temp);
				}
		}
		backtrack(1);
		outPut();
	}

	public void backtrack(int i) {
		if (i > n) {
			bestp = cp;
			return;
		}
		if (cw + goods[i].getW() <= W) {
			x[i] = 1;//x[]是解向量，x[]取值0或1
			cw += goods[i].getW();
			cp += goods[i].getV();
			backtrack(i + 1);
			cw -= goods[i].getW();
			cp -= goods[i].getV();
		}
		if (bound(i + 1) > bestp)// 符合条件搜索右子数
			backtrack(i + 1);
	}

	public double bound(int i) {//i为第i层
		double leftw = W - cw;
		double b = cp;//cp为当前背包中物品的总价值
		while (i <= n && goods[i].getW() <= leftw) {
			leftw -= goods[i].getW();
			b += goods[i].getV();
			i++;
		}
		// 装满背包
		if (i <= n)
			b += goods[i].getV() / goods[i].getW() * leftw;
		return b;
	}
	
	public void outPut(){
		int i;
		System.out.println("最有价值为:" + bestp);
		System.out.println("需要装入的物品编号是：");
		for (i = 1; i <= n; i++) {
			if (x[i] == 1)
				System.out.print(order[i] + " ");
		}
	}
	public static void main(String[] args) {
		Knapsack knapsack = new Knapsack();
		knapsack.knapsack();
	}
}
