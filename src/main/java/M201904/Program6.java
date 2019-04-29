package M201904;

import java.util.Scanner;

/**
 * 快手2019年春季校园招聘
 * <p>
 * [编程题] 二进制中有多少个1
 * <p>
 * 把一个32-bit整型转成二进制，其中包含多少个1，比如5的二进制表达是101，其中包含2个1
 * <p>
 * <p>
 * 输入描述:
 * 输入为整型（十进制），只需兼容32-bit即可，如5、32
 * <p>
 * 输出描述:
 * 输出为字符串，如“2”、“1”
 * <p>
 * 输入例子1:
 * 5
 * <p>
 * 输出例子1:
 * 2
 * <p>
 * 例子说明1:
 * 5的二进制是101，其中包含2个1
 * <p>
 * created by XSC on 2019/4/29 22:12
 */
public class Program6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(process(n));
        }
    }

    private static int process(int n) {
        String str = getBinary(n);
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                result++;
            }
        }
        return result;
    }

    private static String getBinary(int n) {
        StringBuilder sb = new StringBuilder();
        int remainder = n % 2;
        int quotient = n / 2;
        sb.append(remainder);
        while (quotient > 1) {
            remainder = quotient % 2;
            quotient = quotient / 2;
            sb.append(remainder);
        }
        sb.append(quotient);
        return sb.reverse().toString();
    }
}
