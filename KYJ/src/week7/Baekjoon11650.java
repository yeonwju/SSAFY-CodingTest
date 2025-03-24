package week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon11650 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//a는 int[] 타입의 배열 (즉, (x, y) 좌표를 담은 배열)
		//a[0]을 기준으로 정렬하도록 설정했기 때문에 x 좌표 값이 작은 순서대로 정렬
		//첫 번째 요소가 같을 경우(x가 동일할 경우), 두 번째 요소(y)를 기준으로 정렬
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0])
                .thenComparingInt(a -> a[1]));
		
		/*
		 * // (x 내림차순, x가 같으면 y 내림차순)
         * PriorityQueue<int[]> pq = new PriorityQueue<>(
         * Comparator.comparingInt((int[] a) -> -a[0])  // x 기준 내림차순
                    .thenComparingInt(a -> -a[1])      // x가 같으면 y 기준 내림차순
        );
		 * */

		int n = Integer.parseInt(br.readLine()); // 입력받는 좌표 개수

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pq.add(new int[] {x,y});
		}
		
		//poll을 해야 오름차순으로 정렬
		while(!pq.isEmpty()) {
			int[] result = pq.poll();
			System.out.println(result[0] + " " + result[1]);
		}
	}
}
