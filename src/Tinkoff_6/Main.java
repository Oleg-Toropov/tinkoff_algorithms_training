package Tinkoff_6; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        List<Integer> data = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int numberOfLines = 2;
        while (numberOfLines-- > 0) {
            String line = sc.nextLine();
            StringTokenizer st = new StringTokenizer(line, " ");

            while (st.hasMoreTokens()) {
                data.add(Integer.valueOf(st.nextToken()));
            }
        }
        sc.close();

        int n = data.get(0);
        data.remove(0);

        int countOdd = 0;
        int indexOdd = -1;

        int countEven = 0;
        int indexEven = -1;

        for (int i = 0; i < data.size(); i++) {
            if (i % 2 == 0) {
                if (data.get(i) % 2 == 0) {
                    countEven++;
                    indexEven = i + 1;

                    if (countEven > 1) {
                        break;
                    }
                }
            } else {
                if (data.get(i) % 2 == 1) {
                    countOdd++;
                    indexOdd = i + 1;
                }
                if (countOdd > 1) {
                    break;
                }
            }
        }



        String result = (countOdd == 1 && countEven == 1) ? indexEven + " " + indexOdd :
                (countOdd == 0 && countEven == 0 && n >= 3) ? "1 3" : "-1 -1";


        System.out.println(result);
    }
}

