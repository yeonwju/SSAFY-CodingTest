import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N
		br.readLine();
		
		Map<String, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String token;
		while(st.hasMoreTokens()) {
			token = st.nextToken();
			map.put(token, map.getOrDefault(token, 0)+1);
		}
		
		StringBuilder sb = new StringBuilder();
		// M
		br.readLine();
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			token = st.nextToken();
			sb.append(map.getOrDefault(token, 0)).append(" ");
		}
		
		System.out.println(sb.toString().trim());
		br.close();
	}
}
