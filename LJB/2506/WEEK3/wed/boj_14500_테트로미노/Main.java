package boj_14500_테트로미노;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int max = 0;

    // 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(j, i, 1, map[i][j]);
                visited[i][j] = false;
                chkFck(i, j); 
            }
        }

        System.out.println(max);
    }

    static void dfs(int x, int y, int cnt, int sum) {
        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (bound(nx, ny) && !visited[ny][nx]) {
                visited[ny][nx] = true;
                dfs(nx, ny, cnt + 1, sum + map[ny][nx]);
                visited[ny][nx] = false;
            }
        }
    }

    static void chkFck(int y, int x) {
        int hand = map[y][x];
        for (int i = 0; i < 4; i++) {
            int temp = hand;
            boolean flag = true;
            for (int j = 0; j < 3; j++) {
                int d = (i + j) % 4;
                int nx = x + dy[d];
                int ny = y + dx[d];

                if (!bound(nx, ny)) {
                    flag = false;
                    break;
                }
                temp += map[ny][nx];
            }
            if (flag) {
                max = Math.max(max, temp);
            }
        }
    }
    
    static boolean bound(int x, int y) {
    	return x>=0&&y>=0&&x<M&&y<N;
    }
}