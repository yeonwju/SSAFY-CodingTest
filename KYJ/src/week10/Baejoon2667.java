package week10;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Baejoon2667 {
	
	static int[][] arr; //지도 정보
	static boolean[][] check; //방문 확인
	static int count; //단지 
	static int[] dc; //상하좌우 탐색
	static int[] dr; //상하좌우 탐색
	static int n; //지도 n
	static int[] result; //단지별 개수
	
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		n = sc.nextInt(); // 지도 n
		arr = new int[n][n]; //지도 정보
		check = new boolean[n][n]; // 방문 체크
		result = new int[25*25]; //단지별 개수
		count = 0; //단지 번호 
		dc = new int[]{-1, 1, 0, 0}; //상하좌우 탐색
		dr = new int[]{0, 0, -1, 1}; //상하좌우 탐색
		
		//지도 정보
		for(int i = 0; i < n; i++) {
			String tmp =  sc.next();
			for(int j = 0; j < n; j++) {
				arr[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!check[i][j] && arr[i][j] == 1) { //집이 존재하는 곳, 아직 방문하지 않은 곳
					count++; //단지 번호 +1 갱신
					house(i, j); //단지 범위 탐색
				}
			}
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		System.out.println(count); //단지 번호 최대값
		for(int i = 1; i <= count; i++) { //
			pq.add(result[i]);
		}
		for(int i = 1; i <= count; i++) { //오름차순 출력
			System.out.println(pq.poll());
		}
	}
	
	// 집 단지 찾기
	private static void house(int x, int y) {
		
		check[x][y] = true; //방문 체크
		result[count]++; //해당 단지 번호 집 개수 ++
		
		for(int i = 0; i < 4; i++) { //상하좌우 탐색
			int nx = x + dr[i];
			int ny = y + dc[i];
			if(nx >= 0 && nx <n && ny >= 0 && ny < n) {	//인덱스 오류
			if(!check[nx][ny] && arr[nx][ny] == 1) { //방문하지 않고 집이 존재하는 곳이라면
					house(nx, ny); //계속 탐색
				}
			}
		}
	}
}