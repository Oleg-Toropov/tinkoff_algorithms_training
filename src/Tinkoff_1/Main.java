package Tinkoff_1; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc.close();

        StringTokenizer st = new StringTokenizer(line, " ");
        List<Integer> data = new ArrayList<>();

        while (st.hasMoreTokens()) {
            data.add(Integer.valueOf(st.nextToken()));
        }

        int expenses = (data.get(3) > data.get(1)) ? data.get(0) + (data.get(3) - data.get(1)) * data.get(2) : data.get(0);

        System.out.println(expenses);
    }
}
