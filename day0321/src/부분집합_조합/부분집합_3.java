package 부분집합_조합;

import java.util.Arrays;

public class 부분집합_3 {
	static String[]재료 = {"참치","우엉","삼겹살"};
	static int N = 3;
	static boolean[] sel; // 해당 요소 선택했다.
	public static void main(String[] args) {
		N = 3;
		sel = new boolean[N];
		
		powerset(0);
	}
	// 메소드를 작성할 때 최대한 파라미터를 심플하게.
	// idx : 해당 원소를 포함할 지 안할 지를 결정해야함.
	public static void powerset(int idx) {
		// base case : 재귀를 빠져 나갈 수 있는 조건
		// 모든 재료를 넣을지 / 말지 에 대한 판단이 끝남.
		if(idx==N) {
			String tmp ="";
			for(int i = 0 ; i < N ; i++) {
				if(sel[i])
					tmp+=재료[i];
			}
			System.out.println(tmp);
			return;
		}
		
		// recursive : 나 자신을 다시 호출하는 조건
		sel[idx] = true; // idx번째의 재료를 사용했음.
		powerset(idx+1); // 다음 재료를 고려한다.
		
		sel[idx] = false; // idx번째의 재료를 사용하지 않았다.
		powerset(idx+1); // 다음 재료를 고려한다.
	}
}
