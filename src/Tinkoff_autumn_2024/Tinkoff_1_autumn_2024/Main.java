package Tinkoff_autumn_2024.Tinkoff_1_autumn_2024; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    private static List<Integer> decode(String input) {
        List<Integer> numbers = new ArrayList<>();

        if (input == null || input.isEmpty()) {
            return numbers;
        }

        String[] intervals = input.split(",");

        for (String interval : intervals) {
            if (interval.contains("-")) {
                String[] startEnd = interval.split("-");
                int start = Integer.parseInt(startEnd[0]);
                int end = Integer.parseInt(startEnd[1]);

                for (int i = start; i <= end; i++) {
                    numbers.add(i);
                }
            } else {
                numbers.add(Integer.parseInt(interval));
            }
        }

        return numbers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        List<Integer> result = decode(s);

        for (int i = 0; i < result.size(); i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(result.get(i));;
        }
    }
}
