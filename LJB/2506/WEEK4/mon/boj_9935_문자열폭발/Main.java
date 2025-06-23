package boj_9935_문자열폭발;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		char[] target = br.readLine().toCharArray();
		int targetLen = target.length;

		Stack<Character> stack = new Stack<>();

		for (char c : input) {
			stack.push(c);

			if (stack.size() >= targetLen) {
				boolean flag = true;
				for (int i = 0; i < targetLen; i++) {
					if (stack.get(stack.size() - targetLen + i) != target[i]) {
						flag = false;
						break;
					}
				}

				if (flag) {
					for (int i = 0; i < targetLen; i++) {
						stack.pop();
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char c : stack) {
			sb.append(c);
		}

		System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");
	}
}