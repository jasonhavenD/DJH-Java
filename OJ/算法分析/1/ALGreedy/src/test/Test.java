package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.activityselector.Activity;
import com.util.MyBubbleSort;

//测试数据
//11
//3 5 1 4 5 7 0 6 3 8 6 10 5 9 8 12 8 11 2 13 12 14

public class Test {

	public static void main(String[] args) {
		int n;// 声明会议个数
		int start, end;
		Scanner in = new Scanner(System.in);
		System.out.println("会场安排问题\n\n请输入会议个数:");
		n = in.nextInt();
		Activity[] activities = new Activity[n];
		System.out.println("请依次输入会议的开始时间和结束时间(空格隔开):");
		for (int i = 0; i < n; i++) {
			start = in.nextInt();
			end = in.nextInt();
			activities[i] = new Activity(start, end);
		}
		for (int i = 0; i < n; i++) {
			System.out.println("第" + (i + 1) + "场:" + activities[i].toString());
		}
		Activity[] temp = MyBubbleSort.Sort(activities);
		Set<Integer> A = new HashSet<Integer>();// 定义会议结果集合(存放会议数组的下标)
		A.add(0);// 首先选择会议1
		temp[0].setFlag(true);
		int k = 0; // 已被选择会议集合中最晚结束的会议
		for (int i = 1; i < n; i++) {
			if (temp[i].getStartTime() > temp[k].getEndTime()) {// 会议m的开始时间不小于会议k的结束时间
				temp[i].setFlag(true);
				A.add(i);// 将会议m加入到集合A中
				k = i;// 此时集合A中最晚结束的会议为m
			}
		}
		System.out.println("安排结果:");
		for (int i = 0; i < activities.length; i++) {
			if (activities[i].isFlag()) {
				System.out.println("第" + (i + 1) + "场会议," + activities[i].toString());
			}

		}
	}
}
