package Tinkoff_summer_2024.Tinkoff_4_summer_2024; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String direction = sc.next();
        long[][] matrix = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextLong();
            }
        }
        sc.close();

        StringBuilder operations = new StringBuilder();
        int operationsCount = 0;
        boolean[][] processed = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!processed[i][j]) {
                    int currentX = i, currentY = j;
                    int nextX, nextY;

                    while (true) {
                        if (direction.equals("L")) {
                            nextX = currentY;
                            nextY = n - 1 - currentX;
                        } else {
                            nextX = n - 1 - currentY;
                            nextY = currentX;
                        }

                        if (nextX == i && nextY == j) {
                            break;
                        }

                        if (matrix[currentX][currentY] != matrix[nextX][nextY]) {
                            operations.append(String.format("%d %d %d %d\n", currentX, currentY, nextX, nextY));
                            operationsCount++;

                            long temp = matrix[currentX][currentY];
                            matrix[currentX][currentY] = matrix[nextX][nextY];
                            matrix[nextX][nextY] = temp;
                        }

                        processed[currentX][currentY] = true;
                        currentX = nextX;
                        currentY = nextY;
                    }
                    processed[currentX][currentY] = true;
                }
            }
        }

        System.out.println(operationsCount);
        System.out.print(operations.toString());
    }
}
