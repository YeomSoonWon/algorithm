package 실습_과제;

import java.util.Scanner;

public class Solution_5215 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			int N = sc.nextInt(); // 재료의 수
			int L = sc.nextInt(); // 제한 칼로리
			
			int[][] src = new int[N][2]; // 재료의 점수 칼로리 배열
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < 2 ; j++) {
					src[i][j] = sc.nextInt();
				}
			}
			int total_cal = 0;
			int total_score = 0;
			int ans = Integer.MIN_VALUE;
			for(int i = 0 ; i < (1<<N); i++) {
				total_cal = 0;
				total_score = 0;
				for(int j = 0 ; j < N ; j++) {
					if((i & (1<<j)) > 0) {
						total_cal += src[j][1];
						total_score += src[j][0];
					}
				}
				if(total_cal <= L) {
					if(ans < total_score) ans = total_score;
				}
			}
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}
}
