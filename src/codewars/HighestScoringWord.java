package codewars;

public class HighestScoringWord {

    public static void main(String[] args) {
        System.out.println(HighestScoringWord.high("what time are we climbing up to the volcano"));
    }

    public static String high(String s) {
        int highestScore, start, end, i, wordStart, score;
        for (highestScore = start = end = i = wordStart = score = 0; ; i++) {
            if (i == s.length() - 1) {
                score += getScoreAt(s, i);
                if (score > highestScore) {
                    return s.substring(wordStart, i + 1);
                }
                return s.substring(start, end);
            }
            if (s.charAt(i) == ' ') {
                if (score > highestScore) {
                    highestScore = score;
                    start = wordStart;
                    end = i;
                }
                score = 0;
                wordStart = i + 1;
            } else {
                score += getScoreAt(s, i);
            }
        }
    }

    private static int getScoreAt(String s, int index) {
        return s.charAt(index) - 'a' + 1;
    }

}
