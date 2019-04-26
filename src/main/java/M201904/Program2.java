package M201904;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 滴滴出行2018校园招聘
 * <p>
 * 给定一个m行n列的二维地图, 初始化每个单元都是水.
 * 操作addLand 把单元格(row,col)变成陆地.
 * 岛屿定义为一系列相连的被水单元包围的陆地单元, 横向或纵向相邻的陆地称为相连(斜对角不算).
 * 在一系列addLand的操作过程中, 给出每次addLand操作后岛屿的个数.
 * 二维地图的每条边界外侧假定都是水.
 * <p>
 * 输入描述:
 * 多组测试数据，请参考例题处理 每组数据k+3行, k表示addLand操作次数 第一行:表示行数m 第二行:表示列数n 第三行:表示addLand操作次数k 第4~k+3行:row col 表示addLand的坐标。注意超过边界的坐标是无效的。
 * <p>
 * 输出描述:
 * 一行,k个整数, 表示每次addLand操作后岛屿的个数, 用空格隔开，结尾无空格
 * <p>
 * 输入例子1:
 * 3
 * 3
 * 4
 * 0 0
 * 0 1
 * 1 2
 * 2 1
 * <p>
 * 输出例子1:
 * 1 1 2 3
 * <p>
 * created by XSC on 2019/4/21 22:22
 */
public class Program2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        if (m <= 0) {
            return;
        }
        int n = scanner.nextInt();
        if (n <= 0) {
            return;
        }
        int k = scanner.nextInt();
        if (k <= 0) {
            return;
        }
        scanner.nextLine();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String string = scanner.nextLine();
            String[] strings = string.split(" ");
            if (strings.length != 2) {
                continue;
            }
            if (isNum(strings[0]) && isNum(strings[1])) {
                list.add(Integer.parseInt(strings[0]));
                list.add(Integer.parseInt(strings[1]));
            }
        }
        // 打标的点
        Point[] points = new Point[list.size() / 2];
        for (int i = 0, j = 0; i < list.size(); i = i + 2, j++) {
            points[j] = new Point(list.get(i), list.get(i + 1));
        }
        process(m, n, k, points);
    }

    private static void process(int m, int n, int k, Point[] points) {
        Point[][] map = new Point[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = new Point(i, j);
            }
        }
        StringBuilder sb = new StringBuilder();
        int lastResult = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < i; j++) {
                if (points[j].getX() < m && points[j].getY() < n) {
                    map[points[j].getX()][points[j].getY()].setFlag(true);
                }
            }
            int result = 0;
            reset(map);
            for (int j = 0; j < i; j++) {
                if (points[j].getX() < m && points[j].getY() < n) {
                    if (!map[points[j].getX()][points[j].getY()].isVisited()) {
                        result++;
                    }
                    render(map, points[j]);
                }
            }
            if (result > 0) {
                lastResult = result;
            }
            sb.append(result > 0 ? result : lastResult).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void reset(Point[][] coordinates) {
        for (Point[] coordinate : coordinates) {
            for (int j = 0; j < coordinates[0].length; j++) {
                coordinate[j].setVisited(false);
            }
        }
    }

    private static void render(Point[][] map, Point point) {
        if (map[point.getX()][point.getY()].isFlag() && !map[point.getX()][point.getY()].isVisited()) {
            map[point.getX()][point.getY()].setVisited(true);
            if (point.getX() + 1 < map.length) {
                render(map, map[point.getX() + 1][point.getY()]);
            }
            if (point.getY() + 1 < map[0].length) {
                render(map, map[point.getX()][point.getY() + 1]);
            }
            if (point.getX() - 1 >= 0) {
                render(map, map[point.getX() - 1][point.getY()]);
            }
            if (point.getY() - 1 >= 0) {
                render(map, map[point.getX()][point.getY() - 1]);
            }
        }
    }

    private static boolean isNum(String string) {
        if (string == null || string.length() == 0) {
            return false;
        }
        boolean flag = true;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= '0' && string.charAt(i) <= '9') {
                continue;
            }
            flag = false;
            break;
        }
        return flag;
    }

    private static class Point {

        private int x;

        private int y;

        private boolean isVisited;

        private boolean flag;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return x;
        }

        void setX(int x) {
            this.x = x;
        }

        int getY() {
            return y;
        }

        void setY(int y) {
            this.y = y;
        }

        boolean isVisited() {
            return isVisited;
        }

        void setVisited(boolean visited) {
            isVisited = visited;
        }

        boolean isFlag() {
            return flag;
        }

        void setFlag(boolean flag) {
            this.flag = flag;
        }
    }

}
