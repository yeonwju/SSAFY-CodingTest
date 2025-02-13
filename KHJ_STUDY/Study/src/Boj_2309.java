import java.util.Arrays;
import java.util.Scanner;

public class Boj_2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		for(int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		int[] arr2 = new int[7];
		for(int i = 0; i < 9; i++) {
			for(int j = i + 1; j < 9; j++) {
				for(int k = j + 1; k < 9; k++) {
					for(int l = k + 1; l < 9; l++) {
						for(int m = l + 1; m < 9; m++) {
							for(int n = m + 1; n < 9; n++) {
								for(int u = n + 1; u < 9; u++) {
									int sum = arr[i] + arr[j] + arr[k] + arr[l] + arr[m] + arr[n] + arr[u];
									
									if(sum == 100) {
										
										arr2[0] = arr[i];
										arr2[1] = arr[j];
										arr2[2] = arr[k];
										arr2[3] = arr[l];
										arr2[4] = arr[m];
										arr2[5] = arr[n];
										arr2[6] = arr[u];
										Arrays.sort(arr2);
										break;
									}
								}
							}
						}
					}
				}
			}
		}
		for(int i=0;i<7;i++) {
			System.out.println(arr2[i]);
		}
	}
}
