package s1289_원재의메모리복구하기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			char[] word = sc.next().toCharArray();
			int num = word.length;
			int cnt = 1;
			for(int i=0; i<num; i++) {
				if(word[i] == '1') {
					int index = i;
					for(int j=index; j<num-1; j++) {
						if(word[j] != word[j+1]) {
							cnt++;
						}
					}
					break;
				}
			}
			
			System.out.println("#"+t+" "+cnt);
		}//for문 끝
	}//main
}

