package BOJ;

import java.util.Scanner;

public class Main_2064 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[][] network = new String[n][4];
		for(int i = 0 ; i < n ; i++) {
			String s = sc.next();
			network[i] = s.split(".");
		}
	}
}
