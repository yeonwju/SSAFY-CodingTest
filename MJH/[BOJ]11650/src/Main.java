import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		class XY implements Comparable<XY> {
			int x;
			int y;

			XY(int x, int y) {
				this.x = x;
				this.y = y;
			}

			@Override
			public int compareTo(XY o) {
				if (this.x != o.x)
					return this.x - o.x;
				else
					return this.y - o.y;
			}

			@Override
			public String toString() {
				return x + " " + y;
			}
			
		}
		XY[] input = new XY[N];

		String[] line;
		for (int i = 0; i < N; i++) {
			line = br.readLine().split(" ");
			input[i] = new XY(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
		}
		br.close();
		Arrays.sort(input);
		for(int i = 0 ; i < N ; i++) {
			System.out.println(input[i]);
		}
	}

}
