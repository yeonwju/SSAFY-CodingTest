import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		StringBuilder sb = new StringBuilder();
		for(int i = 2; i <= N ; i++) {
			if(visited[i])
				continue;
			if(i >= M)
				sb.append(i).append("\n");
			int k = 2;
			while(true) {
				int j = i*k;
				if(j > N)
					break;
				k++;
				if(visited[j])
					continue;
				visited[j] = true;
			}
		}
		System.out.println(sb);
	}
}
