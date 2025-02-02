package Tinkoff_spring_2025.Tinkoff_5_spring_2025;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long s = sc.nextLong();

        long[] prefixSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            long len = sc.nextLong();
            prefixSum[i] = len + prefixSum[i - 1];
        }

        int[] cutPosition = new int[n + 1];
        int j = 1;
        for (int i = 1; i <= n; i++) {
            while (j <= n && prefixSum[j] - prefixSum[i - 1] <= s) {
                j++;
            }
            cutPosition[i] = j;
        }

        long[] partsCountPrefix = new long[n + 1];
        for (int i = n; i >= 1; i--) {
            if (cutPosition[i] == n + 1) {
                partsCountPrefix[i] = (n - i + 1);
            } else {
                partsCountPrefix[i] = (n - i + 1) + partsCountPrefix[cutPosition[i]];
            }
        }

        long result = 0;
        for (int i = 1; i <= n; i++) {
            result += partsCountPrefix[i];
        }

        System.out.println(result);
    }
}