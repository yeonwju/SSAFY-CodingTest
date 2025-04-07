import java.util.Scanner;

public class b2292_벌집 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		int num = sc.nextInt(); //입력받은 숫자
		int tmp = 1; // 현재 몇 번째 껍질인지
		int N = 1; // 1번방에서 시작, 쌓인 껍질 수를 의미
				   // 첫번째 껍질의 시작은 1, 두번째 껍질의 시작은 2, 세번째 껍질의 시작은 8...
				
		while(num>N) { //각 껍질의 시작을 의미하는 N보다 num이 클 때 아직 마지막 껍질까지 도달하지 않았으므로 반복문 계속 진행
			//벌집 칸 수 기준 값       1, 2, 8, 20 ...
			//증가하는 수가 6의 배수이다.  +1 +6 +12 +18
			N+=6*tmp; // 증가하는 값이 6의 배수
				
			tmp++; //벌집 껍질 수 증가
		}
				
		System.out.println(tmp);
		sc.close();
	}	
}
