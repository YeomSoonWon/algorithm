package SWEA;

import java.util.Scanner;

// lower bound
public class Solution_1486_장훈이의높은선반 {
	static int N, B, ans; // N : 점원의 수 (1~20), B : 선반의 높이
	static int[] H; // 점원들의 키를 저장할 배열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1 ; t < T+1 ; t++) {
			N = sc.nextInt(); // 점원의 수
			B = sc.nextInt(); // 선반의 높이
			H = new int[N];
			int S = 0;
			for(int i = 0 ; i < H.length ; i++) {
				H[i] = sc.nextInt();
				S += H[i];
			}//입력끝
			
			ans = Integer.MAX_VALUE;
			
			//비트마스킹 방식으로(for문 2개)
			// 1. for문(모든 부분집합을 돌아보겠다.)
			for(int i = 0 ; i < (1<<N) ; i++) {
				//2. i라고 하는것이 부분집합이며 어떤 점원들을 데리고 탑을 쌓았나
				int sum = 0;
				for(int j = 0 ; j < N ; j++) {
					if((i&(1<<N)) !=0) {
						sum += H[j];
					}// 탑 다 쌓았다.
					if(sum>=B && sum < ans) {
						ans = sum;
					}
				}
				
			}
			
		}//tc
	}//main
}//class
