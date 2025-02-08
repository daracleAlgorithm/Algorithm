package org.pack.jan_3.Lv1_실패율;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dazz6 {
    public int[] solution(int N, int[] stages) {
        double[][] result = new double[N][2];

        int[] cbs = new int[N + 2];
        int c = stages.length;

        for (int s : stages) {
            if (s <= N) {
                cbs[s]++;
            }
        }

        for (int i = 1; i <= N; i++) {
            double temp = (c == 0) ? 0 : (double) cbs[i] / c;
            result[i - 1][0] = i;
            result[i - 1][1] = temp;
            c -= cbs[i];
        }

        Arrays.sort(result, (a, b) -> {
            if (b[1] != a[1]) {
                return Double.compare(b[1], a[1]);
            }
            return Double.compare(a[0], b[0]);
        });

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add((int) result[i][0]);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
