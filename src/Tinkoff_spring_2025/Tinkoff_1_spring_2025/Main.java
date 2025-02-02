package Tinkoff_spring_2025.Tinkoff_1_spring_2025;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();

        System.out.println(data.indexOf('R') < data.indexOf('M') ? "Yes" : "No");
    }
}