package Tinkoff_summer_2024.Tinkoff_3_summer_2024; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.util.TreeMap;

public class Main_first {
    private static TreeMap<String, TreeMap> dirTree = new TreeMap<>();

    private static void addDir(String path) {
        String[] levels = path.split("/");
        TreeMap<String, TreeMap> currentLevel = dirTree;
        for (String level : levels) {
            currentLevel.putIfAbsent(level, new TreeMap<String, TreeMap>());
            currentLevel = currentLevel.get(level);
        }
    }

    private static void showDirectories(TreeMap<String, TreeMap> currentLevel, String indent) {
        for (String dir : currentLevel.keySet()) {
            System.out.println(indent + dir);
            showDirectories(currentLevel.get(dir), indent + "  ");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String path = sc.nextLine();
            addDir(path);
        }
        sc.close();

        showDirectories(dirTree, "");
    }
}

