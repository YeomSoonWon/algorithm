package BOJ;

import java.util.Scanner;

public class Main_17143_낚시왕 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int M = sc.nextInt(); // 상어의 수
		int[][] shark = new int[M][5]; // 속력, 이동방향, 크기
		int[][] fishingSpot = new int[R][C];
		for(int i = 0 ; i < M ; i++) {
			shark[i][0] = sc.nextInt()-1; // 행
			shark[i][1] = sc.nextInt()-1; // 열
			shark[i][2] = sc.nextInt(); // 속력
			shark[i][3] = sc.nextInt(); // 이동방향
			shark[i][4] = sc.nextInt(); // 크기
			fishingSpot[shark[i][0]][shark[i][1]] = shark[i][4];
		}
		int t = 0; // 시간
		int total = 0; // 낚시왕이 잡은 물고기 수
		while(t < C) {
			// 땅과 가장 가까운 상어를 잡는다.
			for(int i = 0 ; i < R ; i++) {
				if(fishingSpot[i][t]!=0) {
					total+= fishingSpot[i][t];
					break;
				}
			}
			// 상어 이동
			for(int i = 0 ; i < M ; i++) {
				// 이동하기 전에 현재 위치를 먼저 0으로 만든다.
				int dir = shark[i][3];
				switch(dir) {
				case(1): // 위
					break;
				case(2): // 아래
					break;
				case(3): // 오른쪽
					break;
				case(4): // 왼쪽
					break;
				}
			}
			// 만약 한칸에 2마리 이상의 상어가 있다면 가장 큰 상어가 잡아먹음.
			// 낚시왕 한칸 이동
		}
	}
}
