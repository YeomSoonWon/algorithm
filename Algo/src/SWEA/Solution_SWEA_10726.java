package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_SWEA_10726 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int TC = sc.nextInt();
		
		for(int T = 1 ; T <= TC ; T++) {
			int N = sc.nextInt(); // 마지막 N개의 비트
			int M = sc.nextInt(); // 숫자 M
			int num = -1;
			int f = 0;
			while(num < M) {
				num = (int) Math.pow(2, f++);
			}
			f -= 1;
			int size = 0;
			if(f > N) size = f;
			else size = N; // 배열의 크기 지정.
			Queue<Integer> q = new LinkedList<>();
			int[] ans = new int[size];
			
			while(M > 1) {
				q.offer(M%2);
				M /= 2;
			}
			if(M==1) {
				q.offer(1);
			}else q.offer(0);
			
			for(int i = ans.length-1 ; i >=0 ; i--) {
				if(!q.isEmpty()) {
					ans[i] = q.poll();
				}
			}
			boolean flag = true;
			for(int i = ans.length-1 ; i>=ans.length-N ; i--) {
				if(ans[i] != 1) flag = false;
			}
			String s ="";
			if(flag == true) s = "ON";
			else s = "OFF";
			sb.append("#"+T+" "+s+"\n");
		}
		System.out.println(sb);
	}
}
