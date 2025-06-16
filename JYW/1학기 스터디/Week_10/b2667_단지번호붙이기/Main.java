package b2667_단지번호붙이기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static boolean[][] visited;
	static int[][] map;
	static int N;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static int cnt;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new int[N][N];
		
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String str = sc.next();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}//입력
		
		List<Integer> list = new ArrayList<>();
		
		cnt = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {//1이고 방문하지 않았다면
					dfs(i, j);//dfs 돌기
					list.add(cnt);
				}
				cnt = 1;//카운트 초기화
			}
		}//dfs 탐색
		
		Collections.sort(list, Comparator.naturalOrder());//리스트 오름차순 정렬
		
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
	}//main

	private static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];
			
			if(nr>=N || nc>=N || nr<0 || nc<0 || visited[nr][nc]) continue;
			
			if(map[nr][nc] == 1) {
				cnt++;//카운트 증가
				dfs(nr, nc);//다음 노드에서 dfs
			}
		}
		return;
	}
}
