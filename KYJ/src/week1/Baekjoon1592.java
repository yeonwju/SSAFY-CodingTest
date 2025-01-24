package week1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon1592 {

	public static void main(String[] args) {
		
		//모르겠다..

		Scanner sc = new Scanner(System.in);
		
		//사람의 수
		int N = sc.nextInt();
		//M번 받으면 공 주고받기 끝
		int M = sc.nextInt();
		//L번째에 있는 사람...
		int L = sc.nextInt();
		
		//모든 과정에서 공을 주고 받은 횟수
		int count = 1;
		
		//사람의 수 배열 {0,0,0 ...0}
		int[] nums = new int[N];
		nums[0] = 1;
		
		System.out.println("최초 배열의 값 : " + Arrays.toString(nums));
		
		for(int i = 1; ; i++) {
			
			i = L;
			
			if(i >= N) {
				
				i = ((i + L) - N) -1;
				System.out.println("i번째 인덱스 숫자 : " + i);
				
			}
			
			
			//해당 사람이 M번 받았을 때
			if(nums[i] >= M) {
				
				System.out.println("최초 i번째 인덱스 숫자 : " + i);
				
				//받은 사람의 공 받은 횟수 +1 한 후 해당 반복문을 빠져나온다
				nums[i]++;
				count++;
				i = (i + L) -1 ;
				
				System.out.println("한번 더했을 때 배열의 값 : " + Arrays.toString(nums));
				System.out.println("공이 주고 받아진 횟수 : " + count);
				System.out.println("i번째 인덱스 숫자 : " + i);
				
				
				break;
				
				
			} else {
				
				nums[i]++;
				count++;
				i = (i + L) -1 ;
				System.out.println("한번 더했을 때 배열의 값 : " + Arrays.toString(nums));
				System.out.println("공이 주고 받아진 횟수 : " + count);
				System.out.println("i번째 인덱스 숫자 : " + i);
				

				
			}
			
			
		}
		
		System.out.println(count);
  }
}