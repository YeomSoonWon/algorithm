package SWEA;

import java.util.Scanner;

public class Solution_보물상자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트케이스
		StringBuilder sb = new StringBuilder();
		for(int tc = 1 ; tc <= T ; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int rotate_num = N/4; // 회전 수
			String s = sc.next();
			char[] c = new char[s.length()];
			for(int i = 0 ; i < c.length ; i++) {
				c[i] = s.charAt(i);
			}
			int[] arr = new int[N];
			int idx = 0;
			for(int num = 0 ; num < rotate_num ; num++) {
				for(int i = 0 ; i < c.length ; i++) {
					int sum = 0;
					int f = rotate_num-1;
					for(int j = i ; j < i+rotate_num ; j++) {
						int n = chgInt(c[j])*(int)Math.pow(16, f--);
						sum += n;
					}
					arr[idx++] = sum;
					i += rotate_num-1;
				}
				char[] d = new char[c.length];
				for(int i = 0 ; i < d.length ; i++) {
					d[i] = c[i];
				}
				c[0] = c[c.length-1];
				for(int i = 1; i < c.length ; i++) {
					c[i] = d[i-1];
				}
			}
			// 내림차순 정렬
			order(arr);
			// 중복 갯수 확인
			int count = chkDbl(arr);
			// 중복제거 한 배열 생성.
			int[] nArr = new int[arr.length-count];
			nArr[0] = arr[0];
			for(int i = 1 ; i < nArr.length ; i++) {
				if(arr[i]!=arr[i-1]) {
					nArr[i] = arr[i];
				}
			}
			int ans = nArr[K-1];
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}
	// 내림차순 정렬
	static int[] order(int[] a) {
		for(int i = 0 ; i < a.length-1 ; i++) {
			for(int j = i+1 ; j < a.length ; j++) {
				if(a[i]<a[j]) {
					int tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		}
		return a;
	}
	// 정렬 후 중복확인
	static int chkDbl(int[] a) {
		int cnt = 0;
		for(int i = 0 ; i < a.length-1 ; i++) {
			if(a[i] == a[i+1]) {
				cnt++;
			}
		}
		return cnt;
	}
	// 문자 정수로 변환
	static int chgInt(char c) {
		if(c>=48 && c <= 57) { // 0~9이면 숫자로
			return c-48;
		}else { // A~F 이면 10~15로
			return c-55;
		}
	}
}
