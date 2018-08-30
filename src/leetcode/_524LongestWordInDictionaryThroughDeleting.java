package leetcode;

import java.util.List;

public class _524LongestWordInDictionaryThroughDeleting {

    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        for (String dict : d) {
            for (int i = 0, j = 0; i < s.length() && j < dict.length(); i++) {
                if (s.charAt(i) == dict.charAt(j))
                    j++;
                if (j == dict.length()) {
                    if (dict.length() > longest.length()
                            || (dict.length() == longest.length() && dict.compareTo(longest) < 0)) {
                        longest = dict;
                    }
                }
            }
        }
        return longest;
    }

}
