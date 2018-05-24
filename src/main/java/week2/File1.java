package week2;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.Set;

/**
 * @author: XSC
 * @date: 2018/5/24 21:36
 */
public class File1 {

    public static void main(String[] args) {
        Multiset<String> multiset = HashMultiset.create();
        String[] str = new String[]{"wer", "dffd", "ddsa", "dfd", "dreg", "de", "dr", "ce", "ghrt", "cf", "gt", "ser", "tg", "ghrt", "cf", "gt"};
        for (int i = 0; i < str.length; i++) {
            multiset.add(str[i]);
        }

        // 包括元素
        Set<String> set = multiset.elementSet();
        for (String s : set) {
            System.out.println(s);
        }

        // 包括元素及出现次数
        Set<Multiset.Entry<String>> entrySet = multiset.entrySet();
        for (Multiset.Entry<String> entry : entrySet) {
            System.out.println(entry.getElement() + " count: " + entry.getCount());
        }
    }
}
