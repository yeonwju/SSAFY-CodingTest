package b3985_롤케이크;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();//길이 입력
		int T = sc.nextInt();//관객수 입력
		
		int[] arr = new int[L+1];//롤케이크 길이만큼 배열 선언
		
		int l_max = 0;// 최대 기대길이
		int a_max = 0;// 최대 실제길이
		int k = 1;
		int[] exp = new int[T+1];
		
		for(int i=0; i<T; i++) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int length = b-a+1;
			if(l_max < length) l_max = length;
			
			exp[k] = length; // 최대 기대길이를 위한 기대길이 배열
			
			for(int j=a; j<=b; j++) {
				if(arr[j] != 0) continue;
				arr[j]=k; // 실제 롤케이크 어디를 가지고 갔는지 입력
			}
			k++;
		}
		
		
		int[] count = new int[T+1];//실제 롤케이크 가져간 길이 세기 위한 배열
		
		for(int t=1; t<=T; t++) {
			for(int i=0; i<L; i++) {
				if(arr[i] == t) {
					count[t]++; //몇번 사람이 얼마나 실제 롤케이크를 가져갔는지
				}
			}
		}
		
		int[] counts = Arrays.copyOf(count, T+1);//깊은 복사
		Arrays.sort(counts);//오름차순으로 정렬
		
		a_max = counts[T];//최대 실제크기 저장
		
		//l_max, a_max 값을 가지고 있는 배열의 index 구하기
		
		int l_index=0, a_index = 0;
		for(int i=T; i>=0; i--) {//큰수부터 순회
			if(exp[i]==l_max) {//l_max인 값 만나면 저장
				l_index = i;
			}
		}
			
		for(int i=0; i<=T; i++) {//작은수부터 순회
			if(count[i]==a_max) {//a_max 값 만나면 저장
				a_index = i;
				break;//다른 값으로 갱신되면 안되어서 반복 그만
			}
		}
		
		System.out.println(l_index);
		System.out.println(a_index);
		
	}
}
