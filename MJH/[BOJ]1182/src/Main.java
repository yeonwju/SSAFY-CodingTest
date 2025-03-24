import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int S;
	static int[] nums;
	static int cnt =0;
	static int used = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		nums = new int [N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		calc(0,0);
		
		System.out.println(cnt);
		
	}
	
	static void calc(int idx, int sum) {
		if(sum == S && idx == N && used != 0) {
			cnt++;
			return;
		}
		if(idx == N)
			return;
		used++;
		calc(idx+1, sum+nums[idx]);
		used--;
		calc(idx+1, sum);
	}
}
