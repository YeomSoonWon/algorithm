package 실습_과제;

import java.util.Scanner;

public class Solution_2806_nQueen {
	static int[] row;
	static int ans;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1 ; tc < T+1 ; tc++) {
			N = sc.nextInt();
			row = new int[N];
			
			ans = 0; // 가능한 배치 수
			nQueen(0);
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}
	static boolean isPromising(int n) {
		for(int i = 0 ; i < n ; i++) {
			// 퀸의 위치가 가능한지 여부 검사.
			// 같은 열에 위치하거나 대각선에 위치한 경우 false
			if(row[i]==row[n] || Math.abs(row[i]-row[n]) == Math.abs(i-n)) {
				return false;
			}
		}
		return true;
	}
	static void nQueen(int n) {
		if(n==N) {
			ans += 1;
			return;
		}
		else {
			for(int i = 0 ; i < N ; i++) {
				row[n] = i; // n,i에 퀸 배치
				if(isPromising(n)) {
					nQueen(n+1);
				}
			}
		}
	}
}
