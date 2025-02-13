import java.util.Scanner;

public class Boj_2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int count = 0; // 방을 이동할때마다 증가할 변수
		
		// 벌집 육각형모양을 배열로 생각한다.
		// [1], [2,3,4,5,6,7], [8,9,10,11,12,13,14,15,16,17,18,19]
		// [20,21,22 ...36, 37] 해당 배열은 처음만 길이가 1이고 그 이후부터
		// 6씩 늘어난다.
		// 방을 이동할때마다 6을 추가한 값을 빼준다.
		// 첫 시작은 본인을 포함해야하기 때문에 1을 빼준다.
		/*
		 * ex) 48
		 * 48 - 1 = 47
		 * 47 - (6 * 1) = 41
		 * 41 - (6 * 2) = 29
		 * 29 - (6 * 3) = 11
		 * 18 - (6 * 4) = -6
		 * 입력한 숫자에서 카운트되는 숫자를 빼주기 때문에 음수가 되면
		 * 해당 방에 도착하기 때문에 while문이 종료된다.
		 */
		while(N > 0) {
			if(count == 0) {
				N--;
			}else {
				N = N - (6*count);
			}
			count++;
			// System.out.println(count);
		}
		System.out.println(count);
	}
}
