package week10;

import java.util.Scanner;

public class Baejoon1012 {

    static int[][] arr;
    static boolean[][] check;
    static int m;
    static int n;
    static int l;
    static int[] dr;
    static int[] dc;
    static int count;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스

        for (int test_case = 1; test_case <= t; test_case++) {

            m = sc.nextInt(); // 배추밭 가로길이
            n = sc.nextInt(); // 배추밭 세로길이
            l = sc.nextInt(); // 배추가 심어져있는 개수
            arr = new int[n][m]; // 배추밭 넓이
            check = new boolean[n][m]; // 배추밭 방문 체크
            
            //상하좌우 탐색
            dr = new int[]{-1, 1, 0, 0}; 
            dc = new int[]{0, 0, -1, 1};

            for (int i = 0; i < l; i++) {
                int x = sc.nextInt(); // x 좌표
                int y = sc.nextInt(); // y 좌표
                arr[y][x] = 1; // 배추가 있는 곳 체크
            }

            // 군락 찾기
            count = 0; // 군락의 개수 초기화
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1 && !check[i][j]) {
                        // 새로운 군락 발견 +1
                        count++;
                        baechu(i, j); //탐색 시작
                    }
                }
            }

            System.out.println(count);
        }
    }

    // 상하좌우 배추 군락 탐색
    private static void baechu(int x, int y) {
        check[x][y] = true; //방문 체크

        // 상하좌우로 인접한 배추가 있는지 확인
        for (int a = 0; a < 4; a++) {
            int nx = x + dr[a];
            int ny = y + dc[a];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) { //인덱스 오류 방지
                if (!check[nx][ny] && arr[nx][ny] == 1) { //방문하지 않았으면서 배추가 심어져 있을 때
                    baechu(nx, ny); //상하좌우 배추 군락 재탐색
                }
            }
        }
    }
}
