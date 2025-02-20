import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= testcase; tc++) {
			String[] strArr = br.readLine().split(" ");
			
			StringBuilder sb = new StringBuilder();
			for(String str : strArr) {
				for(int i = str.length()-1 ; i >= 0 ; i--) {
					sb.append(str.charAt(i));
				}
				sb.append(" ");
			}
			System.out.println(sb.toString().trim());
		}

		br.close();
	}

}
