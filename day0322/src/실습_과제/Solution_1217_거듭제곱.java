package 실습_과제;

import java.util.Scanner;

public class Solution_1217_거듭제곱 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i <= 10 ; i++) {
			int tc = sc.nextInt();
			int s = sc.nextInt();
			int n = sc.nextInt();
			sb.append("#"+tc+" "+pow(s,n)+"\n");
		}
		System.out.println(sb);
	}
	static int pow(int a, int b) {
		if(b==1) return a;
		
		int num = pow(a, b/2);
		if(b%2==0) return num*num;
		return num*num*a;
	}
}
