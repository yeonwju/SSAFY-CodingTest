package Week4;

import java.util.Scanner;

public class SWEA_11315 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			// 판만들기
			char[][] arr = new char[N][N];
			for(int i = 0; i < N; i++) {
				arr[i] = sc.next().toCharArray();
			}
			// 위, 오른쪽 위 대각, 오른쪽, 오른쪽 아래 대각
			int[][] xy = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}};
			// Yes No 판단
			boolean flag = false;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					// o일때만 확인
					if(arr[i][j] == 'o') {
						// 델타탐색
						for(int k = 0; k < 4; k++) {					
							int cnt = 0;
							// 5번 반복하면서 오목 확인
							for(int l = 0; l < 5; l++) {
								// x에 i + 델타증가값 / y에 j + 델타증가값
								int x = i + (xy[k][0] * l);
								int y = j + (xy[k][1] * l);
								// x와 y가 인덱스 범위 안에 있으면서 해당 위치가 o면 cnt 증가
								if(0 <= x && x < N && 0 <= y && y < N && arr[x][y] == 'o') {
									cnt++;
								}else {
								// 한번이라도 안맞으면 더 볼 필요 없으니 멈춤
									break;
								}
							}
							// 카운트가 5라면 flag를 true로 만들고 중지
							if(cnt == 5) {
								flag = true;
								break;
							}
						}
					}
				}
			}
	 		System.out.print("#" + tc);
	 		if(flag) {
	 			System.out.print(" YES");
	 		}else {
	 			System.out.print(" NO");
	 		}
	 		System.out.println();
		}
		
	}
}
