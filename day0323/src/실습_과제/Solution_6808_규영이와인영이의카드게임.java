package 실습_과제;

import java.util.Scanner;

public class Solution_6808_규영이와인영이의카드게임 {
	static int[] iy;
	static int[] gy;
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1 ; tc < T+1 ; tc++) {
			gy = new int[9];
			iy = new int[9]; // 규영이와 인영이가 가지고 있는 카드
			
			for(int i = 0 ; i < 9 ; i++) {
				gy[i] = sc.nextInt();
			}
			int idx = 0;
			for(int i = 1; i <= 18 ; i++) {
				if(chk(gy,i)) {
					iy[idx++] = i;
				}
			}
			int total = 362880; // 전체 경우의 수(9!)
			count = 0;
			perm(0);
			sb.append("#"+tc+" "+count+" "+(total-count)+"\n");
		}
		System.out.println(sb);
	}
	// 인영이의 카드들
	static boolean chk(int[] arr, int a) {
		for(int i = 0 ; i < arr.length ; i++) {
			if(arr[i]==a) return false;
		}
		return true;
	}
	// 규영이가 이긴경우 1, 비긴 경우 0, 진 경우 -1
	static int play(int[] a, int[] b) {
		int aScore = 0;
		int bScore = 0;
		for(int i = 0 ; i < 9 ; i++) {
			if(a[i] > b[i]) aScore += (a[i]+b[i]);
			else if(b[i] > a[i]) bScore += (b[i]+a[i]);
		}
		if(aScore > bScore) return 1;
		else if(bScore > aScore) return -1;
		else return 0;
	}
	public static void swap(int a, int b) {
		int tmp = iy[a];
		iy[a] = iy[b];
		iy[b] = tmp;
	}
	public static void perm(int idx) {
		// 기저조건
		if(idx == 9) {
			if(play(gy,iy)==1) count++; // 규영이가 이긴경우 count 1증가.
			return;
		}
		// 재귀조건
		for(int i = idx ; i < 9 ; i++) {
			swap(i, idx);
			perm(idx+1);
			swap(i, idx);
		}
	}
}
