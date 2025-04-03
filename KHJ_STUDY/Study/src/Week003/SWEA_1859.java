package Week003;

import java.util.Scanner;

public class SWEA_1859 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			 int N = sc.nextInt();
			 int[] arr = new int[N];
			 for(int i = 0; i < N; i++) {
				 arr[i] = sc.nextInt();
			 }
			 // 누적되는 값은 단위가 너무 커져서 long으로
			 long sum = 0;
			 // 최대 카운트 계산
			 int cnt = N;
			 while(true) {
				 int max = 0;
				 // 최대값 찾기
				 for(int i = 0; i < N; i++) {
					 if(max < arr[i]) {
						 max = arr[i];
					 }
				 }
				 // 최대값을 만나면 중지하기위한 boolean 타입 변수
				 boolean A = false;
				 for(int i = 0; i < N; i++) {
					 // 반복하면서 최대값을 찾는다.
					 if(arr[i] == max) {
						 // true로 변경
						 A = true;
						 for(int j = 0; j <= i; j++) {
							 // arr[j]가 0이면 건너뛴다.
							 if(arr[j] == 0) {
								 continue;
							 }
							 // sum에 max를 뺀 값을 하나씩 더해준다.
							 sum += (max - arr[j]);
							 // arr[j] 를 0으로 바꿔준다.
							 arr[j] = 0;
						 }
					 }
					 if(A) {
						 // 최대값이였던 것을 0으로 바꿔준다.
						 
						 break;
					 }
				 }
				 int cnt2 = 0;
				 for(int i = 0; i < N; i++) {
					 if(arr[i] == 0) {
						 cnt2++;
					 }else {
						 // 순서대로 진행되면 최대값을 만날때마다 앞부분은 0이기 때문에 아니면 중지
						 break;
					 }
				 }
				 // 같아지면 while문 중지
				 if(cnt == cnt2) {
					 break;
				 }
			 }
			 System.out.println("#" + tc + " " + sum);
		}
	}
}
