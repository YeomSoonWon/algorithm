package 백트래킹_순열;

import java.util.Arrays;

public class 순열_swap {
	static int[] nums; // 배열
	static int N; // 원소 수
	
	public static void main(String[] args) {
		nums = new int[] {0,1,2};
		N = nums.length;
		
		perm(0);
	}
	// swap 메서드
	// 바꿀 인덱스 2개가 인자로 넘어와야 한다.
	// static 하게 배열을 선언하지 않았다면 배열까지 인자로 같이 넘겨줘야 한다.
	public static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
	//  현재 판단하는 위치 idx
	public static void perm(int idx) {
		// 기저조건
		if(idx == N) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		// 재귀조건
		for(int i = idx ; i < N ; i++) {
			swap(i, idx);
			perm(idx+1);
			swap(i, idx); // 다시 원래 상태로 복구하는 과정이 필요하다.
		}
	}
}
