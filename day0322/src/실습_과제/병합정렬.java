package 실습_과제;

import java.util.Arrays;

public class 병합정렬 {
	static int[] sortedArr;
	public static void main(String[] args) {
		int[] arr = {4, 47, 334, 23, 1, 6, 90, 12, 14, 51};
		sortedArr = new int[arr.length];
		mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(sortedArr));
	}
	static void mergeSort(int[] arr, int left, int right) {
		int mid = (left+right)/2;
		if(left < right) {
			mid = (left+right)/2;
			mergeSort(arr,left,mid);
			mergeSort(arr, mid+1, right);
			merge(arr, left, mid, right);
		}
	}
	static void merge(int[] arr, int left, int mid, int right) {
		int L = left;
		int R = mid + 1;
		int idx = left;
		while(L<=mid && R<=right) {
			if(arr[L]<=arr[R]) {
				sortedArr[idx++] = arr[L++];
			}
			else {
				sortedArr[idx++] = arr[R++];
			}
		}
		if(L<=mid) {
			for(int i = L ; i <= mid ; i++) {
				sortedArr[idx++] = arr[i];
			}
		} else {
			for(int j = R ; j <= right ; j++) {
				sortedArr[idx++] = arr[j];
			}
		}
		for(int i = left ; i <= right ; i++) {
			arr[i] = sortedArr[i];
		}
	}
}
