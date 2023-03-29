package graph;

import java.util.Scanner;

public class 그래프_01_인접행렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt(); // 정점의 개수
		int E = sc.nextInt(); // 간선의 개수
		
		int[][] adjArr = new int[V+1][V+1]; // 인접행렬
		
		// 간선 입력
		for(int i = 0 ; i < E ; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			
			adjArr[st][ed] = 1; // 유향 그래프라면 20번 라인은 필요 없다.
//			adjArr[ed][st] = 1; // 무향 그래프일때는 같이 작성해준다.
		}
		for(int i = 0 ; i < V+1 ; i++) {
			for(int j = 0 ; j < V+1 ; j++) {
				System.out.print(adjArr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
