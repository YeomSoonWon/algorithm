package 실습_과제;

import java.util.Scanner;

public class Solution_점심식사시간 {
	static int[][] map; // 전체 맵 배열
	static int N; // 맵의 한 변의 길이.
	static int[][] entrance; // 계단 입구 행,열을 저장하는 배열
	static int entranceNum; // 계단 입구의 개수
	static int[][] people; // 사람들 위치 배열
	static int peopleNum; // 사람들 수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			entranceNum = 0;
			peopleNum = 0;
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j]!=1 && map[i][j]!=0) {
						entranceNum++;
					}else if(map[i][j] == 1) {
						peopleNum++;
					}
				}
			}
			
			people = new int[peopleNum][2]; // 사람 위치 배열
			entrance = new int[entranceNum][2]; // 계단 입구 위치 배열
			int idxE = 0;
			int idxP = 0;
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(map[i][j]!=1 && map[i][j]!=0) {
						entrance[idxE][0] = i;
						entrance[idxE][1] = j;
						idxE++;
					}else if(map[i][j] == 1) {
						people[idxP][0] = i;
						people[idxP][1] = j;
						idxP++;
					}
				}
			}
			
			int[][] peopleToEntrance = new int[peopleNum][entranceNum];
			int count[] = new int[entranceNum]; // 각 입구에 있는 사람의 수
			int countS[] = new int[entranceNum]; // 각 계단에 있는 사람의 수 (모두 3을 넘으면 안된다.)
			int complete = 0; // 다 내려간 사람의 수
			int time = 0; // 시간
			int[] dp = new int[];
			while(complete != peopleNum) {
				
			}
		}
	}
	// 사람 별로 각 entranceNum개의 입구 까지의 시간.
	static int[][] mvToStairs(int[][] p, int[][] e) {
		int[][] timeToEntrance = new int[p.length][e.length];
		// 0번째 사람부터 각 입구까지 가는데 걸리는 시간.
		for(int i = 0 ; i < p.length ; i++) {
			for(int j = 0 ; j < e.length ; j++) {
				int pr = p[i][0];
				int pc = p[i][1];
				int sr = e[j][0];
				int sc = e[j][1];
				timeToEntrance[i][j] = Math.abs(pr-sr) + Math.abs(pc-sc);
			}
		}
		return timeToEntrance;
	}
}
