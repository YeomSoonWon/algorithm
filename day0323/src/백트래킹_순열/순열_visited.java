package 백트래킹_순열;

import java.util.Arrays;

public class 순열_visited {
	static int[] nums;
	static int N;
	static boolean[] visited;
	static int[] result;
	
	public static void main(String[] args) {
		nums = new int[] {0,1,2};
		N = nums.length;
		result = new int[N];
		visited = new boolean[N];
		
		perm(0);
	}
	
	public static void perm(int idx) {
		if(idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		// 모든 요소를 반복문을 통해 돌면서
		// 사용하지 않은 원소가 있다면 겨과에 넣고 사용했다고 표시도 하고
		// 다음 차례로 내려가 본다.
		for(int i = 0 ; i < N ; i++) {
			// 1. 원소를 사용했는지 체크
			if(visited[i]) continue;
			result[idx] = nums[i];
			visited[i] = true; // 해당 원소를 사용했다고 체크
			perm(idx+1);
			visited[i] = false; // 다시 원상복구
			
		}
	}
}
