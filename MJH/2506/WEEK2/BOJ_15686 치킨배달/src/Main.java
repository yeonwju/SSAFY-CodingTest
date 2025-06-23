import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] matrix;
	static Loc[] stores;
	static Loc[] selected;
	static int[][][] dist;
	static int answer = Integer.MAX_VALUE;

	static class Loc {
		int r, c;

		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new int[N][N];
		selected = new Loc[M];

		int num;
		Queue<Loc> storesQ = new LinkedList<>();
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				num = Integer.parseInt(st.nextToken());
				matrix[r][c] = num;
				if (num == 2) {
					storesQ.add(new Loc(r, c));
				}
			}
		}
		br.close();
		int size = storesQ.size();
		stores = new Loc[size];
		dist = new int[N][N][size];
		for (int i = 0; i < size; i++) {
			stores[i] = storesQ.poll();
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					dist[r][c][i] = Math.abs(r - stores[i].r) + Math.abs(c - stores[i].c);
				}
			}
		}
		
		selectStore(0, 0);
		System.out.println(answer);

	}

	public static void selectStore(int idx, int depth) {
	    if (depth == M) {
	        count();
	        return;
	    }
	    if (idx == stores.length) return;

	    selected[depth] = stores[idx];
	    selectStore(idx + 1, depth + 1); // 선택
	    selectStore(idx + 1, depth);     // 선택 안 함
	}


	public static void count() {
	    int sum = 0;

	    for (int r = 0; r < N; r++) {
	        for (int c = 0; c < N; c++) {
	            if (matrix[r][c] == 1) {
	                int min = Integer.MAX_VALUE;
	                for (int i = 0; i < M; i++) {
	                    Loc store = selected[i];
	                    // selected[i]는 stores에서 온 거니까, stores의 index를 찾아야 함
	                    for (int j = 0; j < stores.length; j++) {
	                        if (store.r == stores[j].r && store.c == stores[j].c) {
	                            min = Math.min(min, dist[r][c][j]);
	                        }
	                    }
	                }
	                sum += min;
	            }
	        }
	    }

	    // 전역 최소값 갱신
	    answer = Math.min(answer, sum);
	}

}
