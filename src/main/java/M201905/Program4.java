package M201905;

import java.util.Scanner;

/**
 * created by XSC on 2019/5/12 17:58
 */
public class Program4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] a = new int[n][2];
            scanner.nextLine();
            for (int i = 0; i < n; i++) {
                String str = scanner.nextLine();
                String[] strings = str.split(" ");
                a[i][0] = Integer.parseInt(strings[0]);
                a[i][1] = Integer.parseInt(strings[1]);
            }

        }
    }

}
