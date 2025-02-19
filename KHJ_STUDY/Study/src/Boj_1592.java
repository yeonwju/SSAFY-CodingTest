import java.util.Arrays;
import java.util.Scanner;

public class Boj_1592 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		// 입력받은 길이의 배열 생성
		int[] arr = new int[N];
		int bounce = 0;
		// 시작점 1로 시작
		arr[0] = 1;
		// 공의 위치
		int count = 0;
		while(true) {
		  // 
			if(arr[count] == M) {
				System.out.println(bounce);
				break;
			}
			// 공 위치의 값이 홀수면 시계 방향
			if(arr[count] % 2 != 0) {
				count += L;
				// 배열의 범위를 벗어나면 앞부분으로
				if(count > N-1) {
					count -= N;
				}
				arr[count]++;
			// 짝수면 반대로
			}else {
				count -= L;
				if(count < 0) {
					count += N;
				}
				arr[count]++;
			}
			// 튀길때마다 증가
			bounce++;	
		}
	}
}
