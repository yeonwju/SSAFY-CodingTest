package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 연산의 수
        
        boolean[] arr = new boolean[21]; // 0~20까지 false(실사용 1~20)
        boolean[] arrt = new boolean[21]; // 0~20 true
        Arrays.fill(arrt, true);
        boolean[] arrf = new boolean[21]; // 0~20 false
        Arrays.fill(arrf, false);
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = 0;
            if (!command.equals("all") && !command.equals("empty")) {
                num = Integer.parseInt(st.nextToken()); // 숫자 입력 받음
            }

           if(command.equals("add")) { //더하기
        	   arr[num] = true; //해당 값을 true로 수정
           } else if(command.equals("remove")) { //제거하기
        	   arr[num] = false; //해당 값을 true로 수정
           } else if(command.equals("check")) { //체크
        	   if(arr[num]) { //존재하면
        		   sb.append("1\n");
        	   } else { //존재하지 않으면
        		   sb.append("0\n");
        	   }
           } else if(command.equals("toggle")) {
        	   if(arr[num]) { //존재하면
        		   arr[num] = false; // 삭제
        	   } else { //존재하지 않으면
        		   arr[num] = true; // 추가
        	   }
           } else if(command.equals("all")) { //전부 있음
        	   arr = arrt.clone(); //깊은 복사
           } else if(command.equals("empty")) { //전부 비움
        	   arr = arrf.clone(); //깊은 복사
           		} 
        }
        System.out.println(sb.toString());
    }
}
