package tree;

import java.util.Stack;

public class MyBinTree {
	private MyBinNode root;

	public MyBinNode getRoot() {
		return root;
	}

	/**
	 * <pre>
	 *           A
	 *     B          C
	 *  D     E            F
	 * </pre>
	 */
	public void init() {
		root = new MyBinNode('a', null, null);
		MyBinNode bBinNode = new MyBinNode('b', null, null);
		MyBinNode cBinNode = new MyBinNode('c', null, null);
		MyBinNode dBinNode = new MyBinNode('d', null, null);
		MyBinNode eBinNode = new MyBinNode('e', null, null);
		MyBinNode fBinNode = new MyBinNode('f', null, null);
		root.left = bBinNode;
		root.right = cBinNode;
		bBinNode.left = dBinNode;
		bBinNode.right = eBinNode;
		cBinNode.right = fBinNode;
	}

	public void visit(MyBinNode subTree) {
		System.out.println("data:" + subTree.data);
	}

	public void preOrder(MyBinNode subNode) {
		if (subNode != null) {
			visit(subNode);
			preOrder(subNode.left);
			preOrder(subNode.right);
		}
	}

	public void midOrder(MyBinNode subNode) {
		if (subNode != null) {
			midOrder(subNode.left);
			visit(subNode);
			midOrder(subNode.right);
		}
	}

	public void afterOrder(MyBinNode subNode) {
		if (subNode != null) {
			afterOrder(subNode.left);
			afterOrder(subNode.right);
			visit(subNode);
		}
	}

	// 非递归前序
	public void noRecPreOrder(MyBinNode p) {
		Stack<MyBinNode> stack = new Stack<>();
		if (p != null) {
			stack.push(p);
			while (!stack.isEmpty()) {
				MyBinNode node = stack.pop();
				visit(node);
				if (node.right != null) {
					stack.push(node.right);
				}
				if (node.left != null) {
					stack.push(node.left);
				}
			}
		}
	}

	// 非递归中序
	public void noRecMidOrder(MyBinNode p) {
		Stack<MyBinNode> stack = new Stack<MyBinNode>();
		while (p != null) {
			while (p != null) {
				if (p.right != null)
					stack.push(p.right); // 当前结点右子结点入栈
				stack.push(p); // 当前结点入栈
				p = p.left;
			}
			p = stack.pop();
			while (!stack.empty() && p.right == null) {
				visit(p);
				p = stack.pop();
			}
			visit(p);
			if (!stack.empty())
				p = stack.pop();
			else
				p = null;
		}
	}

	// 非递归后序
	public void noRecAfterOrder(MyBinNode p) {
		MyBinNode q = p;
		Stack<MyBinNode> stack = new Stack<MyBinNode>();
		while (p != null) {
			// 左子树入栈
			for (; p.left != null; p = p.left)
				stack.push(p);
			// 当前结点无右子结点或右子结点已经输出
			while (p != null && (p.right == null || p.right == q)) {
				visit(p);
				q = p; // 记录上一个已输出结点
				if (stack.empty())
					return;
				p = stack.pop();
			}
			// 处理右子结点
			stack.push(p);
			p = p.right;
		}
	}

	public static void main(String[] args) {
		MyBinTree myBinTree = new MyBinTree();
		myBinTree.init();
		System.out.println("前序遍历");
		myBinTree.preOrder(myBinTree.getRoot());
		System.out.println("中序遍历");
		myBinTree.midOrder(myBinTree.getRoot());
		System.out.println("后序遍历");
		myBinTree.afterOrder(myBinTree.getRoot());
		System.out.println("非递归前序");
		myBinTree.noRecPreOrder(myBinTree.root);
		System.out.println("非递归后序");
		myBinTree.noRecAfterOrder(myBinTree.root);
	}

}

class MyBinNode {
	public char data;
	public MyBinNode left, right;

	public MyBinNode(char data, MyBinNode left, MyBinNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

}
