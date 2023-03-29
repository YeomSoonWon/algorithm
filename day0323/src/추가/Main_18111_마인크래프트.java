package 추가;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main_18111_마인크래프트 {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int B = sc.nextInt();
		arr = new int[N*M];
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = sc.nextInt();
		}
		HashSet<Integer> hashSet = new HashSet<>();
		while(!isClear(arr)) {
			Arrays.sort(arr);
			
		}
	}
	static boolean isClear(int[] a) {
		int pivot = a[0];
		for(int i = 1 ; i < arr.length ; i++) {
			if(a[i]!=pivot) return false;
		}
		return true;
	}
}
