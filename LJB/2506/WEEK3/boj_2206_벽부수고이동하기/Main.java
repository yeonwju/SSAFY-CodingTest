package boj_2206_벽부수고이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static char[][] map;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static class Info implements Comparable<Info>{
		int x;
		int y;
		int turn;
		boolean removable;
		
		public Info(int x, int y, int turn, boolean removable) {
			this.x = x;
			this.y = y;
			this.turn = turn;
			this.removable = removable;
		}

		@Override
		public int compareTo(Info o) {
			// 벽을 없앨 수 있는 경우를 먼저 수행하기 위해서 정렬 조건 설정
			if(this.removable == o.removable) {
				return this.turn - o.turn;
			} else if(this.removable){
				return -1;
			} else {
				return 1;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		// 해당 위치에 몇번만에 갔는지 확인하기 위해 int로 방문처리
		int[][] visited;
		visited = new int[N][M];
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
			
			for(int j=0; j<M; j++) {
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(0,0,1,true));
		visited[0][0] = 1;
		int result = Integer.MAX_VALUE;
		
		while(!pq.isEmpty()) {
			Info info = pq.poll();
			// 목표지점에 도착하더라도 더 낮은 비용으로 도달할 수 있는지 확인할 필요있음
			if(info.x == M-1 && info.y == N-1 && info.turn < result) {
				result = info.turn;
			}
			
			for(int i=0; i<4; i++) {
				int nx = info.x + dx[i];
				int ny = info.y + dy[i];
				int nturn = info.turn+1;
				// 지도 밖을 벗어나는 경우
				if(!bound(nx, ny)) {
					continue;
				}
				// 벽인데 벽을 제거할 수 없는 경우
				if(isWall(nx, ny) && !info.removable) {
					continue;
				}
				// 해당 좌표에 이전보다 적은 경로로 도착하는 경우에만
				if(visited[ny][nx] > nturn ) {
					visited[ny][nx] = nturn;
					pq.add(new Info(nx, ny, nturn, info.removable && !isWall(nx, ny) ? true : false));
				} 
			}
		}
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
	static boolean bound(int x, int y) {
		return x>=0 && y >=0 && x < M && y < N;
	}
	static boolean isWall(int x, int y) {
		return map[y][x] == '1';
	}
}
