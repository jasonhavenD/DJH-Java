//package tree;
//
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Queue;
//import java.util.Scanner;
//import java.util.Stack;
//import java.util.Vector;
//import java.util.concurrent.LinkedBlockingQueue;
//
//class ListNode {
//	int val;
//	ListNode next = null;
//
//	ListNode(int val) {
//		this.val = val;
//	}
//}
//
//class TNode {
//	char val = 0;
//	TNode left = null;
//	TNode right = null;
//
//	public TNode(char val) {
//		this.val = val;
//
//	}
//
//}
//
//class Person implements Comparable<Person> {
//	String no;
//	String name;
//	String sex;
//	int score;
//
//	@Override
//	public int compareTo(Person o) {
//		if (score < o.score) {
//			return 1;
//		}
//		if (score > o.score) {
//			return -1;
//		}
//		return 0;
//	}
//
//	@Override
//	public String toString() {
//		return no + " " + name + " " + sex + " " + score;
//	}
//
//}
//
//public class Main {
//
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		while (in.hasNext()) {
//			BigInteger a = in.nextBigInteger();
//			BigInteger b = in.nextBigInteger();
//			BigInteger t = a;
//			Long x = (long) Math.pow(a.longValue(), b.longValue());
//			String tString = x.toString();
//			if (tString.length() > 3) {
//				System.out.println("" + tString.charAt(tString.length() - 3) + tString.charAt(tString.length() - 2)
//						+ tString.charAt(tString.length() - 1));
//			}else{
//				System.out.println(x);
//			}
//		}
//
//	}
//
//	public static int fun(int a, int n) {
//		if (n == 0) {
//			return a;
//		} else {
//			int x = 1;
//			for (int i = 0; i < n; i++) {
//				x *= 10;
//			}
//			return a * x + fun(a, n - 1);
//		}
//	}
//
//	public static int getMax(int ms[], int ns[]) {
//		int max = 0;
//		int ms_len = ms.length;
//		int ns_len = ns.length;
//		int len = 0;// 截取len个ai
//		for (int i = 0; i < ms_len; i++) {
//			len += ms[i];
//		}
//		// System.out.println(len);
//		for (int i = 0; i < ns_len - len + 1; i++) {
//			int subMax = 0;
//			for (int j = i; j < i + len; j++) {
//				subMax += ns[j];
//			}
//			if (max < subMax) {
//				max = subMax;
//			}
//		}
//		return max;
//	}
//
//	// ListNode node0 = new ListNode(0);
//	// ListNode node1 = new ListNode(1);
//	// ListNode node2 = new ListNode(1);
//	// ListNode node3 = new ListNode(0);
//	// node0.next = node1;
//	// node1.next = node2;
//	// System.out.println(plusAB(node0, node3));// 011,0
//
//	public static ListNode plusAB(ListNode a, ListNode b) {
//		if (a == null) {
//			return b;
//		} else if (b == null) {
//			return a;
//		}
//		ListNode t = null;
//		ListNode p = t;
//		while (a != null && b != null) {
//			t = new ListNode(a.val + b.val);
//			a = a.next;
//			b = b.next;
//			t = t.next;
//		}
//		while (a != null) {
//			t = new ListNode(a.val);
//			a = a.next;
//			t = t.next;
//		}
//		while (b != null) {
//			t = new ListNode(b.val);
//			b = b.next;
//			t = t.next;
//		}
//		return p;
//	}
//
//	public static ListNode partition(ListNode pHead, int x) {
//		if (pHead == null) {
//			return null;
//		}
//		ListNode node = pHead;
//		Queue<Integer> queue = new LinkedBlockingQueue();// 保存小于x的值
//		Queue<Integer> stack = new LinkedBlockingQueue();// 保存大于x的值
//		while (node != null) {
//			int val = node.val;
//			if (val < x) {
//				queue.add(node.val);
//			} else {
//				stack.add(node.val);
//			}
//			node = node.next;
//		}
//		pHead = new ListNode(0);
//		node = pHead;
//		while (!queue.isEmpty()) {
//			int val = queue.poll();
//			ListNode t = new ListNode(val);
//			node.next = t;
//			node = node.next;
//		}
//		while (!stack.isEmpty()) {
//			int val = stack.poll();
//			ListNode t = new ListNode(val);
//			node.next = t;
//			node = node.next;
//		}
//		return pHead.next;
//	}
//
//	public static boolean isRelate2Seven(int x) {
//		boolean flag = false;
//		if (x % 7 == 0) {
//			flag = true;
//		} else {
//			int n = 0;
//			int t = x;
//			while (t > 0) {
//				t /= 10;
//				n++;
//			}
//			for (int i = 0; i < n; i++) {
//				t = x % 10;
//				if (t == 7) {
//					flag = true;
//				}
//				x /= 10;
//			}
//		}
//		return flag;
//	}
//
//	public static void permutation(ArrayList<String> arrayList, char[] cs, int k) {
//		if (cs.length == k) {
//			arrayList.add(new String(cs));
//			return;
//		}
//		for (int i = k; i < cs.length; i++) {
//			swap(cs, i, k);
//			permutation(arrayList, cs, k + 1);
//			swap(cs, i, k);
//		}
//
//	}
//
//	public static void swap(char[] s, int i, int j) {
//		char tmp = s[i];
//		s[i] = s[j];
//		s[j] = tmp;
//	}
//
//	public static int Fibonacci(int n) {
//		if (n == 1 || n == 2) {
//			return 1;
//		}
//		int[] a = new int[n + 1];
//		a[0] = 0;
//		a[1] = 1;
//		for (int i = 2; i <= n; i++) {
//			a[i] = a[i - 1] + a[i - 2];
//		}
//		return a[n];
//	}
//
//	public static boolean isWanShu(int x) {
//		// 所有的真因数的和等于本身
//		int sum = 0;
//		for (int i = 1; i < x; i++) {
//			if (x % i == 0) {
//				sum += i;
//			}
//		}
//		if (sum == x) {
//			return true;
//		}
//		return false;
//	}
//
//	public static boolean isYinShu(int x) {
//		int sum = 0;
//		for (int i = 1; i < x; i++) {
//			if (x % i == 0) {
//				sum += i;
//			}
//		}
//		if (sum > x) {
//			return true;
//		}
//		return false;
//	}
//
//	public static int[] fun(int x) {
//		// 先求x的位数
//		int n = x;
//		int count = 0;
//		while (n > 0) {
//			n /= 10;
//			count++;
//		}
//		int[] a = new int[count];
//		// 再求各个位的数字
//		int i = x, j, k = 0;
//		while (true) {
//			j = i % 10;// 取到最低位（余数）
//			a[k++] = j;
//			i = i / 10;// 右移一位
//			if (i == 0)
//				break;
//		}
//		return a;
//	}
//
//	public static boolean isPrime(int x) {
//		boolean flag = true;
//		for (int i = 2; i * i <= x; i++) {
//			if (x % i == 0) {
//				flag = false;
//			}
//		}
//		return flag;
//	}
//
//	public static TNode create(String string, int index) {
//		char c = string.charAt(index++);
//		if (c == '#') {
//			return null;
//		} else {
//			TNode rNode = new TNode(c);
//			rNode.left = create(string, index);
//			rNode.right = create(string, index);
//			return rNode;
//		}
//	}
//
//	public static void inOrder(TNode rNode) {
//		if (rNode != null) {
//			inOrder(rNode.left);
//			System.out.println(rNode.val + " ");
//			inOrder(rNode.right);
//		}
//	}
//
//	public static int yueShu(int x) {
//		int count = 0;
//		for (int i = 1; i * i <= x; i++) {
//			if (x % i == 0) {
//				count += 2;
//			}
//		}
//		return count;
//	}
//
//	HashMap<Character, Integer> map = new HashMap();
//	ArrayList<Character> list = new ArrayList<Character>();
//
//	// 删除链表中重复的结点
//	public ListNode deleteDuplication(ListNode pHead) {
//		ListNode q, p, r;
//		p = pHead;
//		q = r = null;
//
//		while (p != null) {
//			boolean flag = false;
//			r = p.next;
//			while (r != null && r.val == p.val) {
//				flag = true;
//				r = r.next;
//			}
//			if (flag) {
//				if (q != null)
//					q.next = r;
//				else
//					pHead = null;
//			} else {
//				if (q == null)
//					pHead = p;
//				q = p;
//			}
//			p = r;
//		}
//
//		return pHead;
//
//	}
//
//	// 最大窗口值
//	public static ArrayList<Integer> maxInWindows(int[] num, int size) {
//		ArrayList<Integer> arrayList = new ArrayList<>();
//		if (size == 0) {
//			return arrayList;
//		}
//		int n = num.length;
//		boolean isEnd = false;
//		for (int i = 0; i < n; i++) {
//			Vector<Integer> vector = new Vector<>();
//			for (int j = 0; j < size; j++) {
//				int k = i + j;
//				if (k >= n) {
//					isEnd = true;
//					break;
//				}
//				vector.add(num[k]);
//			}
//			if (isEnd) {
//				break;
//			}
//			int max = Collections.max(vector);
//			arrayList.add(max);
//		}
//		return arrayList;
//	}
//
//	// 查找字符串中第一次出现的字符
//	public char FirstAppearingOnce() {
//		char c = '#';
//		for (char key : list) {
//			if (map.get(key) == 1) {
//				c = key;
//				break;
//			}
//		}
//		return c;
//	}
//
//	private Stack<Integer> stack = new Stack<Integer>();
//
//	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
//		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
//		ArrayList<Integer> temp = FindPath(root, target, 0);
//		if (temp != null && !temp.isEmpty()) {
//			arrayList.add(temp);
//		}
//		return arrayList;
//
//	}
//
//	public ArrayList<Integer> FindPath(TreeNode node, int sum, int currSum) {
//		ArrayList<Integer> temp = new ArrayList<>();
//		boolean isLeaf;
//		if (node == null)
//			return temp;
//		currSum += node.val;
//		stack.push(node.val);
//		isLeaf = node.left == null && node.right == null;
//		if (currSum == sum && isLeaf) {
//			for (int val : stack) {
//				temp.add(val);
//			}
//			return temp;
//		}
//		if (node.left != null)
//			FindPath(node.left, sum, currSum);
//		if (node.right != null)
//			FindPath(node.right, sum, currSum);
//		currSum -= node.val;
//		stack.pop();
//		return temp;
//	}
//
//	public static boolean match(char[] str, char[] pattern) {
//		boolean flag = false;
//		// .一个字符,*0个或多个字符
//		String s = new String(str);
//		if (s.matches(new String(pattern))) {
//			flag = true;
//		}
//		return flag;
//	}
//
//	// 二叉树后续搜索遍历序列
//	public boolean VerifySquenceOfBST(int[] sequence) {
//		if (sequence == null || sequence.length == 0)
//			return false;
//		return verifySequenceOfBST(sequence, 0, sequence.length - 1);
//	}
//
//	private boolean verifySequenceOfBST(int[] seq, int start, int end) {
//		if (start > end)
//			return true;
//		int root = seq[end];// 找到根节点
//		int i = start;
//		while (i <= end - 1) {
//			if (seq[i] > root)
//				break;
//			i++;
//		}
//		int j = i;// 找到左子树和右子树分解
//		while (j <= end - 1) {// 判断右子树是否合格
//			if (seq[j] < root)
//				return false;
//			j++;
//		}
//		boolean left = true;
//		left = verifySequenceOfBST(seq, start, i - 1);// 对左子树递归处理
//		boolean right = true;
//		right = verifySequenceOfBST(seq, i, end - 1);// 对右子树递归处理
//		return left & right;
//
//	}
//
//	// 重建二叉树:前序遍历和中序遍历
//	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
//		return null;
//
//	}
//
//	// 判断二叉树是否对称
//	boolean isSymmetrical(TreeNode pRoot) {
//		if (pRoot == null) {
//			return true;
//		} else {
//			return Judge(pRoot.left, pRoot.right);
//		}
//	}
//
//	boolean Judge(TreeNode left, TreeNode right) {
//		if (left == null && right == null)
//			return true;
//		if (left == null || right == null)
//			return false;
//		if (left.val == right.val)
//			return Judge(left.right, right.left) && Judge(left.left, right.right);
//		return false;
//	}
//
//	// 判断二叉树是否相等
//	boolean IsEqual(TreeNode pRoot1, TreeNode pRoot2) {
//		if (pRoot1 == null && pRoot2 == null) {
//			return true;
//		}
//		if (pRoot1 == null || pRoot2 == null) {
//			return false;
//		} else {
//			if (pRoot1.val == pRoot2.val) {
//				return true;
//			} else {
//				boolean flag1 = IsEqual(pRoot1.left, pRoot2.left) && IsEqual(pRoot1.right, pRoot2.right);
//				boolean flag2 = IsEqual(pRoot1.left, pRoot2.right) && IsEqual(pRoot1.right, pRoot2.left);
//				if (flag1 || flag2) {
//					return true;
//				} else {
//					return false;
//				}
//			}
//		}
//
//	}
//
//	// 平衡二叉树判断
//	public boolean IsBalanced_Solution(TreeNode root) {
//		boolean flag = true;
//		if (root == null) {
//			return false;
//		}
//		int left = TreeDepth(root.left);
//		int right = TreeDepth(root.right);
//		if (Math.abs(left - right) > 1) {
//			flag = false;
//		}
//		return flag;
//	}
//
//	// 树的深度
//	public int TreeDepth(TreeNode root) {
//		if (root == null)
//			return 0;
//		else {
//			int left = TreeDepth(root.left);
//			int right = TreeDepth(root.right);
//			return 1 + Math.max(left, right);
//		}
//	}
//
//	// 二叉树的下一个结点(中序遍历)
//	public TreeLinkNode GetNext(TreeLinkNode pNode) {
//		TreeLinkNode curNode = null;
//		// 第一步：判断是否有右孩子
//		if (pNode.right != null) {
//			curNode = pNode;
//			while (curNode.left != null) {
//				curNode = curNode.left;
//			}
//			return curNode;
//		}
//		// 第二步：判断是否是其父节点的左孩子
//		if (pNode.next == null)
//			return null;
//		if (pNode == pNode.next.left) {
//			return pNode.next;
//		}
//		// 第三步：向上找其父节点，直到父节点是其父节点的父节点的左孩子
//		curNode = pNode.next;
//		while (curNode.next != null) {
//			if (curNode == curNode.next.left) {
//				return curNode.next;
//			}
//			// 继续向上找父节点
//			curNode = curNode.next;
//		}
//		return null;
//	}
//
////	// 从上到下打印二叉树-队列
////	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
////		ArrayList<Integer> arrayList = new ArrayList<>();
////		Queue<TreeNode> queue = new LinkedBlockingQueue<>();
////		// 借助对列层序遍历
////		if (root != null) {
////			queue.add(root);
////			while (!queue.isEmpty()) {
////				TreeNode t = queue.poll();
////				arrayList.add(t.val);
////				if (t.left != null) {
////					queue.add(t.left);
////				}
////				if (t.right != null) {
////					queue.add(t.right);
////				}
////			}
////		}
////		return arrayList;
////	}
//
//	// 二叉树子结构
////	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
////		if (root1 == null || root2 == null) {
////			return false;
////		}
////		boolean flag = false;
////		if (root1.val == root2.val) {
////			flag = isPart(root1, root2);
////		}
////		if (flag == false) {
////			return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
////		} else
////			return flag;
////	}
//
////	public boolean isPart(TreeNode root1, TreeNode root2) {
////		if (root2 == null) {// 先判断root是否遍历完毕，如果完毕则返回true
////			return true;
////		}
////		if (root1 == null) {
////			return false;
////		}
////		if (root1.val == root2.val) {
////			return isPart(root1.left, root2.left) && isPart(root1.right, root2.right);
////		} else
////			return false;
////	}
//
////	// 镜像二叉树
////	public void Mirror(TreeNode root) {
////		if (root != null) {
////			if (root.left != null || root.right != null) {
////				TreeNode temp = root.left;
////				root.left = root.right;
////				root.right = temp;
////			}
////			if (root.left != null) {
////				Mirror(root.left);
////			}
////			if (root.right != null) {
////				Mirror(root.right);
////			}
////		}
////	}
//}
//
//class TreeLinkNode {
//	int val;
//	TreeLinkNode left = null;
//	TreeLinkNode right = null;
//	TreeLinkNode next = null;
//
//	TreeLinkNode(int val) {
//		this.val = val;
//	}
//}
//
//
