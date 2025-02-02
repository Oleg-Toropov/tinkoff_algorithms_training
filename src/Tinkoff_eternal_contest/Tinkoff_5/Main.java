package Tinkoff_eternal_contest.Tinkoff_5; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        long r = sc.nextLong();
        sc.close();

        List<Long> sequence = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            sequence.add((long) i);
        }

        long limit = (long) Math.pow(10, 18) - 1;
        int x = 0;
        int k = 1;

        while (sequence.get(sequence.size() - 1) < limit) {
            long value = sequence.get(x) * 10 + k;
            sequence.add(value);
            x++;
            k++;

            if (k == 10) {
                k = 1;
            }
        }

        int counter = 0;

        for (long a : sequence) {
            if (l <= a && a <= r) {
                counter++;
            }
        }

        System.out.println(counter);

    }
}
