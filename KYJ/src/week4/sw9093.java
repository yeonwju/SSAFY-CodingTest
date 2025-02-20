package week4;

import java.util.Scanner;

public class sw9093 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();

		for (int t = 0; t < n; t++) {
			String[] st = sc.nextLine().split(" ");
			for (int i = 0; i < st.length; i++) {
				// string이 가변일때는 StringBuilder 사용
				StringBuilder sb = new StringBuilder(st[i]); // reverse() 사용하여 뒤집음
				System.out.print(sb.reverse() + " ");
			}
		}
		System.out.println();
	}
}
