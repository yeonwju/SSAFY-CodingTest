package b8320_직사각형을만드는방법;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt(); //입력
		
		int sum = 0;
		for(int i=1; i<=100; i++) {//최대값이 10000이니까 100까지 반복하면 모든 수 반복 가능.
			if(i*i <= num) {//입력받은 수가 제곱수보다 크면 해당 경우 가능.
				sum += num/i - (i-1); //(i줄로 만들 수 있는 직사각형) - (행이 i보다 작을 경우)
			}
		}
		
		System.out.println(sum);
		
	}
}
