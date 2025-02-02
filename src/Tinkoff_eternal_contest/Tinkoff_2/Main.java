package Tinkoff_eternal_contest.Tinkoff_2; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        sc.close();

        int minNumberOfMovements = 0;

        while (data > 1) {
            int a = 0;
            if (data % 2 == 1) {
                a = 1;
            }
            data = data / 2 + a;
            minNumberOfMovements++;
        }

        System.out.println(minNumberOfMovements);
    }
}




