package exercise;

import java.util.Arrays;
import java.util.List;

/*
 * 字符串分割后排序 <a href=https://www.v2ex.com/t/406880>t/406880</a>
 */
public class SplitSort {

    public static void main(String[] args) {
        new SplitSort().sort(Arrays.asList("a.b.c", "a.b", "a.ab", "c"))
                .forEach(System.out::println);
    }

    public List<String> sort(List<String> array) {
        array.sort((o1, o2) -> {
            String[] spilt1 = o1.split("\\.");
            String[] spilt2 = o2.split("\\.");
            int compare = 0;
            for (int i = 0; i < spilt1.length && i < spilt2.length; i++) {
                compare = spilt1[i].compareTo(spilt2[i]);
                if (compare != 0)
                    break;
            }
            return (compare == 0) ? Integer.compare(spilt1.length, spilt2.length) : compare;
        });
        return array;
    }

}
