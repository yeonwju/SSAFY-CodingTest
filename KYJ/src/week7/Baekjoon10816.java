package week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon10816 {
    public static void main(String[] args) throws IOException {
       
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>(); // {숫자, 숫자 개수}
        int n = Integer.parseInt(br.readLine()); // 카드에 적혀있는 숫자 개수
        StringTokenizer st = new StringTokenizer(br.readLine()); // 카드에 적혀있는 수 입력
        
        for (int i = 0; i < n; i++) { //숫자 값 카운트
            int tmp = Integer.parseInt(st.nextToken()); // 숫자 변환
        
            if(map.containsKey(tmp)) { //이미 존재하는 값이면
            	int a = map.get(tmp) + 1; //키에 해당하는 값을 뽑아서 카운트 +1
            	map.put(tmp,a); // 카운트 업데이트
            } else { //존재하지 않는 값은 새로 추가
            	map.put(tmp, 1); 
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine()); // 찾아야 할 정수 개수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int tmp = Integer.parseInt(st.nextToken()); // 숫자 변환
            if(map.containsKey(tmp)) { //존재하는 숫자라면
            	sb.append(map.get(tmp) + " "); // 숫자 개수 저장
            } else { //존재하지 않으면
            	sb.append("0 "); // 0 저장
            }
        }  
        System.out.println(sb.toString().trim()); // 마지막 공백 제거하고 출력
    }
}