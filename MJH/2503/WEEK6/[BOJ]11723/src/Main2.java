import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int result = 0;
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
				num = 1 << (Integer.parseInt(line[1]) - 1);
			}
			switch (op) {
			case "add":
				result |= num;
				break;
			case "remove":
				if ((result & num) > 0)
					result -= (result & num);
				break;
			case "check":
				if (sb.length() != 0)
					sb.append("\n");
				if ((result & num) > 0) {
					sb.append(1);
				} else {
					sb.append(0);
				}
				break;
			case "toggle":
				if ((result & num) > 0)
					result -= (result & num);
				else
					result |= num;
				break;
			case "all":
				result = (1 << 20) - 1;
				break;
			case "empty":
				result = 0;
				break;
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
}
