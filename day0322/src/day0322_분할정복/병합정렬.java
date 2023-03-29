package day0322_분할정복;

public class 병합정렬 {
	static int[] sortedArr;
	public static void main(String[] args) {
		
	}
	static void mergeSort(int[] arr, int left, int right) {
		int mid = 0;
		if(left < right) {
			mid = (left+right)/2;
			mergeSort(arr,left,right);
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
				
			}
		}
	}
}
