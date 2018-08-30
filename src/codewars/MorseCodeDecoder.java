package codewars;

public class MorseCodeDecoder {

    public static void main(String[] args) {
        System.out.println(MorseCodeDecoder.decode(". . .   -- .."));
    }

    public static String decode(String morseCode) {
        StringBuilder builder = new StringBuilder();
        morseCode = morseCode.trim();
        for (int i = 0, word = 0; ; ) {
            if (i + 2 < morseCode.length() && isSpaceAt(morseCode, i) && isSpaceAt(morseCode, i + 1) && isSpaceAt(morseCode, i + 2)) {
                builder.append(MorseCode.get(morseCode.substring(word, i)));
                builder.append(' ');
                i += 3;
                word = i;
            } else if (i == morseCode.length() - 1) {
                builder.append(MorseCode.get(morseCode.substring(word, i + 1)));
                break;
            } else if (isSpaceAt(morseCode, i)) {
                System.out.println(i);
                builder.append(MorseCode.get(morseCode.substring(word, i)));
                i += 1;
                word = i;
            } else {
                i++;
            }
        }
        return builder.toString();
    }

    private static boolean isSpaceAt(String s, int index) {
        return s.charAt(index) == ' ';
    }

    private static class MorseCode {

        private static String get(String s) {
            System.out.println(s);
            if (s.equals("--"))
                return "A";
            if (s.equals(".."))
                return "B";
            if (s.equals("-"))
                return "C";
            if (s.equals("."))
                return "D";
            return "L";
        }
    }
}