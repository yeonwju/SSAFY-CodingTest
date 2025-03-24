package week8;

import java.io.IOException;
import java.util.Scanner;

public class Baekjoon17478 {

	static int n;
	static int depth;
	static StringBuilder sb = new StringBuilder();
	static String[] arr;

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 수
		arr = new String[7]; // 문자열 배열

		arr[0] = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다."; // 첫 시작 1번 출력
		arr[1] = "\"재귀함수가 뭔가요?\""; // 깊이가 같아지지 않을때까지 계속 출력(1~4)
		arr[2] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어."; // 깊이가 같아지지 않을때까지 계속 출력(1~4)
		arr[3] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지."; // 깊이가 같아지지 않을때까지 계속 출력(1~4)
		arr[4] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""; // 깊이가 같아지지 않을때까지 계속 출력(1~4)
		arr[5] = "\"재귀함수는 자기 자신을 호출하는 함수라네\""; // 깊이가 같아질 때 한번 출력
		arr[6] = "라고 답변하였지."; // 마지막 1번 출력

		Recursive(0);
		System.out.println(sb);

	}

	public static void Recursive(int depth) {

		if (depth == 0) { // 깊이가 0일때 첫 멘트 저장
			sb.append(arr[0]).append("\n");
		}

		if (depth == n) { // 깊이가 n에 도달했을때 5번 멘트 저장
			for(int i = 1; i <= 5; i += 4) {
			for (int j = 0; j < depth * 4; j++) { // 현재 깊이*4 만큼 '_' 저장
				sb.append("_");
			}
			sb.append(arr[i]).append("\n"); // 1, 5번 멘트 저장
			}
			return;
		}

		for (int i = 1; i <= 4; i++) { // 깊이가 n에 도달하기 전까지 1~4번 멘트 저장
			for (int j = 0; j < depth * 4; j++) { // 현재 깊이*4 만큼 '_' 저장
				sb.append("_");
			}
			sb.append(arr[i]).append("\n"); // 1~4번 멘트 저장
		}

		Recursive(depth += 1); // 깊이 +1하여 재귀

		for (int j = 0; j < depth * 4; j++) { // 깊이가 n에 도달한 후 백 할 때 저장
			sb.append("_"); // 현재 깊이*4 만큼 '_' 저장
		}
		sb.append(arr[6]).append("\n"); // 6번 멘트 저장

		if (depth == 1) { // 깊이가 1일때 마지막 멘트 저장
			sb.append(arr[6]).append("\n"); // 6번째 멘트 저장
		}
	}
}
