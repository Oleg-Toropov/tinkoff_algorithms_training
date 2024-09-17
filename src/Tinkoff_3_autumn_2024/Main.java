package Tinkoff_3_autumn_2024; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String required = scanner.nextLine();
        int k = scanner.nextInt();

        System.out.println(findPassword(s, required, k));
    }

    public static String findPassword(String s, String required, int k) {
        Map<Character, Integer> requiredMap = new HashMap<>();

        for (char c : required.toCharArray()) {
            requiredMap.put(c, requiredMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0, right = 0, matched = 0;

        StringBuilder result = null;
        int startResult = -1;

        while (right < s.length()) {
            char rightChar = s.charAt(right);

            if (!requiredMap.containsKey(rightChar)) {
                right++;
                left = right;
                windowMap.clear();
                matched = 0;
                continue;
            }

            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            if (requiredMap.containsKey(rightChar) && windowMap.get(rightChar).equals(requiredMap.get(rightChar))) {
                matched++;
            }

            while (matched == requiredMap.size()) {
                int windowLength = right - left + 1;

                if (windowLength <= k) {
                    result = new StringBuilder(s.substring(left, right + 1));
                    startResult = left;
                }

                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (requiredMap.containsKey(leftChar) && windowMap.get(leftChar) < requiredMap.get(leftChar)) {
                    matched--;
                }
                left++;
            }
            right++;
        }

        if (result == null) {
            return "-1";
        }

        for (int i = startResult + result.length(); i < s.length(); i++) {
            if ((i - startResult + 1) > k || !requiredMap.containsKey(s.charAt(i))) {
                break;
            }

            result.append(s.charAt(i));
        }

        return result.toString();
    }
}
