package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 그래프_02_인접리스트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt(); // 정점의 개수
		int E = sc.nextInt(); // 간선의 개수
		
		List<Integer>[] adjList = new ArrayList[V+1];
		
		for(int i = 0 ; i < V+1 ; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		// 간선 입력
		for(int i = 0 ; i < E ; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			
			// 유향 그래프라면 20번라인은 필요 없다.
			adjList[st].add(ed);
			// 무향 그래프일때 아래도 같이 작성을 해준다.
			adjList[ed].add(st);
		}
		
		for(int i = 0 ; i < V+1 ; i++) {
			Collections.sort(adjList[i]);
		}
	}
}
