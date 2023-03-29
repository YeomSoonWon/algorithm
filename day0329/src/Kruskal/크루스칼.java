package Kruskal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 크루스칼 {
	static int[] p; // 대표를 저장할 배열
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt(); // V : 정점의 개수 0부터 시작 한다!
		int E = sc.nextInt(); // E : 간선의 수
		
		// 간선을 저장하기 위해서 클래스를 사용할 수 도 있지만
		// 배열을 이용해서 저장을 하겠다. 0 : 시작정점 / 1 : 끝정점 / 2 : 가중치
		int[][] edges = new int[E][3];
		
		for(int i = 0 ; i < E ; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		} // 입력 끝
		
//		for(int[] arr : edges) {
//			System.out.println(Arrays.toString(arr));
//		}
		
		// 크루스칼 1단계 : 간선을 정렬한다. (오름차순)
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		// 크루스칼 2단계 : V-1개의 간선을 뽑는데, 사이클이 발생안하는 친구들로만 뽑는다.
		p = new int[V];
		// make-set 하자. (나 자신을 대표로 초기화 하자.)
		for(int i = 0 ; i < V ; i++) {
			makeset(i);
		} // makeset 완료
		
		int ans = 0; // 최소비용을 저장
		int pick = 0; // 내가 선택한 간선의 수
		// 모든 간선을 순회 하면서 판단
		for(int i = 0 ; i < E ; i++) {
			// i번째의 간선을 뽑아 두 정점의 대표를 확인
			int x = edges[i][0];
			int y = edges[i][1];
			
			// x의 대표와 y의 대표가 다르다면 사이클이 아니다.
			// 고를 수 있다.
			if(findset(x) != findset(y)) {
				union(x, y);
				ans += edges[i][2];
				pick++;
			}
			
			if(pick == (V-1)) break;
		}
		System.out.println(ans);
	}
	
	static int findset(int x) {
//		if(x==p[x]) return x;
//		return findset(p[x]);
		
		// path compression
		if(x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}
	
	static void union(int x, int y) {
		p[findset(y)] = findset(x); // rank 고려 안하고 무조건 y를 x 밑으로
	}
	
	static void makeset(int x) {
		p[x] = x;
		// Rank는 따로 처리 하지 않는다.
	}
	
	static String input = "7 11\r\n" + 
			"0 1 32\r\n" + 
			"0 2 31\r\n" + 
			"0 5 60\r\n" + 
			"0 6 51\r\n" + 
			"1 2 21\r\n" + 
			"2 4 46\r\n" + 
			"2 6 25\r\n" + 
			"3 4 34\r\n" + 
			"3 5 18\r\n" + 
			"4 5 40\r\n" + 
			"4 6 51\r\n" + 
			"\r\n";
}
