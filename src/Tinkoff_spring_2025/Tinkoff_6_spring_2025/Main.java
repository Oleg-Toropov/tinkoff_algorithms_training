package Tinkoff_spring_2025.Tinkoff_6_spring_2025;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] points = new long[n][2];

        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextLong();
            points[i][1] = sc.nextLong();
        }

        int maxCollinear = 1;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopes = new HashMap<>();

            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }

                long dx = points[j][0] - points[i][0];
                long dy = points[j][1] - points[i][1];

                long gcd = gcd(Math.abs(dx), Math.abs(dy));
                dx /= gcd;
                dy /= gcd;

                if (dx < 0 || (dx == 0 && dy < 0)) {
                    dx = -dx;
                    dy = -dy;
                }
                String key = dx + "#" + dy;
                slopes.put(key, slopes.getOrDefault(key, 0) + 1);
            }

            for (int count : slopes.values()) {
                maxCollinear = Math.max(maxCollinear, count + 1);
            }
        }

        int result = (maxCollinear <= n / 2) ? n / 3 : Math.min(n - maxCollinear, maxCollinear / 2);

        System.out.println(result);
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}