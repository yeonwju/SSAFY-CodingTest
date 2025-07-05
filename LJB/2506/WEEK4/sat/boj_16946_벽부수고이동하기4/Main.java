package boj_16946_벽부수고이동하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, M, key = 2, cnt;
	static int[][] map;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static Map<Integer, Integer> sizeMemo = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = row.charAt(j) - '0';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					cnt = 1;
					map[i][j] = key;
					dfs(j, i);
					sizeMemo.put(key++, cnt);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					Set<Integer> usedKey = new HashSet<>();
					int sum = 1;
					for (int d = 0; d < 4; d++) {
						int nx = j + dx[d];
						int ny = i + dy[d];
						if (bound(nx, ny) && map[ny][nx] > 1) {
							int group = map[ny][nx];
							if (usedKey.add(group)) {
								sum += sizeMemo.get(group);
							}
						}
					}
					sb.append(sum % 10);
				} else {
					sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	static void dfs(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (bound(nx, ny) && map[ny][nx] == 0) {
				map[ny][nx] = key;
				cnt++;
				dfs(nx, ny);
			}
		}
	}

	static boolean bound(int x, int y) {
		return x >= 0 && y >= 0 && x < M && y < N;
	}
}