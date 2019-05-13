package M201905;

import java.util.Scanner;

/**
 * 网易2019秋招
 *
 * [编程题] 相等序列
 * 时间限制：1秒
 * <p>
 * 空间限制：262144K
 * <p>
 * 题目给定a1,a2...an，这样一个长度为n的序列，现在你可以给其中一些元素加上一个值x（只能加一次），然后可以给另外一些值减上一个值x（只能减一次），剩下的元素不能再进行操作。问最后有没有可能找到一个值x使所有元素的值相等。
 * <p>
 * 输入描述:
 * 输入第一行为一个整数k，代表有k个序列(k<100)，接下来有2*k行:
 * 偶数行为一个整数n，代表给定序列的长度(1<=n<=100,000)
 * 奇数行包含n个元素，a1,a2...an，代表序列中的元素(0<=ai<=100,000)
 * <p>
 * <p>
 * 输出描述:
 * 输出k行，每行一个YES或者NO
 * <p>
 * 输入例子1:
 * 1
 * 5
 * 1 3 3 2 1
 * <p>
 * 输出例子1:
 * YES
 * <p>
 * created by XSC on 2019/5/12 17:15
 */
public class Program3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int k = scanner.nextInt();
            while (k-- > 0) {
                int n = scanner.nextInt();
                int max = 0;
                int min = 0;
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = scanner.nextInt();
                    if (i == 0) {
                        max = a[i];
                        min = a[i];
                    } else {
                        max = a[i] > max ? a[i] : max;
                        min = a[i] < min ? a[i] : min;
                    }
                }
                if (max == min) {
                    System.out.println("YES");
                } else {
                    // 有三种情况，都变成最小值，都变成最大值，如果可以尝试中间值
                    boolean flag = check(a, min);
                    if (!flag) {
                        flag = check(a, max);
                    }
                    if (!flag && (max + min) % 2 == 0) {
                        flag = check(a, (max + min) / 2);
                    }
                    if (flag) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }
            }
        }
    }

    private static boolean check(int[] a, int n) {
        boolean flag = true;
        int gap = 0;
        for (int i = 0; i < a.length; i++) {
            if (Math.abs(a[i] - n) != 0) {
                if (gap != 0) {
                    if (Math.abs(a[i] - n) != gap) {
                        flag = false;
                        break;
                    }
                } else {
                    gap = Math.abs(a[i] - n);
                }
            }
        }
        return flag;
    }
}
