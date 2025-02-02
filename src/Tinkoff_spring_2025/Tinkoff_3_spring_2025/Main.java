package Tinkoff_spring_2025.Tinkoff_3_spring_2025;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int firstDay = sc.nextInt();
        int secondDay = sc.nextInt();

        int[] days = new int[n - 2];
        for (int i = 0; i < n - 2; i++) {
            days[i] = sc.nextInt();
        }

        Arrays.sort(days);

        long minCost = Long.MAX_VALUE;

        for (int j = 0; j <= days.length - m; j++) {
            int left  = days[j];
            int right = days[j + m - 1];

            long costLeft  = (firstDay > left ) ? (firstDay - left) : 0;
            long costRight = (right > secondDay) ? (right - secondDay) : 0;

            long totalCost = costLeft + costRight;

            if (totalCost < minCost) {
                minCost = totalCost;
            }
        }

        System.out.println(minCost);
    }
}
