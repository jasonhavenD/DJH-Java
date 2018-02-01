import java.util.Scanner;

public class 二叉树遍历 {

	private static class ListNode {
		private char val;
		private ListNode left;
		private ListNode right;

		public ListNode(char val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	private static ListNode rebuildTree(String nlr) {
		int[] index = new int[] { 0 };// ģ��ָ�룬�ݹ�����ж��Ƕ�index[0]�����޸�;Ҳ����ȫ�ֱ���ʵ��
		return createNLRTree(nlr, index);
	}

	/**
	 * @param str
	 * @param index
	 * @return �����������й������������ݹ�
	 */
	private static ListNode createNLRTree(String str, int[] index) {
		char ch = str.charAt(index[0]);
		if (ch == '#')
			return null;
		else {
			ListNode root = new ListNode(ch);
			++index[0];
			root.left = createNLRTree(str, index);
			++index[0];
			root.right = createNLRTree(str, index);
			return root;
		}
	}

	/**
	 * ����������������ݹ�
	 */
	private static void LNRTranversal(ListNode root) {
		if (root == null)
			return;
		LNRTranversal(root.left);
		System.out.print(root.val + " ");
		LNRTranversal(root.right);
	}

	public static void main(String[] args) {
		//����������ABC##DE#G##F### 
		//���������c b e g d f a
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String str = in.next();
			ListNode head = rebuildTree(str);
			LNRTranversal(head);
			System.out.println();// ���ӵ������ʽ��ÿһ�ж���һ���ո񣬲��軻��
		}
		in.close();
	}

}