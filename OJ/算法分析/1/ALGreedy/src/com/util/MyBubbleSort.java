package com.util;

import com.activityselector.Activity;

public class MyBubbleSort {
	public static Activity[] Sort(Activity[] A) {
		Activity[] temp = new Activity[A.length];
		for (int i = 0; i < A.length; i++) {
			temp[i] = A[i];
		}
		int n = temp.length;
		for (int i = n - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (temp[j].compareTo(temp[j + 1]) > 0) {
					Activity t = new Activity(temp[j].getStartTime(), temp[j].getEndTime());
					temp[j].setStartTime(temp[j + 1].getStartTime());
					temp[j].setEndTime(temp[j + 1].getEndTime());
					temp[j + 1].setStartTime(t.getStartTime());
					temp[j + 1].setEndTime(t.getEndTime());
				}
			}
		}
		return temp;
	}

}
