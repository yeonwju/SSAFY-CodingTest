import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	
	public static void main(String[] args) throws IOException {
		int [] cards = new int [20000001];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			cards[Integer.parseInt(st.nextToken())+10000000]++;
		}
		br.readLine();
		StringBuilder sb= new StringBuilder();
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			sb.append(cards[Integer.parseInt(st.nextToken())+10000000]).append(" ");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}
}
