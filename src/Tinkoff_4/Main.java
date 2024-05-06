package Tinkoff_4; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            int weight = 1;

            while (number > 0) {
                int figure = number % 10;
                if (figure != 9) {
                    heap.add((9 - figure) * weight);
                }
                weight *= 10;
                number /= 10;
            }
        }

        sc.close();

        long difference = 0;

        while (k > 0 && !heap.isEmpty()) {
            difference += heap.poll();
            k--;
        }

        System.out.println(difference);
    }
}
