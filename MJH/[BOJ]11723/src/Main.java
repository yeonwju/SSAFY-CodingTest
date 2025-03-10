import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Set<Integer> set = new HashSet<>();
		int M = Integer.parseInt(br.readLine());
		String str;
		String[] line;
		String op;
		int num;
		for (int i = 0; i < M; i++) {
			str = br.readLine();
			if (str.equals("all") || str.equals("empty")) {
				op = str;
				num = 0;
			} else {
				line = str.split(" ");
				op = line[0];
				num = Integer.parseInt(line[1]);
			}
			switch (op) {
			case "add":
				set.add(num);
				break;
			case "remove":
				set.remove(num);
				break;
			case "check":
				if (set.contains(num)) {
					if (sb.length() != 0)
						sb.append("\n");
					sb.append(1);
				} else {
					if (sb.length() != 0)
						sb.append("\n");
					sb.append(0);
				}
				break;
			case "toggle":
				if (set.contains(num))
					set.remove(num);
				else
					set.add(num);
				break;
			case "all":
				for (int j = 1; j <= 20; j++) {
					set.add(j);
				}
				break;
			case "empty":
				for (int j = 1; j <= 20; j++) {
					set.remove(j);
				}
				break;
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
}
