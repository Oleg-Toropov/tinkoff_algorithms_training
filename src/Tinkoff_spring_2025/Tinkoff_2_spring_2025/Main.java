package Tinkoff_spring_2025.Tinkoff_2_spring_2025;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Long> powOfTwos = getPowOfTwos();

        List<Long> costs = getCosts(powOfTwos);
        Collections.sort(costs);

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            long a = sc.nextLong();
            System.out.println(binarySearch(costs, a));
        }
    }

    private static List<Long> getCosts(List<Long> powOfTwos) {
        List<Long> costs = new ArrayList<>();
        int size = powOfTwos.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    costs.add(powOfTwos.get(i) + powOfTwos.get(j) + powOfTwos.get(k));
                }
            }
        }

        return costs;
    }

    private static List<Long> getPowOfTwos() {
        List<Long> powOfTwos = new ArrayList<>();
        for (int i = 0; i <= 59; i++) {
            powOfTwos.add(1L << i);
        }

        return powOfTwos;
    }

    private static long binarySearch(List<Long> costs, long a) {
        int left = 0, right = costs.size() - 1;
        long result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (costs.get(mid) <= a) {
                result = costs.get(mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}