package Tinkoff_3_summer_2024; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        TreeMap<String, TreeMap> dirTree = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String path = sc.nextLine();
            String[] levels = path.split("/");

            TreeMap<String, TreeMap> currentLevel = dirTree;

            for (String level : levels) {
                currentLevel.putIfAbsent(level, new TreeMap<String, TreeMap>());
                currentLevel = currentLevel.get(level);
            }
        }
        sc.close();

        showDirectories(dirTree, "");
    }

    public static void showDirectories(TreeMap<String, TreeMap> currentLevel, String indent) {
        for (String dir : currentLevel.keySet()) {
            System.out.println(indent + dir);
            showDirectories(currentLevel.get(dir), indent + "  ");
        }
    }
}