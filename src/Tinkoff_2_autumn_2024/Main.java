package Tinkoff_2_autumn_2024; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

public class Main {
    private static String comparison(int[] days) {

        int prevDay = (days[0] == -1) ? 1 : days[0];

        StringBuilder result = new StringBuilder();
        result.append(prevDay);

        int amountSnow = prevDay;

        for (int i = 1; i < days.length; i++) {
            int currentDay = days[i];

            if (currentDay == -1) {
                currentDay = prevDay + 1;
            } else {
                currentDay -= amountSnow;
            }

            if (prevDay >= currentDay) {
                return "NO";
            }

            result.append(" ").append(currentDay);
            prevDay = currentDay;
            amountSnow += currentDay;
        }

        return "YES\n" + result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] days = new int[n];

        for (int i = 0; i < n; i++) {
            days[i] = scanner.nextInt();
        }

        System.out.println(comparison(days));
    }
}
