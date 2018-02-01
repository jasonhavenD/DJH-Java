package com.test;

import java.util.Iterator;

public class QNode implements Comparable<QNode> {
	private int cw; // 当前背包中物品的重量
	private int cp; // 当前背包中物品的价值
	private int up; // cp+rp(剩余物品的价值)
	private boolean isLeft; // 是否为左子树
	private int level; // 结点所处的层
	private QNode parentNode; // PQNode父节点

	public QNode() {
	}

	public QNode(int cw, int cp, int up, boolean isLeft, int level, QNode parentNode) {
		super();
		this.cw = cw;
		this.cp = cp;
		this.up = up;
		this.isLeft = isLeft;
		this.level = level;
		this.parentNode = parentNode;
	}

	public int getCw() {
		return cw;
	}

	public void setCw(int cw) {
		this.cw = cw;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public QNode getParentNode() {
		return parentNode;
	}

	public void setParentNode(QNode parentNode) {
		this.parentNode = parentNode;
	}

	@Override
	public int compareTo(QNode o) {
		if (cp + up > o.getCp() + o.getUp()) {
			return -1;
		} else if (cp + up < o.getCp() + o.getUp()) {
			return 1;
		} else {
			return 0;
		}
	}
}
