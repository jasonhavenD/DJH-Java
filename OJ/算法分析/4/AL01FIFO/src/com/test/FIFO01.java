package com.test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

import sun.reflect.generics.tree.VoidDescriptor;

//FIFO分支限界--01背包

/*
n = 4，W = 7，w = {3,5,2,1}，v = {9,10,7,4}

n=3，w={16,15,15}, p={45,25,25}, c=30
 */

public class FIFO01 {
	private int n;// n个物品
	private int w[];// 存放物品的w
	private int v[];// 存放物品的v
	private int W;// 背包的容量
	private int bestp = 0;// 当前最优解<-cp
	private int cw = 0;// 当前加入背包的物品总 重量
	private int cp = 0;// 当前加入背包的物品总价值
	private int up = 0;// 剩余物品的总价值
	private int[] x;// 存放最优解
	private LinkedBlockingQueue<QNode> queue;

	public FIFO01() {

	}

	public FIFO01(int n, int[] w, int[] v, int w2) {
		super();
		this.n = n;
		this.w = w;
		this.v = v;
		this.W = w2;
		x = new int[n + 1];
		queue = new LinkedBlockingQueue();
	}

	public void Q_BB_KNAPSACK() {
		int i = 1;
		QNode qNode = null;
		while (true && i <= n) {
			if (cw + w[i] <= W) {// 左节点
				System.out.println("1");
				bestp = (cp + v[i] > bestp) ? (cp + v[i]) : bestp;
				queue.add(new QNode(cw + w[i], cp + v[i], up, true, i + 1, qNode));
			}
			up = bound(i + 1);
			if (up > bestp) {// 右节点
				System.out.println("0");
				queue.add(new QNode(cw, cp, up, false, i + 1, qNode));
			}
			qNode = queue.remove();
			if (qNode == null) {
				break;
			}
			cw = qNode.getCw();
			cp = qNode.getCp();
			up = qNode.getUp();
			i = qNode.getLevel();
		}

		// 构造最优解
		for (i = n; i >= 1; i--) {
			x[i] = (qNode.isLeft()) ? 1 : 0;
			qNode = qNode.getParentNode();
		}
		// 输出
		System.out.println("最大价值：" + bestp);
		System.out.println("被选中物品为:");
		for (i = 1; i <= n; i++) {
			System.out.print(x[i] + " ");
		}
	}

	public int bound(int i) {// i为第i层
		int leftw = W - cw;
		int b = cp;// cp为当前背包中物品的总价值
		while (i <= n && w[i] <= leftw) {
			leftw -= w[i];
			b += v[i];
			i++;
		}
		// 装满背包
		if (i <= n)
			b += v[i] / w[i] * leftw;
		return b;
	}

	public static void main(String[] args) {
		int n;// n个物品
		int w[];// 存放物品的w
		int v[];// 存放物品的v
		int W;// 背包的容量
		int x[];// 存放解,取值为0或1
		Scanner in = new Scanner(System.in);
		// 初始化
		System.out.println("输入物品的个数");
		n = in.nextInt();
		System.out.println("输入物品的重量");
		w = new int[n + 1];
		v = new int[n + 1];
		x = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			w[i] = in.nextInt();
		}
		System.out.println("输入物品的价值");
		for (int i = 1; i <= n; i++) {
			v[i] = in.nextInt();
		}
		System.out.println("输入背包容量");
		W = in.nextInt();

		// 分支限界
		int cp = 0;// 当前加入背包的物品总价值
		int bestp = 0;// 当前最优解<-cp
		// 算法
		System.out.println("搜索路径如下：(1代表左子树，0代表右子树,数深为" + (n + 1) + ")");
		FIFO01 fifo01 = new FIFO01(n, w, v, W);
		fifo01.Q_BB_KNAPSACK();
	}

}
