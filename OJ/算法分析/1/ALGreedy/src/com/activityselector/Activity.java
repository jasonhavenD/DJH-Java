package com.activityselector;

public class Activity implements Comparable<Activity> {
	private int startTime;
	private int endTime;
	boolean flag;// 是否被选中

	public Activity() {
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public Activity(int startTime, int endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "会议开始时间：" + startTime + "会议结束时间：" + endTime;
	}

	@Override
	public int compareTo(Activity o) {
		if (this.endTime > o.endTime) {
			return 1;
		}
		if (this.endTime < o.endTime) {
			return -1;
		}
		return 0;
	}

}
