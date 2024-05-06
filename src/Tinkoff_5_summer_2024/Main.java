package Tinkoff_5_summer_2024; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        char[][] table = new char[n][3];

        for (int i = 0; i < n; i++) {
            table[i] = sc.nextLine().toCharArray();
        }
        sc.close();

        int[][] path = new int[n][3];

        for (int j = 0; j < 3; j++) {
            path[0][j] = (table[0][j] == 'W') ? -1 : (table[0][j] == 'C' ? 1 : 0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j] == 'W') {
                    path[i][j] = -1;
                } else {
                    int prev = -1;

                    if (j > 0 && path[i - 1][j - 1] != -1) {
                        prev = Math.max(prev, path[i - 1][j - 1]);
                    }

                    if (path[i - 1][j] != -1) {
                        prev = Math.max(prev, path[i - 1][j]);
                    }

                    if (j < 2 && path[i - 1][j + 1] != -1) {
                        prev = Math.max(prev, path[i - 1][j + 1]);
                    }

                    if (prev == -1) {
                        path[i][j] = -1;
                    } else {
                        path[i][j] = prev + (table[i][j] == 'C' ? 1 : 0);
                    }
                }
            }
        }

        int result = 0;

        for (int j = 0; j < 3; j++) {
            if (path[n - 1][j] > result) {
                result = path[n - 1][j];
            }
        }

        System.out.println(result);
    }
}

