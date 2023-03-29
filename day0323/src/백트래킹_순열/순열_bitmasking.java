package 백트래킹_순열;

import java.util.Arrays;

public class 순열_bitmasking {
	static int[] nums;
	static int N;
	static int[] result;
	
	public static void main(String[] args) {
		nums = new int[] {0,1,2};
		N = nums.length;
		result = new int[N];

		perm(0,0);
	}
	// idx : 현재 판단하고 있는 위치
	// visited: 사용한 원소를 기록하기 위한 정수
	public static void perm(int idx, int visited) {
//		if(visited ==(1<<N)-1)
		if(idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		// 모든 원소를 돌면서 판단
		for(int i = 0 ; i < N ; i++) {
			// 현재 내가 i번째 원소를 사용했다면 continue
			if((visited & (1<<i)) != 0) continue;
			
			result[idx] = nums[i]; // 결과 저장.
			perm(idx+1, visited | (1<<i));
		}
	}
}
