import java.util.Scanner;

public class Boj_2477 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * 큰 넓이에서 비어있는 넓이를 빼는 방법으로 만들겁니다.
		 * 가로중에 제일 긴 길이 양 옆에 있는 값의 차이,
		 * 세로중에 제일 긴 길이 양 옆에 있는 값의 차이
		 * 이 두개가 비어있는 공간의 가로 세로가 됩니다.
		 */
		int K = sc.nextInt(); // 자라는 참외의 개수
		int[][] arr = new int[2][6];
		for(int i=0;i<6;i++) {
			arr[0][i] = sc.nextInt(); // 동서남북
			arr[1][i] = sc.nextInt(); // 길이
		}
		
		int width_max = 0; // 가로
		int width_index = 0;
		int length_max = 0; // 세로
		int length_index = 0;
		
		// 가로와 세로중에 제일 긴 값을 구하는 반복문
		for(int i=0;i<6;i++) {
			if(arr[0][i] == 1 || arr[0][i] == 2) { // 1,2면 가로
				if(width_max < arr[1][i]) {
					width_max = arr[1][i];
					width_index = i;
				}
			}else if(arr[0][i] == 3 || arr[0][i] == 4) { // 3,4면 세로
				if(length_max < arr[1][i]) {
					length_max = arr[1][i];
					length_index = i;
				}
			}
		}
		int scale = arr[1][width_index] * arr[1][length_index]; // 밭의 원래 넓이
		
		// 가로 세로 최대 값의 위치에 양 옆을 계산해야해서 -1, +1한 값을 확인한다.
		// 좀 깔끔하게 쓸 수 있을 것 같은데 머리가 안돌아감
		int width_left = width_index - 1;
		int width_right = width_index + 1;
		int length_left = length_index - 1;
		int length_right = length_index + 1;
		if(width_left < 0) { // 범위를 벗어나면 조정해주는 조건문
			width_left = 5;
		}
		// [1 ,2 ,1, 2,3,4]
		if(width_right > 5){
			width_right = 0;
		}
		if(length_left < 0) {
			length_left = 5;
		}
		if(length_right > 5) {
			length_right = 0;
		}
		
		int width_small = 0; // 비어있는 공간의 가로, 양 옆의 값중에 큰거에서 작은거를 빼준다.
		if(arr[1][width_left] > arr[1][width_right]) {
			width_small = arr[1][width_left] - arr[1][width_right];
		}else {
			width_small = arr[1][width_right] - arr[1][width_left];
		}
		
		int length_small = 0; // 비어있는 공간의 세로, 위와 동일
		if(arr[1][length_left] > arr[1][length_right]) {
			length_small = arr[1][length_left] - arr[1][length_right];
		}else {
			length_small = arr[1][length_right] - arr[1][length_left];
		}
		// 넓은 공간에서 작은 공간을 뺴고 입력받은 자라는 참외 수를 곱해준다.
		System.out.println((scale - (width_small * length_small)) * K);
	}
}
