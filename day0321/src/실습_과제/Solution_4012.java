package 실습_과제;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_4012 {
	static ArrayList<Integer> list;
	static int N;
	static int[][] sy; // 시너지 배열
	static int[] ig;
	static int[] idxA;
	static int[] idxB;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			N = sc.nextInt();
			sy = new int[N][N];
			list = new ArrayList<>();
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					sy[i][j] = sc.nextInt();
				}
			}
			ig = new int[N];
			for(int i = 0 ; i < N ; i++) {
				ig[i]=i;
			}
			idxA = new int[N/2]; // A식재료
			idxB = new int[N/2]; // B식재료
			// nCn/2 A식재료, B식재료 구성.
			// 각 조합의 경우 별로 A,B의 시너지 계산 후 차이 값
			// 조합 케이스 별로 진행하며 최소 차이 값 갱신
			comb(0,0);
			
			Object[] n = list.toArray();
			
			int[] ans = new int[n.length];
			for(int i = 0 ; i < n.length ; i++) {
				ans[i] = (int)n[i];
			}
			int min = Integer.MAX_VALUE;
			for(int i = 0 ; i < ans.length ; i++) {
				if(min>ans[i]) min = ans[i];
			}
			sb.append("#"+tc+" "+min+"\n\n");
		}
		System.out.println(sb);
	}
	static boolean chk(int[] arr, int n) {
		for(int i = 0 ; i < arr.length ; i++) {
			if(arr[i]==n) {
				return false;
			}
		}
		return true;
	}
	// 시너지 계산
	static int calSy(int[] arr) {
		int sum = 0;
		// 배열에서 크기가 2인 부분집합을 구하여 시너지 배열에서 찾아 더함.
		for(int i = 0 ; i < arr.length-1 ; i++) {
			for(int j = i+1 ; j < arr.length ; j++) {
				sum += sy[arr[i]][arr[j]] + sy[arr[j]][arr[i]];
			}
		}
		return sum;
	}
	
	static void comb(int idx, int sidx) {
		// base case
		if(sidx == N/2) { // A식재료 배열 완성.
			// 완성된 조합으로 시너지 계산.
			
			// 식재료B의 배열을 만들기 위한 인덱스 값 설정.
			int idxb = 0;
			// A식재료로 선택되지 않은 재료를 B식재료로 선택.
			for(int i = 0 ; i < N ; i++) {
				if(chk(idxA,i)) {
					idxB[idxb++] = i;
				}
			}
			int a = Math.abs(calSy(idxA)-calSy(idxB));
			list.add(a);
			return;
		}
		// recursive case
		for(int i = idx ; i < N/2+sidx+1 ; i++) {
			idxA[sidx] = ig[idx];
			comb(i+1, sidx+1);
		}
		
	}
}
