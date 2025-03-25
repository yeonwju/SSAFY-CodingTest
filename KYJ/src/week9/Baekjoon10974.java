package week9;

import java.util.Scanner;

public class Baekjoon10974 {
	
	static int n; //n값
	static int arr[]; //배열
	static boolean check[]; //방문 확인
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt(); // n값
		arr = new int[n]; //값 저장
		check = new boolean[n+1]; //방문 유무 확인
		
		ch(0);
	}
	
	static void ch(int idx) {
		
		if(idx >= n){
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <=n; i++) {
			if(check[i] == false) {
				check[i] = true;
				arr[idx] = i;
				ch(idx + 1);
				check[i] = false;
			}
		}	
	}
//	단계	idx	arr 상태	check 상태	동작
//	1	0	[_, _, _]	[F, F, F, F]	시작
//	2	1	[1, _, _]	[F, T, F, F]	1 선택
//	3	2	[1, 2, _]	[F, T, T, F]	2 선택
//	4	3	[1, 2, 3]	[F, T, T, T]	3 선택 → 출력: 1 2 3
//	5	2	[1, 2, _]	[F, T, T, F]	3 백트래킹
//	6	2	[1, 3, _]	[F, T, F, T]	3 선택
//	7	3	[1, 3, 2]	[F, T, T, T]	2 선택 → 출력: 1 3 2
//	8	1	[1, _, _]	[F, T, F, F]	3 백트래킹
//	9	1	[2, _, _]	[F, F, T, F]	2 선택
//	10	2	[2, 1, _]	[F, T, T, F]	1 선택
//	11	3	[2, 1, 3]	[F, T, T, T]	3 선택 → 출력: 2 1 3
//	12	2	[2, _, _]	[F, F, T, F]	1 백트래킹
//	13	2	[2, 3, _]	[F, F, T, T]	3 선택
//	14	3	[2, 3, 1]	[F, T, T, T]	1 선택 → 출력: 2 3 1
//	15	1	[2, _, _]	[F, F, T, F]	3 백트래킹
//	16	1	[3, _, _]	[F, F, F, T]	3 선택
//	17	2	[3, 1, _]	[F, T, F, T]	1 선택
//	18	3	[3, 1, 2]	[F, T, T, T]	2 선택 → 출력: 3 1 2
//	19	2	[3, _, _]	[F, F, F, T]	1 백트래킹
//	20	2	[3, 2, _]	[F, F, T, T]	2 선택
//	21	3	[3, 2, 1]	[F, T, T, T]	1 선택 → 출력: 3 2 1
//	22	0	[_, _, _]	[F, F, F, F]	모든 경우 탐색 완료
}
