package 실습_과제;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_7465_창용마을무리의개수 {
	static int[] p; // 관계의 대표를 저장할 배열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			int N = sc.nextInt(); // 사람(정점)의 수
			int M = sc.nextInt(); // 관계(간선)의 수
			
			int[][] rel = new int[M][2]; // 시작 정점, 끝 정점
			for(int i = 0 ; i < M ; i++) {
				rel[i][0] = sc.nextInt();
				rel[i][1] = sc.nextInt();
			}
			p = new int[N];
			for(int i = 0 ; i < N ; i++) {
				p[i] = i;
			}
			int[] rep = new int[p.length];
			for(int i = 0 ; i < rep.length ; i++) {
				rep[i] = findset(p[i]);
			}
			Arrays.sort(rep);
			System.out.println(Arrays.toString(rep));
			int cnt = 0;
			for(int i = 1 ; i < rep.length ; i++) {
				if(rep[i] != rep[i-1]) cnt++;
			}
			System.out.println(cnt);
		}
	}
	static int findset(int x) {
		if(x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}
}
