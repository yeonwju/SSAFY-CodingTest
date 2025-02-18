import java.util.Scanner;

public class Boj_2839X {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0; // 봉지 수
		
		int N5 = N / 5;
		int N5_remainder = N % 5;
		
		// 처음 5kg 봉투로 나눴을때 나머지가 0이면 최소조건을 맞춤
		if(N5_remainder == 0) {
			cnt += N5;
		}else {
			// 위의 나머지를 다시 3으로 나눈뒤 0이면 몫을 N5와 같이 더한다.
			int N3 = N5_remainder / 3;
			int N3_remainder = N5_remainder % 3;
			if(N3_remainder == 0) {
				cnt = N5 + N3;
				// 나머지가 있다면 다시 3으로만 계산해본다.
			}else {
				N3 = N / 3;
				N3_remainder = N % 3;
				// 3으로 나머지가 0이면 해당 몫을 저장하고 아니면 -1
				if(N3_remainder == 0) {
					cnt = N3;
				}else {
					cnt = -1;
				}
			}
		}
		System.out.println(cnt);
		// 11에서 -1로 나옴
		// 5 하나 3 2개로 3이 나와야하는데
		// 로직이 5먼저 다 나누고 그 나머지로 3을 나눠서 -1 반환
	}
}
