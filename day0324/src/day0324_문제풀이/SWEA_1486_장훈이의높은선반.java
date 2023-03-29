package day0324_문제풀이;

import java.util.Scanner;

public class SWEA_1486_장훈이의높은선반 {
	static int N, B, ans; // N : 점원의 수 1 ~ 20 , B : 선반의 높이
	static int[] H; // 점원들의 키를 저장할 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			H = new int[N];

			for (int i = 0; i < N; i++) {
				H[i] = sc.nextInt();
			} // 입력 끝

//			ans = Integer.MAX_VALUE;
			ans = 987654321;

			// 비트마스킹 방식으로 풀어볼거에요! (for문 2개) / 허유정 (서울5반) 유일 채팅
			// 1. for문 (모든 부분집합을 돌아보겠다.)
			for (int i = 0; i < 1 << N; i++) {
				// 2. i라고 하는것이 부분집합인건 알겠어! 그런데 어떤 점원들을 데리고 탑을 쌓았니?
				int sum = 0;
				for (int j = 0; j < N; j++) {
					if((i & (1<<j)) != 0)
						sum += H[j];
				}//탑 다 쌓았다.1!!!
				if(sum >= B && sum < ans) {
					ans = sum;
				}
//				if(sum >= B ) {
//					ans = Math.min(ans, sum);
//					ans = sum < ans ? sum:ans;
//				}
			}
			System.out.println("#"+tc+" "+(ans-B));

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} // tc
	}// main
}// class
