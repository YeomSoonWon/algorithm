package 실습_과제;

import java.util.Scanner;

public class Solution_7733_치즈도둑 {
	static int[][] ch;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1}; // 상하좌우
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1 ; tc < T+1 ; tc++) {
			int N = sc.nextInt(); // 치즈의 한변의 길이
			ch = new int[N][N];
			
			// 치즈 입력
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					ch[i][j] = sc.nextInt();
				}
			}
			int x = 1;
			int cnt = 0;
			int max = 1;
			while(x < 101) { // 100일 동안
				visited = new boolean[N][N];
				cnt = 0;
				eat(x);
				for(int i = 0 ; i < N ; i++) {
					for(int j = 0 ; j < N ; j++) {
						if(ch[i][j]!=0 && visited[i][j]==false) {
							cnt += remain(i,j);
						}
					}
				}
				if(max < cnt) max = cnt;
				x++;
			}
			sb.append("#"+tc+" "+max+"\n");
		}
		System.out.println(sb);
	}
	static void eat(int n) {
		for(int i = 0 ; i < ch.length ; i++) {
			for(int j = 0 ; j < ch.length ; j++) {
				if(ch[i][j]==n) ch[i][j] = 0;
			}
		}
	}
	static int remain(int r , int c) {
		int N = ch.length;
		visited[r][c] = true;
		for(int dir = 0 ; dir < 4 ; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && ch[nr][nc]!=0) {
				remain(nr,nc);
			}
		}
		return 1;
	}
}
