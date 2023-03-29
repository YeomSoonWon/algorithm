package 실습_과제;

import java.util.Arrays;

// Hoare-Partition 알고리즘
public class 퀵정렬 {
	public static void main(String[] args) {
		int[] arr = {4, 47, 334, 23, 1, 6, 90, 12, 14, 51};
		quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	static void quickSort(int[] a, int l, int r) {
		if(l<r) {
			int pivot = HoarePartition(a, l, r);
			quickSort(a,l,pivot-1);
			quickSort(a,pivot+1,r);
		}
	}
	static int HoarePartition(int[] arr, int left, int right){
		int pivot = arr[left];
		int L = left + 1;
		int R = right;
		while(L<=R) {
			while(L<=R && arr[L]<=pivot) {
				L++;
			}
			while(arr[R]>pivot) {
				R--;
			}
			if(L<R) {
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		int tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;
		return R;
	}
	
}
