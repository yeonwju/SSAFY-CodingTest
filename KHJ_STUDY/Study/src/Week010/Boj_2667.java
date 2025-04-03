package Week010;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Boj_2667 {
	static int N; // 맵 크기
	static int[][] map; // 맵 배열
	static boolean [][] vis; // 방문 배열
	static int cnt; // 단지 방문 횟수를 계산하기 위한 변수
	
	static int[] dr = {-1,1,0,0}; // 델타
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		vis = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			String temp = sc.next(); // 한 줄로 입력 받기
			char[] tmp = temp.toCharArray(); // 배열로 저장
			for(int j = 0; j < N; j++) {
				map[i][j] = tmp[j] - 48;
			}
		}
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				cnt = 1; // 카운트 초기화
				if(map[i][j] == 1 && !vis[i][j]) {
					dfs(i,j); // dfs 시작
					stack.push(cnt); // 다 돌고나서 stack에 누적
				}
			}
		}
//		System.out.println(stack);
		int count = stack.size(); // 카운트에 스택의 크기 저장
		int[] arr = new int[count]; // 배열 생성
		for(int i = 0; i < count; i++) {
			arr[i] = stack.get(i);
		}
		Arrays.sort(arr); // 정렬
		System.out.println(count);
		for(int i = 0; i < count; i++) {
			System.out.println(arr[i]);
		}
		
	}
	static void dfs(int r, int c) {
		vis[r][c] = true; // 방문 체크
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr >= 0 && nc >= 0 && nr < N && nc < N) {
				if(map[nr][nc] == 1 && !vis[nr][nc]) {
					cnt++;
					dfs(nr,nc);
				}
			}
		}
	}
}
