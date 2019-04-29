package M201904;

import java.util.Scanner;

/**
 * 快手2019年春季校园
 * <p>
 * [编程题] 机器人移动范围
 * <p>
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * <p>
 * 输入描述:
 * 一行三个正整数由空格分开，分别代表行数m，列数n，和坐标数位之和的阈值k，0 < m <= 100, 0 < n <= 100, 0 < k <= 20。
 * <p>
 * 输出描述:
 * 一个正整数，代表该机器人能够到达的格子数量。
 * <p>
 * 输入例子1:
 * 3 3 6
 * <p>
 * 输出例子1:
 * 9
 * <p>
 * created by XSC on 2019/4/29 22:31
 */
public class Program7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            String[] strings = input.split(" ");
            int m = Integer.parseInt(strings[0]);
            int n = Integer.parseInt(strings[1]);
            int k = Integer.parseInt(strings[2]);
            System.out.println(process(m, n, k));
        }
    }

    private static int process(int m, int n, int k) {
        Label[][] map = new Label[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = new Label(i, j);
            }
        }
        render(map, map[0][0], k);
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].flag) {
                    result++;
                }
            }
        }
        return result;
    }

    private static void render(Label[][] map, Label label, int k) {
        if (!map[label.x][label.y].flag && map[label.x][label.y].getSum() <= k) {
            map[label.x][label.y].flag = true;
            if (label.x + 1 < map.length) {
                render(map, map[label.x + 1][label.y], k);
            }
            if (label.x - 1 >= 0) {
                render(map, map[label.x - 1][label.y], k);
            }
            if (label.y + 1 < map[0].length) {
                render(map, map[label.x][label.y + 1], k);
            }
            if (label.y - 1 >= 0) {
                render(map, map[label.x][label.y - 1], k);
            }
        }
    }

    private static int getSum(String num) {
        int result = 0;
        for (int i = 0; i < num.length(); i++) {
            result += Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        return result;
    }

    private static class Label {

        int x;

        int y;

        int sum;

        boolean flag;

        public Label(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getSum() {
            return Program7.getSum(String.valueOf(x) + String.valueOf(y));
        }
    }
}
