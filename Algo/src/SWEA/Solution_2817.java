package SWEA;

import java.util.Scanner;

public class Solution_2817 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] arr = new int[N];
			for(int i = 0 ; i < arr.length ; i++) {
				arr[i] = sc.nextInt();
			}
			int total = 0;
			int count = 0;
			for(int i = 0 ; i < (1<<N); i++) {
				total = 0;
				for(int j = 0 ; j < N ; j++) {
					if((i & (1<<j)) > 0) {
						total += arr[j];
					}
				}
				if(total == K) count++;
			}
			sb.append("#"+tc+" "+count+"\n");
		}
		System.out.println(sb);
	}
}
