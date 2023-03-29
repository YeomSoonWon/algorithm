package day0322_분할정복;

public class 분할정복04_이진검색_재귀 {
	static int[] arr;
	static int key;
	public static void main(String[] args) {
		// 정렬된 상태라고 가정.
		arr = new int[] { 2, 4, 6, 8, 9, 17, 28 };
		key = 6;
		
		System.out.println(binarySearch(0, arr.length-1));
		
	}
	// 이진 검색을 하는 이유는
	// 이것이 이안에 들었나(Boolean) / 들었다면 어디에 들었나(int)
	// 인자값으로 무엇을 들고가야하나(경계의 시작점과 끝점을)
	public static boolean binarySearch(int st, int ed) {
		// 기저조건(못찾은 경우)
		if(st > ed) return false;
		
		int mid = (st + ed) / 2; // 정수 값.
		
		// 같다면
		if(arr[mid] == key) return true;
		// 크다면 (왼쪽구간으로)
		else if(arr[mid] > key) return binarySearch(st, mid-1);
		// 작다면 (오른쪽 구간으로)
		else return binarySearch(mid+1, ed);
	}
}
