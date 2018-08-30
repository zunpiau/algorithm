package codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class WhichAreIn {

    public static void main(String[] args) {
        String a[] = new String[]{"arp", "live", "strong"};
        String b[] = new String[]{"lively", "alive", "harp", "sharp", "armstrong"};
        String r[] = new String[]{"arp", "live", "strong"};
        System.out.println(Arrays.toString(WhichAreIn.inArray(a, b)));
    }

    public static String[] inArray(String[] array1, String[] array2) {
        ArrayList<String> strings = new ArrayList<>(array1.length);
        for (String s : array1) {
            for (String s2 : array2) {
                if (s2.contains(s)) {
                    strings.add(s);
                    break;
                }
            }
        }
        strings.sort(Comparator.naturalOrder());
        return strings.toArray(new String[0]);
    }

}
