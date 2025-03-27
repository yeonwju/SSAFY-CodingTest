package week9;

import java.util.Scanner;

public class Baekjoon6603 {
	static int n;
	static int[] arr;
	static int[] Varr;
	static boolean[] check;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		while (true) {
			n = sc.nextInt(); //집합 S 개수
			
			if(n == 0) break; //0이 입력되면 테이스케이스 끝
 			
			arr = new int[n]; // 집합 정보
			check = new boolean[n]; // 방문 체크
			Varr = new int[6]; // 경우의 수 집합
			
			for(int i = 0; i < n; i++) { //집합 정보 담기
				arr[i] = sc.nextInt();
			}
			
			lotto(0, 0); 
			System.out.println();
		}

	}

	static void lotto(int depth, int start) {

		if (depth >= 6) { //깊이가 6이 되면 숫자 뽑기 중단
			for (int v : Varr) { // 로또 집합 출력
				System.out.print(v + " ");
			}
			System.out.println();
			return; // 끝내기
		}
		
		for(int i = start; i < n; i++) {
			if(check[i] == false) { //방문하지 않았을 때
				check[i] = true; // 방문함으로 바꾸고
				Varr[depth] = arr[i]; // 집함에 담기
				// + 1의 경우 함수에 전달할때만 값을 증가시키고 변수 값은 변화 없음(백 해야하므로 += 1 x)
				// += 1의 경우 변수 값이 변화함(앞에서부터 차례로 탐색하므로 변숙값 변화해도 ㅇ)
				lotto(depth + 1, start += 1);  //하나 담았으므로 깊이 +1, 오름차순이므로 시작 +1
				check[i] = false; // 돌아올때 방문하지 않음 표시로 다시 바꾸기
			}
		}
	}
}
