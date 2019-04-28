package M201904;

import java.util.Scanner;

/**
 * 快手2019年春季校园招聘
 * <p>
 * [编程题] 阶乘末尾非零数字
 * <p>
 * 输入N，求N！末尾的第一个非零数字。如6 ! = 720，因此6的阶乘末尾的非零位是2。
 * <p>
 * 输入描述:
 * 仅一行，包含一个整数N（0<=N<=10,000,000）
 * <p>
 * 输出描述:
 * 仅一行，包含一个整数，表示最右边的非零的值
 * <p>
 * 输入例子1:
 * 6
 * <p>
 * 输出例子1:
 * 2
 * <p>
 * created by XSC on 2019/4/28 22:55
 */
public class Program4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(getLastNotZeroNum(n));
        }
    }

    private static int getLastNotZeroNum(int n) {
        int result = 1;
        for (int i = n; i >= 2; i--) {
            result = getRemainder(result * getRemainder(i));
        }
        return result;
    }

    /**
     * 获取一个数的余数
     *
     * @param x 当前数
     * @return 余数
     */
    private static int getRemainder(int x) {
        if (x % 10 == 0) {
            return getLast(x);
        } else {
            return x % 10;
        }
    }

    /**
     * 如果当前数以0结尾的数，从后获取第一个不为0的数
     *
     * @param x 当前数
     * @return 从后获取第一个不为0的数
     */
    private static int getLast(int x) {
        String s = String.valueOf(x);
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                return Integer.parseInt(String.valueOf(s.charAt(i)));
            }
        }
        return 0;
    }

}
