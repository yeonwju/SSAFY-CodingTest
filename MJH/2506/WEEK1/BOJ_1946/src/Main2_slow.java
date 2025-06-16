import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main2_slow {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();			
			int[][] arr = new int[N][2];			
			for (int i = 0; i < N; i++) {
				arr[i][0] = sc.nextInt(); // g1
				arr[i][1] = sc.nextInt(); // g2
			}
			
			Arrays.sort(arr, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[0], o2[0]);
				}
				
			});
			
			int limitG2 = Integer.MAX_VALUE;
			int cnt = 0;
			for(int[] p : arr) {
				if(p[1] < limitG2) {
					limitG2 = p[1];
					cnt ++;
				}
			}
			System.out.println(cnt);
		}
		sc.close();
	}

}
