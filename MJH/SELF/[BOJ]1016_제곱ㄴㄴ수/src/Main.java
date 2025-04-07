import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long min = sc.nextLong();
		long max = sc.nextLong();

		int size = (int) (max - min) + 1;

		findMaxSQRT(max);
		//System.out.println(maxsqrt);
		findsosu();
		//System.out.println(sosu);
		int result = size;
		boolean[] arr = new boolean[size];
		for (int i : sosu) {
			long ii = (long) i * i; 
			long k = min / ii;
			if(min % ii != 0)
				k++;
			while(true) {
				//System.out.println("ii: "+ii + ", k: "+k);
				long gop = ii * k;
				if(gop > max)
					break;
				int idx = (int)(gop - min);
				k++;
				if(arr[idx])
					continue;
				arr[idx] = true;
				result--;
			}
		}
		System.out.println(result);
	}

	static int maxsqrt;

	static void findMaxSQRT(long max) {
		int i = 1;
		while (true) {
			long l = (long) i * i;
			if (l > max)
				break;
			i++;
		}
		maxsqrt = i - 1;
	}

	static boolean[] sosuCandidate;
	static Queue<Integer> sosu = new LinkedList<>();;

	static void findsosu() {
		sosuCandidate = new boolean[maxsqrt + 1];
		for (int i = 2; i <= maxsqrt; i++) {
			if (sosuCandidate[i])
				continue;
			sosuCandidate[i] = true;
			sosu.add(i);
			int k = 2;
			while (true) {
				int gob = k * i;
				if (gob > maxsqrt)
					break;
				sosuCandidate[gob] = true;
				k++;
			}
		}
	}

}
