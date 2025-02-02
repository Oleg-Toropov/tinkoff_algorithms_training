package Tinkoff_spring_2025.Tinkoff_4_spring_2025;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long x = sc.nextLong();
        long y = sc.nextLong();
        long z = sc.nextLong();

        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }

        long[] minCost = new long[8];
        Arrays.fill(minCost, Long.MAX_VALUE / 2);

        long xy = lcm(x, y), xz = lcm(x, z), yz = lcm(y, z), xyz = lcm(xy, z);

        for (long num : nums) {
            minCost[1] = Math.min(minCost[1], cost(num, x));
            minCost[2] = Math.min(minCost[2], cost(num, y));
            minCost[4] = Math.min(minCost[4], cost(num, z));

            minCost[3] = Math.min(minCost[3], cost(num, xy));
            minCost[5] = Math.min(minCost[5], cost(num, xz));
            minCost[6] = Math.min(minCost[6], cost(num, yz));

            minCost[7] = Math.min(minCost[7], cost(num, xyz));
        }

        long result = Long.MAX_VALUE / 2;
        minCost[0] = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    if ((i | j | k) == 7) {
                        long sum = minCost[i] + minCost[j] + minCost[k];
                        result = Math.min(result, sum);
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static long cost(long num, long d) {
        long r = num % d;
        return (r == 0) ? 0 : (d - r);
    }


    private static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
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