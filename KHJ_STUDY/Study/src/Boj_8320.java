import java.util.Scanner;

public class Boj_8320 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력받은 숫자가 10일 경우
		// 1*1, 1*2 ,1*3 ... 1*10
		// 2*2, 2*3, 2*4 ... 2*5, 2*6(결과가 10을 넘어가서 안됨)
		// 3*3 3*4(결과가 10을 넘어가서 안됨)
		
		// 입력받은 숫자
		int a = sc.nextInt();
		// 1은 입력받은 숫자만큼 가능해서 바로 누적될 변수에 넣어준다.
		int sum = a;
		// 2부터 시작
		int cnt = 2;
		while(a >= cnt * cnt) {
			for(int i=0; i < a;i++) {
				if(a >= (cnt * cnt) + (cnt * i)) {
					sum++;
				}else {
					break;
				}
			}
			cnt++;
		}
		System.out.println(sum);
	}
}
