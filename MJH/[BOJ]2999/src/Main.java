import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		
		//입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		br.close();
		
		// 약수중 가장 정사각형에 가까운 값 구하기
		int l = line.length();
		int C = 1;
		for(int i = 1 ; i*i <= l ; i++) {
			if(l % i ==0)
				C = i;
		}
		int R = l / C;
		String[][] msg = new String[R][C];
		
		// 입력받은 것 암호 배열에 넣기
		int idx = 0;
		for(int col = 0 ; col < C ; col ++) {
			for(int row = 0 ; row < R ; row ++) {
				msg[row][col] = String.valueOf(line.charAt(idx++));
			}
		}
		// 해독하기
		StringBuilder sb = new StringBuilder();
		for(int row = 0 ; row < R ; row ++) {
			for(int col = 0 ; col < C ; col++) {
				sb.append(msg[row][col]);
			}
		}
		System.out.println(sb.toString());
	}
}
