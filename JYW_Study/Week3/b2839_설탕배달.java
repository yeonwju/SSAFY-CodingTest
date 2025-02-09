import java.util.Scanner;

public class b2839_설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int need = 0; // 필요한 봉지 수
		
		// 작은 수인 3을 먼저 생각.
		// 3을 한번씩 빼다가 5의 배수가 나오면 끝내는 방법.
		// 3과 5로 담을 수 없는 수는 음수가 되어 -1 도출.

		while(N>0) {
			if(N%5==0) {//5의 배수면
				need += N/5;
				break;
			}
			else {//5의 배수가 아니면 여기로
				N-=3;
				need ++;
			}
		}
		if(N<0) {//7처럼 담기지 않는 수면 3을 계속 뺐을 때, N이 음수가 된다.
			need =-1;
		}
		
		System.out.println(need);
		
	}
}
