package week1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: XSC
 * @date: 2018/5/24 20:41
 */
public class File1 {

    /**
     * 统计数字
     *
     * @param str
     * @return
     */
    public static int countNum(String str) {
        int result = 0;
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            result++;
        }
        return result;
    }

    /**
     * 统计字母
     *
     * @param str
     * @return
     */
    public static int countLetter(String str) {
        int result = 0;
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            result++;
        }
        return result;
    }

    /**
     * 统计汉字
     *
     * @param str
     * @return
     */
    public static int countChinese(String str) {
        int result = 0;
        Pattern pattern = Pattern.compile("[\\u4e00-\\u9fa5]");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            result++;
        }
        return result;
    }

    /**
     * 数据存储类
     */
    public static class Count {
        String name;
        int num;

        public Count(String name, int num) {
            this.name = name;
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        @Override
        public String toString() {
            return "Count{" +
                    "name='" + name + '\'' +
                    ", num=" + num +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        String fileName = "src/main/java/week1/test.txt";
        File file = new File(fileName);
        int numCount = 0;
        int letterCount = 0;
        int chineseCount = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                numCount += countNum(str);
                letterCount += countLetter(str);
                chineseCount += countChinese(str);
            }
            Count count1 = new Count("数字个数", numCount);
            Count count2 = new Count("字母个数", letterCount);
            Count count3 = new Count("汉字个数", chineseCount);
            Count[] counts = new Count[]{count1, count2, count3};
            Arrays.sort(counts, new Comparator<Count>() {
                public int compare(Count o1, Count o2) {
                    return o2.getNum() - o1.getNum();
                }
            });
            FileWriter fileWriter = new FileWriter("src/main/java/week1/result.txt");
            for (Count count : counts) {
                fileWriter.write(count.getName() + ":" + count.getNum() + "\r\n");
            }
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
