package Tinkoff_spring_2025.Tinkoff_7_spring_2025;

import java.util.Scanner;

public class Main {
    static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long[] sums = new long[k + 1];
        sums[0] = n;

        for (int i = 0; i < n; i++) {
            long a = sc.nextInt();
            long current = 1;
            for (int j = 1; j <= k; j++) {
                current = (current * a) % MOD;
                sums[j] = (sums[j] + current) % MOD;
            }
        }

        int[][] binom = new int[k + 1][k + 1];
        for (int p = 0; p <= k; p++) {
            binom[p][0] = 1;
            for (int r = 1; r <= p; r++) {
                binom[p][r] = (binom[p - 1][r - 1] + binom[p - 1][r]);
            }
        }

        long[] pow2 = new long[k + 1];
        pow2[0] = 1;
        for (int p = 1; p <= k; p++) {
            pow2[p] = (pow2[p - 1] * 2) % MOD;
        }

        long inv2 = (MOD + 1L) / 2;

        for (int p = 1; p <= k; p++) {
            long temp = 0;
            for (int r = 0; r <= p; r++) {
                long prod = binom[p][r];
                prod = (prod * sums[r]) % MOD;
                prod = (prod * sums[p - r]) % MOD;
                temp = (temp + prod) % MOD;
            }

            long part1 = (temp * inv2) % MOD;
            long part2 = ((pow2[p - 1] % MOD) * (sums[p] % MOD)) % MOD;

            long result = part1 - part2;
            result = (result % MOD + MOD) % MOD;
            System.out.println(result);
        }
    }
}
