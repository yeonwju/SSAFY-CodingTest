package Week006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] arr = new int[20];
        
        int M = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            String temp = br.readLine();
            String[] str = temp.split(" ");
            
            if(str.length == 1) {
                if(str[0].equals("all")) {
                    for(int k = 0; k < 20; k++) {
                        arr[k] = k + 1;
                    }
                }else if(str[0].equals("empty")) {
                    arr = new int[20];
                }
            }else {
                int num = Integer.parseInt(str[1]) - 1;
                if(str[0].equals("add")) {
                    if(arr[num] == 0) {
                        arr[num] = Integer.parseInt(str[1]);  
                    }
                }else if(str[0].equals("remove")) {
                    if(arr[num] != 0) {
                        arr[num] = 0;  
                    }
                }else if(str[0].equals("check")) {
                    if(arr[num] == 0) {
                        sb.append("0\n");
                    }else {
                    	sb.append("1\n");
                    }
                }else if(str[0].equals("toggle")) {
                    if(arr[num] != 0) {
                        arr[num] = 0;
                    }else {
                        arr[num] = Integer.parseInt(str[1]);
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
