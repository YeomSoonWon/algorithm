package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그래프_03_간선배열 {
	static class Edge{
		int st, ed;
		
		public Edge(int st, int ed) {
			this.st = st;
			this.ed = ed;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		Edge[] edges = new Edge[E];
		List<Edge> edges2 = new ArrayList<>();
		
		int[][] edges3 = new int[E][2]; // [i][0] : 시작정점, [i][1] : 끝정점
		
		for(int i = 0 ; i < E ; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			
			edges[i] = new Edge(st,ed);
		}
	}
}
