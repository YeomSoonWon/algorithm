package 실습_과제;

import java.util.Scanner;

public class Solution_1952_수영장_탐색 {
    static int[] plan = new int[13]; // 각 달의 이용 계획을 저장할 배열
    static int[] cost = new int[4]; // 이용권 가격을 저장할 배열
    static int minCost; // 가장 적은 비용

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            for (int i = 1; i <= 12; i++) {
                plan[i] = sc.nextInt();
            }
            for (int i = 0; i < 4; i++) {
                cost[i] = sc.nextInt();
            }

            // 초기화
            minCost = cost[3]; // 1년 이용권으로 초기화
            dfs(1, 0);

            sb.append("#" + tc + " " + minCost+"\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int month, int totalCost) {
        if (month > 12) { // 모든 달을 다 계산했을 때
            minCost = Math.min(minCost, totalCost); // 최소 비용 갱신
            return;
        }

        // 1일 이용권
        dfs(month + 1, totalCost + (plan[month] * cost[0]));
        // 1달 이용권
        dfs(month + 1, totalCost + cost[1]);
        // 3달 이용권
        dfs(month + 3, totalCost + cost[2]);

    }
}
