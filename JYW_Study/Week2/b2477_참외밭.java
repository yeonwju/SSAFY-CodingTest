import java.util.Scanner;
public class b2477_참외밭 {
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			int max = sc.nextInt(); //1m2 당 참외 갯수
			
			int[][] lines = new int[6][2]; //6개 변 당 방향, 길이 입력
			
			int maxWidth = 0, maxHeight = 0; // 최대 가로, 세로 길이
			
			for(int i=0; i<6; i++) {
				//2차 배열 입력
				lines[i][0] = sc.nextInt();	//방향
				lines[i][1] = sc.nextInt(); //길이
				
				//최대 가로, 세로 갱신
				if(lines[i][0] == 1 || lines[i][0] == 2) {// 방향이 동, 서일 경우
					maxWidth = Math.max(maxWidth, lines[i][1]);
				} else {// 방향이 남, 북일 경우
					maxHeight = Math.max(maxHeight, lines[i][1]);
				}
			}
			
			//작은 직사각형
			int smallWidth = 0, smallHeight = 0;
			for(int i=0; i<6; i++) {
				if(lines[i][1] == maxHeight) {//최대 세로길이 일때,
					smallWidth = lines[(i + 3) % 6][1];// 최대 세로부터 3번째 변이 작은사각형 가로
					smallHeight = lines[(i + 4) % 6][1];// 최대 세로부터 4번째 변이 작은사각형 세로
					break;
				}
			}
			
			
			int area = (maxWidth * maxHeight) - (smallWidth *smallHeight);//넓이 = (최대가로*최대세로)-(작은가로*작은세로)
			
			System.out.println(area*max); //넓이 * 최대참외갯수
			sc.close();
		}
}
