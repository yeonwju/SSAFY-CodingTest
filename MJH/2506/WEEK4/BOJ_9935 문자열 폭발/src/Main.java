import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static String str, bomb;
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        bomb = br.readLine();
        br.close();

        int bombLen = bomb.length();
        stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            stack.add(ch);
            if (stack.size() >= bombLen) {
                tryBomb();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }

    public static void tryBomb() {
        Stack<Character> temp = new Stack<>();
        int idx = bomb.length() - 1;

        // 스택에서 뒤에서부터 bomb 문자열과 비교
        for (int i = idx; i >= 0; i--) {
            char ch = stack.pop();
            if (ch == bomb.charAt(i)) {
                temp.push(ch);
            } else {
                // 매칭 실패한 문자 복원
                stack.push(ch);
                while (!temp.isEmpty()) {
                    stack.push(temp.pop());
                }
                return;
            }
        }
    }
}
