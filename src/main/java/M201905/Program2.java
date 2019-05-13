package M201905;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * created by XSC on 2019/5/12 16:33
 */
public class Program2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            scanner.nextLine();
            String input = scanner.nextLine();
            System.out.println(process(n, k, input));
        }
    }

    private static int process(int n, int k, String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character character : str.toCharArray()) {
            if (map.containsKey(character)) {
                map.put(character, map.get(character) + 1);
            } else {
                map.put(character, 1);
            }
        }
        List<Integer> countList = new ArrayList<>(map.values());
        Collections.sort(countList, (o1, o2) -> o2 - o1);
        int count = 0;
        int result = 0;
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < countList.size(); i++) {
            if (countList.get(i) > k - count) {
                resultList.add(k - count);
                break;
            } else {
                resultList.add(countList.get(i));
                count += countList.get(i);
            }
        }
        for (Integer integer : resultList) {
            result += integer * integer;
        }
        return result;
    }

}
