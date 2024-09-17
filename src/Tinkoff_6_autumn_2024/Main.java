package Tinkoff_6_autumn_2024; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        long[] executionTime = new long[n];

        List<List<Integer>> dependencies = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dependencies.add(new ArrayList<>());
        }

        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().trim().split("\\s+");
            executionTime[i] = Long.parseLong(line[0]);

            for (int j = 1; j < line.length; j++) {
                int k = Integer.parseInt(line[j]);
                dependencies.get(k - 1).add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        long[] completionTime = new long[n];

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                completionTime[i] = executionTime[i];
            }
        }

        long minTotalTime = 0;

        while (!queue.isEmpty()) {
            int currentProcess = queue.poll();

            minTotalTime = Math.max(minTotalTime, completionTime[currentProcess]);


            for (int dependent : dependencies.get(currentProcess)) {
                completionTime[dependent] = Math.max(completionTime[dependent],
                        completionTime[currentProcess] + executionTime[dependent]);

                inDegree[dependent]--;

                if (inDegree[dependent] == 0) {
                    queue.add(dependent);
                }
            }
        }

        System.out.println(minTotalTime);
    }
}
