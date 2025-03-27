package b3986_좋은단어;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			Stack<Character> stack = new Stack<>();
			
			String str = br.readLine();
			int l = str.length();
			char[] word = new char[l];
			
			for(int j=0; j<l; j++) {
				word[j] = str.charAt(j);
			}
			
			for(int j=0; j<l; j++) {
				if(stack.isEmpty()) {
					stack.push(word[j]);
				}
				else if(!stack.isEmpty() && stack.peek() == word[j]) {
					stack.pop();
				}else {
					stack.push(word[j]);
				}
			}
			
			if(stack.isEmpty()) {
				ans++;
			}
			
			
		}
		System.out.println(ans);
		
		
	}
}
