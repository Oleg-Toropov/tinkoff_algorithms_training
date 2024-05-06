package Tinkoff_6_summer_2024; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        char[][] board = new char[n][n];
        int startX = 0, startY = 0;
        int finishX = 0, finishY = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            board[i] = line.toCharArray();
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'S') {
                    startX = i;
                    startY = j;
                } else if (board[i][j] == 'F') {
                    finishX = i;
                    finishY = j;
                }
            }
        }
        sc.close();

        int[][] horse = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
        int[][] king = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[n][n][2];
        queue.add(new int[]{startX, startY, 1});
        visited[startX][startY][1] = true;

        int movesCount = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                int chessman = current[2]; // 0 - король, 1 - конь

                if (x == finishX && y == finishY) {
                    System.out.println(movesCount);
                    return;
                }

                int[][] moves = (chessman == 1) ? horse : king;

                for (int[] move : moves) {
                    int nextX = x + move[0];
                    int nextY = y + move[1];

                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                        int nextChessman = chessman;

                        if (board[nextX][nextY] == 'K') {
                            nextChessman = 1;
                        } else if (board[nextX][nextY] == 'G') {
                            nextChessman = 0;
                        }

                        if (!visited[nextX][nextY][nextChessman]) {
                            visited[nextX][nextY][nextChessman] = true;
                            queue.add(new int[]{nextX, nextY, nextChessman});
                        }
                    }
                }
            }
            movesCount++;
        }

        System.out.println("-1");
    }
}
