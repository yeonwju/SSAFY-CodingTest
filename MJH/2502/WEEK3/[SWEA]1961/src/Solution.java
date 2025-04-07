import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int arrlen;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testcase; tc++) {
			arrlen = Integer.parseInt(br.readLine()); // 배열 크기
			arr = new int[arrlen][arrlen]; // 배열 선언
			for (int i = 0; i < arrlen; i++) { // 배열 값 초기화
				String[] line = br.readLine().split(" ");
				for (int j = 0; j < arrlen; j++) {
					arr[i][j] = Integer.parseInt(line[j]);
				}
			}
			int[][] t90 = turn90();
			int[][] t180 = turn180();
			int[][] t270 = turn270();
			//출력
			System.out.println("#"+tc);
			
			for(int i = 0 ; i < arrlen ; i ++) {
				StringBuilder sb = new StringBuilder();
				for(int j = 0 ; j < arrlen; j++) {
					sb.append(t90[i][j]);
				}
				sb.append(" ");
				for(int j = 0 ; j < arrlen; j++) {
					sb.append(t180[i][j]);
				}
				sb.append(" ");
				for(int j = 0 ; j < arrlen; j++) {
					sb.append(t270[i][j]);
				}
				System.out.println(sb.toString());
			}
			
			
		} // testcase }
		br.close();
	}

	static int[][] turn90() {
		int[][] tArr = new int[arrlen][arrlen]; // 배열 선언
		for (int i = 0; i < arrlen; i++) {
			for (int j = 0; j < arrlen; j++) {
				tArr[j][arrlen - 1 - i] = arr[i][j];
			}
		}
		return tArr;
	}
	
	static int[][] turn180() {
		int[][] tArr = new int[arrlen][arrlen]; // 배열 선언
		for (int i = 0; i < arrlen; i++) {
			for (int j = 0; j < arrlen; j++) {
				tArr[arrlen - 1 - i][arrlen -1 -j] = arr[i][j];
			}
		}
		return tArr;
	}
	
	static int[][] turn270() {
		int[][] tArr = new int[arrlen][arrlen]; // 배열 선언
		for (int i = 0; i < arrlen; i++) {
			for (int j = 0; j < arrlen; j++) {
				tArr[arrlen-1-j][i] = arr[i][j];
			}
		}
		return tArr;
	}
}