package Tinkoff_autumn_2024.Tinkoff_4_autumn_2024; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.*;

public class Main {
    static final int PRIME_DIVISOR_LIMIT = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long l = scanner.nextLong();
        long r = scanner.nextLong();

        List<Long> primes = sieveOfEratosthenes((long) Math.sqrt(r));
        Set<Long> primeDivisorCounts = new HashSet<>(sieveOfEratosthenes(PRIME_DIVISOR_LIMIT));

        int count = 0;

        for (long prime : primes) {
            long square = prime * prime;

            if (l <= square && square <= r) {
                count++;
            }

            for (int k = 2; ; k++) {
                long powerSquare = (long) Math.pow(prime, 2 * k);

                if (powerSquare > r) {
                    break;
                }

                if (l <= powerSquare && primeDivisorCounts.contains((long) 2 * k + 1)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static List<Long> sieveOfEratosthenes(long max) {
        boolean[] isPrime = new boolean[(int) (max + 1)];
        List<Long> primes = new ArrayList<>();

        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }

        for (int p = 2; (long) p * p <= max; p++) {
            if (isPrime[p]) {
                for (int j = p * p; j <= max; j += p) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                primes.add((long) i);
            }
        }

        return primes;
    }
}