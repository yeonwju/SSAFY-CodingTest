package Week004;

import java.util.Scanner;

public class SWEA_1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		/*
		 * 앞에서부터 반복하면서 같지 않은 문자를 만나면 그 문자부터 전부 반대로 바꿔준다.
		 * 00110
		 * 00000
		 * 첫 반복문 때는 
		 * 00111
		 * 그 다음 반복문에는
		 * 00110으로 끝
		 * lastCnt = 2
		 */
		
		for(int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			
			char[] arr = new char[str.length()];
			char[] temp = new char[str.length()]; // 초기 bit
			
			for(int i = 0; i < str.length(); i++) {
				// arr에 입력받은 값 넣어주기
				arr[i] = str.charAt(i);
				// temp에 0으로 채운다.
				temp[i] = '0';
			}
			// 최종 누적 변수
			int lastCnt = 0;
			// flag변수로 arr과 temp가 일치할때까지 반복한다.
			boolean flag = true;
			while(flag) {
				// flagcnt가 arr.length와 같으면 모든 문자가 일치한다는 뜻
				int flagcnt = 0;
				
				for(int i = 0; i < arr.length; i++) {
					// 앞부터 확인하면서 같지 않으면
					if(arr[i] != temp[i]) {
						// cnt에 인덱스 저장
						int cnt = i;
						// cnt가 arr.length길이전까지 반복
						while(cnt < arr.length) {
							// 0이면 1로 1이면 0으로
							if(temp[cnt] == '0') {
								temp[cnt] = '1';
							}else {
								temp[cnt] = '0';
							}
							cnt++;
						}
						// 변경됐으니 lastCnt 증가
						lastCnt++;
						// 반복문 중지
						break;
					}
				}
				
				// 같을때마다 flagcnt를 증가시킨다.
				for(int i = 0; i < arr.length; i++) {
					if(arr[i] == temp[i]) {
						flagcnt++;
					}
				}
				// 길이가 같아지면 flag를 false로 바꿔서 최상단 whila문 중지
				if(flagcnt == arr.length) {
					flag = false;
				}
			}
			System.out.println("#" + tc + " " + lastCnt);
		}
	}
}
