import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int minH = 256, maxH = 0;
        int[] cnt = new int[257];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int h = Integer.parseInt(st.nextToken());
                cnt[h]++;
                minH = Math.min(minH, h);
                maxH = Math.max(maxH, h);
            }
        }

        int bestTime = Integer.MAX_VALUE, bestH = 0;

        for (int H = minH; H <= maxH; H++) {
            long remove = 0, add = 0;
            for (int h = minH; h <= maxH; h++) {
                if (h > H) remove += (long)(h - H) * cnt[h];
                else if (h < H) add += (long)(H - h) * cnt[h];
            }
            if (remove + B < add) continue;
            int time = (int)(remove * 2 + add);
            if (time < bestTime || (time == bestTime && H > bestH)) {
                bestTime = time;
                bestH = H;
            }
        }

        System.out.println(bestTime + " " + bestH);
    }
}
