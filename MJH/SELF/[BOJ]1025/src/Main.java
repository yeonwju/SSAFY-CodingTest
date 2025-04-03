import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] matrix;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new int[N][M];
		String line;
		for (int row = 0; row < N; row++) {
			line = br.readLine();
			for (int col = 0; col < M; col++) {
				matrix[row][col] = line.charAt(col) - '0';
			}
		}
		findSosu();
		System.out.println(sosu);
	}
	
	
	static boolean[] sosuCandidate;
	static List<Integer> sosu = new ArrayList<>();
	static void findSosu() {
		int bigger = Math.max(N, M);
		int k = 1;
		int max = 1;
		while(true) {
			if(k > bigger)
				break;
			max *= 10;
			k++;
		}
		
		sosuCandidate = new boolean[k]; // = k+1
		for(int i = 2 ; i <= max ; i++) {
			if(sosuCandidate[i])
				continue;
			sosuCandidate[i] = true;
			sosu.add(i);
			k = 2; // k 재사용
			while(true) {
				int gob = k * i;
				k++;
				if(gob > max)
					break;
				sosuCandidate[gob] = true;
			}
		}
	}
}
