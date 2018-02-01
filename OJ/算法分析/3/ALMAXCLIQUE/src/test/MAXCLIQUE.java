package test;

import java.util.Arrays;
import java.util.Scanner;


/*


0 1 0 1 1
1 0 1 0 1
0 1 0 0 1 
1 0 0 0 1
1 1 1 1 0



*/
//最大团问题
public class MAXCLIQUE {
	private int[][] a;// 图的邻接矩阵
	private int n;// 顶点数
	private int x[];
	private int cn;// 当前已包含在顶点集中的顶点个数；
	private int rn;// 剩余顶点个数
	private int bestn;// 当前已找到的最优解包含的顶点个数。
	private final int INF = 0;

	public MAXCLIQUE(int[][] a, int n, int[] x) {
		this.a = a;
		this.n = n;
		this.x = x;
	}

	public void BACK_MAXCLIQUE_REC(int t) {
		if (t > n) {
			// 输出
			for (int i = 1; i <= n; i++) {
				System.out.print(x[i] + " ");
			}
			System.out.println();
			bestn = cn;
			return;
		}
		if (place(t)) {// 进入左子树
			x[t] = 1;
			cn++;
			BACK_MAXCLIQUE_REC(t + 1);
			cn--;
			rn = n - t;
		}
		if ((cn + rn) > bestn) {// 进入右子树
			x[t] = 0;
			BACK_MAXCLIQUE_REC(t + 1);
		}
	}

	public boolean place(int k) {
		for (int j = 1; j <= k - 1; j++) {
			if (x[j] == 1 && a[k][j] == INF)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] a;// 图的邻接矩阵
		int n;// 顶点数
		int x[];
		Scanner in = new Scanner(System.in);
		System.out.println("输入顶点数");
		n = in.nextInt();
		System.out.println("输入图的邻接矩阵");
		a = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a[i][j] = in.nextInt();
			}
		}
		x = new int[n + 1];
		MAXCLIQUE maxclique = new MAXCLIQUE(a, n, x);
		System.out.println("图的最大团为：");
		maxclique.BACK_MAXCLIQUE_REC(1);
	}

}
