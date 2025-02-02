package Tinkoff_summer_2024.Tinkoff_2_summer_2024; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        long[][] matrix = new long[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextLong();
            }
        }
        sc.close();

        long[][] turnedMatrix = new long[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                turnedMatrix[j][n - 1 - i] = matrix[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(turnedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

