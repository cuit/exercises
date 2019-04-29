package M201904;

import java.util.Scanner;

/**
 * 快手2019年春季校园招聘
 * <p>
 * [编程题] 字符串最小变换次数
 * <p>
 * 给定两个字符串，已知可以使用三种方式进行变换
 * 1. 插入一个字符
 * 2. 删除一个字符
 * 3. 更改一个字符
 * 请设计一个算法，找到两个字符串之间的经历几次最小变换，可以字符串1转换成字符串2
 * <p>
 * 输入描述:
 * 输入两个字符串，字符串的长度<=1000
 * <p>
 * 输出描述:
 * 最小变换次数
 * <p>
 * 输入例子1:
 * hello
 * helle
 * <p>
 * 输出例子1:
 * 1
 * <p>
 * created by XSC on 2019/4/28 23:31
 */
public class Program5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String x = scanner.nextLine();
            String y = scanner.nextLine();
            System.out.println(process(x, y));
        }
    }

    private static int process(String x, String y) {
        if (x == null || x.length() == 0) {
            return y == null ? 0 : y.length();
        }
        if (y == null || y.length() == 0) {
            return x == null ? 0 : x.length();
        }
        int sameNum = 0;
        int i;
        int j;
        int index = 0;
        for (i = 0; i < x.length(); i++) {
            for (j = index; j < y.length(); j++) {
                if (x.charAt(i) == y.charAt(j)) {
                    sameNum++;
                    index = j + 1;
                    break;
                }
            }
        }
        int minLen = Math.min(x.length(), y.length());
        return minLen - sameNum + Math.abs(x.length() - y.length());
    }
}
