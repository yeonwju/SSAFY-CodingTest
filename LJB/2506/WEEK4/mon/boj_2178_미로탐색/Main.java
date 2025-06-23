package boj_2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int x, y;
	static char[][] map;
	static boolean[][] visited;
	static Queue<int[]> queue;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		map = new char[y][x];
		visited = new boolean[y][x];
		
		for(int i=0; i<y; i++) {
			String row = br.readLine();
			map[i] =  row.toCharArray();
		}
		queue = new LinkedList<>();
		
		queue.add(new int[] {0,0,1});
		visited[0][0] = true;
		result = 0;
		while(!queue.isEmpty()) {
			int[] loc = queue.poll();
			int xx = loc[0];
			int yy = loc[1];
			int turn = loc[2];
			if(xx == x-1 && yy == y-1) {
				result = turn;
				break;
			}
			
			for(int i=0; i<4; i++) {
				int nx = xx + dx[i];
				int ny = yy + dy[i];
				
				if(bound(nx, ny) && !visited[ny][nx]) {
					queue.add(new int[] {nx, ny, turn+1});
					visited[ny][nx] = true;
				}
			}
		}
		System.out.println(result);
		
	}
	
	static boolean bound(int xx, int yy) {
		return xx >= 0 && yy >= 0 && xx< x && yy < y && map[yy][xx] == '1'; 
	}
}
