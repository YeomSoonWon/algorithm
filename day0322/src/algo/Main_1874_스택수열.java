package algo;

import java.util.Scanner;
import java.util.Stack;

public class Main_1874_스택수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] n_arr = new int[n];
		int recent_value = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			int num = sc.nextInt();
			arr[i] = num;
			if(!st.isEmpty() && st.peek() == num) {
				n_arr[i] = st.pop();
				sb.append("-"+"\n");
			} else {
				for(int j = recent_value+1 ; j < num + 1 ; j++) {
					recent_value = st.push(j);
					sb.append("+"+"\n");
				}
				n_arr[i] = st.pop();
				sb.append("-"+"\n");
			}
		}
		boolean flag = true;
		for(int i = 0 ; i < n ; i++) {
			if(arr[i]==n_arr[i]) continue;
			else {
				flag = false;
				break;
			}
		}
		
		if(flag == true) {
			System.out.println(sb);
		}else {
			System.out.println("NO");
		}
	}
}
