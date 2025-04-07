package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Baejoon4386 {

    static double minCost; // 최소 비용
    static boolean[] check; // 별 방문 확인
    static int n; // 별 개수
    static double result;

    // 별 x, y 좌표(double값) 입력
    static class starInfo {
        double x, y;

        public starInfo(double x, double y) {
            super();
            this.x = x;
            this.y = y;
        }
    }

    // 별 x, y(인덱스 값으로 접근), 거리 입력
    static class starLocation implements Comparable<starLocation> {
        int from, to;
        double cost;

        public starLocation(int from, int to, double cost) {
            super();
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public starLocation(int to, double cost) {
            super();
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(starLocation o) { // 거리순으로 정렬(가장 짧은 거리 뽑기)
            return Double.compare(this.cost, o.cost);
        }
    }

    static List<starInfo> arr; // 별 위치
    static List<List<starLocation>> graph; // 인접 리스트로 그래프 표현

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 별 개수
        arr = new ArrayList<>(); // 별 x, y 값
        
        // 인접 리스트 초기화
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        check = new boolean[n];
        result = 0;

        // 좌표 입력 받기
        for (int i = 0; i < n; i++) {
            String[] location = br.readLine().split(" ");
            double x = Double.parseDouble(location[0]); // x좌표
            double y = Double.parseDouble(location[1]); // y좌표
            arr.add(new starInfo(x, y));
        }

        // 좌표 간 거리 계산 및 그래프 구성
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // i와 j 사이의 거리
                double dist = Math.sqrt(
                    Math.pow((arr.get(j).x - arr.get(i).x), 2) + 
                    Math.pow((arr.get(j).y - arr.get(i).y), 2)
                );
                
                // 양방향 간선 추가
                graph.get(i).add(new starLocation(j, dist));
                graph.get(j).add(new starLocation(i, dist));
            }
        }

        // 프림 알고리즘 수행 (0번 별부터 시작)
        star();
        
        // 결과 출력 (소수점 둘째자리까지)
        System.out.printf("%.2f%n", result);
    }

    // 프림 알고리즘으로 MST 구하기
    private static void star() {
        PriorityQueue<starLocation> pq = new PriorityQueue<>();
        pq.add(new starLocation(0, 0)); // 0번 별부터 시작, 거리 0
        
        int count = 0; // 선택된 별의 개수

        while (!pq.isEmpty() && count < n) { // 모든 별을 연결할 때까지
            starLocation curr = pq.poll(); // 가장 가까운 별 선택
            
            if (check[curr.to]) { // 이미 방문한 별이면 스킵
                continue;
            }
            
            // 별 방문 처리
            check[curr.to] = true;
            result += curr.cost; // 거리 누적
            count++; // 선택된 별 개수 증가
            
            // curr.to와 인접한 별들 중 방문하지 않은 별들을 큐에 추가
            for (starLocation next : graph.get(curr.to)) {
                if (!check[next.to]) {
                    pq.add(next);
                }
            }
        }
    }
}