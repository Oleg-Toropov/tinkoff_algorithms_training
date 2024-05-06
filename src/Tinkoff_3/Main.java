package Tinkoff_3; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        List<Integer> data = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int numberOfLines = 3;
        while (numberOfLines > 0) {
            String line = sc.nextLine();

            StringTokenizer st = new StringTokenizer(line, " ");

            while (st.hasMoreTokens()) {
                data.add(Integer.valueOf(st.nextToken()));
            }

            numberOfLines--;
        }
        sc.close();

        data.remove(0);
        int t = data.get(0);
        data.remove(0);

        int nt = data.get(data.size() - 1);
        data.remove(data.size() - 1);

        int floorNt = data.get(nt - 1);
        int timeToFloorNtBelow = floorNt - data.get(0);
        int timeToFloorNtAbove = data.get(data.size() - 1) - floorNt;

        int minNumberOfFlightsOfStairs;

        if (t >= timeToFloorNtBelow || t >= timeToFloorNtAbove) {
            minNumberOfFlightsOfStairs = data.get(data.size() - 1) - data.get(0);
        } else {
            int a = floorNt - data.get(0);
            int b = data.get(data.size() - 1) - floorNt;

            minNumberOfFlightsOfStairs = (a <= b) ? a * 2 + b : b * 2 + a;
        }

        System.out.println(minNumberOfFlightsOfStairs);
    }
}
