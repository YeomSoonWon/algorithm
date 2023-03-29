package 실습_과제;

import java.util.Arrays;

public class NextPermutation {
	public static void main(String[] args){
		int[] arr = {5,2,3,1,4};
		Arrays.sort(arr);
		do {
			System.out.println(Arrays.toString(arr));
				}
		while(np(arr));
		}

	static boolean np(int numbers[]) {
		int N = numbers.length;
		int i = N - 1;
		// 뒤에서부터 탐색하여 numbers[i] > numbers[i-1]인 가장 큰 i값 찾기
		while(i > 0 && numbers[i-1] >= numbers[i]) {
			i--;
		}
			
		if(i == 0) return false; // 역순으로 완성되어 다음 순열이 존재하지 않음.
			
		int j = N-1;
		// numbers[j]>numbers[i-1]인 j중 가장 큰 j를 구하기 위해 뒤에서 부터 탐색.
		while(numbers[i-1] >= numbers[j]) {
			j--;
		}
		// i-1에 해당하는 원소와 j번째 원소 swap
		swap(numbers,i-1, j);
			
		int k = N-1;
		// i이후로 배열의 끝까지 순서 뒤집기.
		while(i < k) {
			swap(numbers, i, k);
			i++;
			k--;
		}
		return true;
	}
	static void swap(int numbers[], int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
