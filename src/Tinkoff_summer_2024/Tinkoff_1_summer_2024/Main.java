package Tinkoff_summer_2024.Tinkoff_1_summer_2024; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] mList = new int[n];

        for (int i = 0; i < n; i++) {
            mList[i] = sc.nextInt();
        }
        sc.close();

        if (n < 7) {
            System.out.println(-1);
            return;
        }

        int maxFiveCount = -1;
        int fiveCounter = 0;
        int start = 0;

        for (int finish = 0; finish < n; finish++) {
            if (mList[finish] == 5) {
                fiveCounter++;
            }

            if (finish - start + 1 == 7) {
                boolean b = true;
                for (int i = start; i <= finish; i++) {

                    if (mList[i] == 2 || mList[i] == 3) {
                        b = false;
                        break;
                    }
                }

                if (b && fiveCounter > maxFiveCount) {
                    maxFiveCount = fiveCounter;
                }

                if (mList[start] == 5) {
                    fiveCounter--;
                }

                start++;
            }
        }

        System.out.println(maxFiveCount);
    }
}
