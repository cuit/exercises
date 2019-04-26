package M201904;

import java.util.Scanner;

/**
 * 滴滴出行2018校园招聘
 * <p>
 * 给定两个数R和n，输出R的n次方，其中0.0<R<99.999, 0<n<=25
 * <p>
 * 输入描述:
 * 多组测试用例，请参考例题的输入处理 输入每行一个浮点数 R 其中0.0 < R <99.999， 一个整数 n 其中0 < n <=25
 * <p>
 * 输出描述:
 * 输出R的n次方
 * <p>
 * 输入例子1:
 * 95.123 12 0.1 1
 * <p>
 * 输出例子1:
 * 548815620517731830194541.899025343415715973535967221869852721 0.1
 * <p>
 * created by XSC on 2019/4/26 23:52
 */
public class Program1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String r = scanner.next();
        int n = scanner.nextInt();
        if (isValid(r)) {
            System.out.println(process(r, n));
        }
    }

    /**
     * 朱流程处理
     *
     * @param r 浮点数r
     * @param n n是次方
     * @return 计算后的结果
     */
    private static String process(String r, int n) {
        r = removeLastZero(r);
        String origin = r;
        int index = r.indexOf(".");
        if (index > 0) {
            r = Integer.parseInt(r.substring(0, index)) > 0 ? r.substring(0, index) + r.substring(index + 1) :
                    r.substring(index + 1);
        }
        String result = r;
        for (int i = 1; i < n; i++) {
            result = multi(result, r);
        }
        if (index > 0) {
            index = (origin.length() - index - 1) * n;
        }
        StringBuilder sb = new StringBuilder();
        if (index > 0) {
            if (result.length() > index) {
                sb.append(result, 0, result.length() - index).append(".")
                        .append(result.substring(result.length() - index));
            } else {
                for (int i = 0; i <= index - result.length(); i++) {
                    if (i == 0) {
                        sb.append("0.");
                    } else {
                        sb.append(0);
                    }
                }
                sb.append(result);
            }
        } else {
            return result;
        }
        return sb.toString();
    }

    /**
     * 两个数求乘积
     *
     * @param x x
     * @param y y
     * @return 乘积
     */
    private static String multi(String x, String y) {
        int[] m = new int[x.length()];
        int[] n = new int[y.length()];
        for (int i = x.length() - 1; i >= 0; i--) {
            m[i] = Integer.parseInt(String.valueOf(x.charAt(x.length() - 1 - i)));
        }
        for (int i = y.length() - 1; i >= 0; i--) {
            n[i] = Integer.parseInt(String.valueOf(y.charAt(y.length() - 1 - i)));
        }
        String[] strings = new String[m.length];
        for (int i = 0; i < m.length; i++) {
            StringBuilder sb = new StringBuilder();
            // 进位
            int index = 0;
            for (int j = 0; j < n.length; j++) {
                int k = m[i] * n[j] + index;
                index = 0;
                if (k > 9) {
                    sb.append(k % 10);
                    index = k / 10;
                } else {
                    sb.append(k);
                }
            }
            strings[i] = index > 0 ? sb.append(index).toString() : sb.toString();
        }
        String result = strings[0];
        for (int i = 1; i < strings.length; i++) {
            int maxLen = Math.max(result.length(), strings[i].length() + i);
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < i; j++) {
                stringBuilder.append("0");
            }
            strings[i] = stringBuilder.toString() + strings[i];
            result = assemble(result, maxLen);
            strings[i] = assemble(strings[i], maxLen);
            result = sum(result, strings[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length(); i++) {
            sb.append(result.charAt(result.length() - 1 - i));
        }
        return sb.toString();
    }

    /**
     * 不满足长度的在后面拼接0
     *
     * @param s   原始字符串
     * @param len 长度
     * @return 拼接完后的结果
     */
    private static String assemble(String s, int len) {
        for (int i = s.length(); i < len; i++) {
            s = s + "0";
        }
        return s;
    }

    /**
     * 两个数求和
     *
     * @param str1 数1
     * @param str2 数2
     * @return 求和的结果
     */
    private static String sum(String str1, String str2) {
        // 进位
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            int result = Integer.parseInt(String.valueOf(str1.charAt(i)))
                    + Integer.parseInt(String.valueOf(str2.charAt(i))) + index;
            index = 0;
            if (result > 9) {
                sb.append(result % 10);
                index = result / 10;
            } else {
                sb.append(result);
            }
        }
        return index > 0 ? sb.append(index).toString() : sb.toString();
    }

    /**
     * 判断是否是合法的浮点数
     *
     * @param str 字符串
     * @return 是否合法
     */
    private static boolean isValid(String str) {
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9' || str.charAt(i) == '.')) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 是否是合法数字
     *
     * @param str 字符串
     * @return 是否是合法数字
     */
    private static boolean isNum(String str) {
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private static String removeLastZero(String str) {
        if (str.contains(".")) {
            StringBuilder sb = new StringBuilder();
            for (int i = str.length() - 1; i >= 0; i--) {
                if (str.charAt(i) == '0') {
                    continue;
                }
                sb.append(str, 0, i + 1);
                break;
            }
            return sb.toString();
        }
        return str;
    }
}
