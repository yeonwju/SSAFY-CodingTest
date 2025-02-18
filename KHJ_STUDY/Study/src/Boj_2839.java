import java.util.Arrays;
import java.util.Scanner;

public class Boj_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0; // 봉지 수
		
		int[] arr = new int[500]; // 최소값을 찾기위한 저장용 배열
		int nullcnt = 0; // 위 배열 카운트
		 
		// 처음 입력받은 숫자를 5로 나눴을때 나머지가 없으면 최소봉투 개수
		// 바로 카운트 출력
		if(N % 5 == 0) {
			cnt = N / 5;
			System.out.println(cnt);
		}else {
			int a = N / 5; // 최대 횟수만큼 반복해야하니 횟수 지정
			
			// 0부터 몫까지 반복
			for(int i=0;i<=a;i++) {
				cnt = 0;
				// temp는 반복문이 진행될때마다 5씩 줄어드는 값
				/*
				 * ex) N == 11
				 * i = 0 / N = 11
				 * i = 1 / N = 6
				 * i = 2 / N = 1;
				 */
				int temp = N - i*5;
				
				// 해당 값을 3으로 나눈뒤 나머지가 0이면 i와 temp의 몫을
				// cnt에 저장
				if(temp % 3 == 0) {
					/*
					 * N = 18
					 * cnt = 0 + 6
					 * cnt = 3 + 1
					 * cnt에 최소 값은 4
					 */
					cnt = i + (temp / 3);
					arr[nullcnt] = cnt;
					nullcnt++;
				}
			}
			// 최소 값 출력
			if(arr[0] == 0) {
				System.out.println(-1);
			}else {
				int min = arr[0];
				for(int i=1;i<arr.length;i++) {
					if(arr[i] < min && arr[i] != 0) {
						min = arr[i];
					}else {
						cnt = min;
						System.out.println(cnt);
						break;
					}
				}
			}
		}
	}
}
