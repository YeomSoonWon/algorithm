package 실습_과제;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1952_수영장_dp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc < T+1 ; tc++) {
			int[] price = new int[4]; // 1일, 1달, 3달, 1년 요금
			for(int i = 0 ; i < 4 ; i++) {
				price[i] = sc.nextInt();
			}
			int[] plan = new int[13]; // 1년간 월별 이용 계획
			for(int i = 1 ; i < 13 ; i++) {
				plan[i] = sc.nextInt();
			}
			// 각 월 별로 최소 비용을 계산하여 누적 최소 비용을 갱신.
			int[] ans = new int[13]; // 해당 월 까지의 최솟값 저장
			int day=price[0],month=price[1],month3 = price[2],year = price[3];
			for(int i = 1 ; i < 13 ; i++) {
				day = price[0]*plan[i] + ans[i-1]; // 1일 요금 + 전 달 까지의 최소값
				month = price[1] + ans[i-1]; // 1달 요금 + 전 달 까지의 최소값
				if(i>2) {
					month3 = price[2] + ans[i-3]; // 3달 요금 + 3달전까지의 최소값
				}
				year = price[3];
				int[] minPrice = new int[4];
				minPrice[0] = day;
				minPrice[1] = month;
				minPrice[2] = month3;
				minPrice[3] = year;
				Arrays.sort(minPrice);
//				System.out.print("minPrice"+" = ");
//				for(int j = 0 ; j < 4 ; j++) {
//					System.out.print(minPrice[j]+" ");
//				}System.out.println();
				ans[i] = minPrice[0];
//				System.out.print(ans[i]+" ");
			}
			sb.append("#"+tc+" "+ans[12]+"\n");
		}
		System.out.println(sb);
	}
}
