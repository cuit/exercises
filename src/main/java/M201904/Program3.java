package M201904;

import java.util.Scanner;

/**
 * [快手2019年春季校园招聘]
 * <p>
 * [编程题] 求x到y的最少计算次数
 * <p>
 * 给定两个-100到100的整数x和y,对x只能进行加1，减1，乘2操作，问最少对x进行几次操作能得到y？
 * 例如：
 * a=3,b=11: 可以通过3*2*2-1，3次操作得到11；
 * a=5,b=8：可以通过(5-1)*2，2次操作得到8；
 * <p>
 * <p>
 * 输入描述:
 * 输入以英文逗号分隔的两个数字，数字均在32位整数范围内。
 * <p>
 * 输出描述:
 * 输出一个数字
 * <p>
 * 输入例子1:
 * 3,11
 * <p>
 * 输出例子1:
 * 3
 * <p>
 * created by XSC on 2019/4/27 14:23
 */
public class Program3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            String[] strings = input.split(",");
            int x = Integer.parseInt(strings[0]);
            int y = Integer.parseInt(strings[1]);
            System.out.println(process(x, y));
        }
    }

    /**
     * 计算次数
     *
     * @param x
     * @param y
     * @return
     */
    private static int process(int x, int y) {
        int result = 0;
        if (y % 2 == 0) {
            result = getCount(x, y);
        } else {
            result = Math.min(getCount(x, y + 1), getCount(x, y - 1)) + 1;
        }
        return result;
    }

    /**
     * 获取y是偶数的情况下，x转变成y所需的次数
     *
     * @param x 变量x
     * @param y 变量y（前提是偶数）
     * @return 所需次数
     */
    private static int getCount(int x, int y) {
        int result = 0;
        int right = y;
        int middle = y / 2;
        while (Math.abs(right - x) > Math.abs(middle - x)) {
            result++;
            right = middle;
            middle = middle / 2;
        }
        result = result + Math.abs(right - x);
        return result;
    }

}
