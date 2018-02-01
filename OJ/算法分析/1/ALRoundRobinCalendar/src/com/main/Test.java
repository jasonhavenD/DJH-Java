package com.main;

import java.util.Scanner;

//可以观察的出:循环赛事表是一个以副对角线对称的矩阵

public class Test {
	public static void main(String[] args) {
		System.out.println("循环赛事问题\n");
		int k;
		Scanner in = new Scanner(System.in);
		System.out.println("请输入k(k>0):");
		k = in.nextInt();
		RoundRobinCalendar rbc = new RoundRobinCalendar(k);
		System.out.println("参赛人数为：" + rbc.getN());
		rbc.show();
	}

}
