package boj_1541_잃어버린괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static Queue<Character> queue;
	static int result;
	static boolean isPlus;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		queue = new LinkedList();
		result = 0;
		isPlus = true;
		for(int i=0; i<input.length(); i++) {
			char tmp = input.charAt(i);
			if(Character.isDigit(tmp)) {
				queue.add(tmp);
				continue;
			}
			calc();
			if(tmp == '-') {
				isPlus = false;
			}
		}
		calc();
		System.out.println(result);
	}
	static int getNum() {
		String num = "";
		while(!queue.isEmpty()) {
			num += queue.poll();
		}
		return Integer.parseInt(num);
	}
	static void calc() {
		int nnum = getNum();
		if(isPlus) {
			result += nnum;
		} else {
			result -= nnum;
		}
	}
}
