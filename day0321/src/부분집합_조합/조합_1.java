package 부분집합_조합;

import java.util.Arrays;

public class 조합_1 {
	// 재귀를 이용해서 조합을 만들어보자.
	static String[] 토핑 = {"상추", "패티", "토마토", "치즈"};
	static int N = 4;
	static int R = 2; // 문제에서 보통 주어진다.
	
	static String[] sel = new String[R]; // 내가 선택한 토핑
	
	public static void main(String[] args) {
		combination(0,0);
	}
	
	// idx : 내가 이번 깊이에서 고려할 재료!
	// sidx : 현재 뽑을 자리
	public static void combination(int idx, int sidx) {
		// base case
		if(sidx == R) { // 다 뽑았음.
			System.out.println(Arrays.toString(sel));
			return;
		}
		if(idx == N) { // 고려 다했음.
			return;
		}
		// recursive case
		sel[sidx] = 토핑[idx]; // sidx자리에 현재 보고있는 idx 토핑을 저장할래
		combination(idx+1, sidx+1); // 이번 재료 사용했고, 다음 재료 고려.
		combination(idx+1, sidx); // 이번 재료는 사용하지 않았고, 다음재료에서 고려.
	}
	
}
