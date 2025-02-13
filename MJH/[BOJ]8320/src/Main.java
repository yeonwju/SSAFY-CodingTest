import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// 만들 수 있는 직사각형의 갯수 = 약수의 갯수 / 2
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			int n = Integer.parseInt(br.readLine());
			Set<String> set = new HashSet<>();
			int square = 0; //정사각형인 경우 set에 한 번만 추가됨
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= i; j++) {
					if (i % j == 0) {
						//System.out.println(j + "×" + (i / j));
						if (j == (i / j))
							square++;
						set.add(j + "×" + (i / j));
					}
				}
			}
			System.out.println((set.size() + square) / 2);
		} catch (IOException e) {

		}

	} // main}

} // class}
