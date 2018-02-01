package saima;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class »œ¿œœÁ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int M, N;
		while (in.hasNext()) {
			N = in.nextInt();
			M = in.nextInt();
			if (N == 0 && M == 0) {
				break;
			}
			if (N < 1 || N > 1000 || M < 0 || M > (N * (N - 1) / 2)) {
				continue;
			} else {
				int[][] ralation = new int[1][2];
				HashMap<Integer, ArrayList<Integer>> relationMap = new HashMap<Integer, ArrayList<Integer>>();
				for (int i = 0; i < M; i++) {
					ralation[0][0] = in.nextInt();
					ralation[0][1] = in.nextInt();
					if (relationMap.get(ralation[0][0]) == null) {
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(ralation[0][1]);
						relationMap.put(ralation[0][0], list);
					} else {
						relationMap.get(ralation[0][0]).add(ralation[0][1]);
					}
					if (relationMap.get(ralation[0][1]) == null) {
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(ralation[0][0]);
						relationMap.put(ralation[0][1], list);
					} else {
						relationMap.get(ralation[0][1]).add(ralation[0][0]);
					}
				}

				if (relationMap.get(1) == null) {
					System.out.println(0);
				} else {
					HashSet<Integer> hasVisited = new HashSet<Integer>();
					HashSet<Integer> notVisited = new HashSet<Integer>();
					notVisited.addAll(relationMap.get(1));
					while (notVisited.size() > 0) {
						int num = notVisited.iterator().next();
						notVisited.remove(num);
						hasVisited.add(num);
						if (relationMap.get(num) != null) {

							notVisited.addAll(relationMap.get(num));
							notVisited.removeAll(hasVisited);
						}
					}
					if (hasVisited.contains(1)) {
						System.out.println(hasVisited.size() - 1);
					} else {
						System.out.println(hasVisited.size());
					}
				}
			}
		}
	}
}