package codewars;

public class SpinWord {

    public static void main(String[] args) {
        System.out.println(new SpinWord().spinWords("Hey test warriors"));
    }

    public String spinWords(String sentence) {
        StringBuilder builder = new StringBuilder(sentence);
        builder.append(' ');
        for (int lastSpace = -1, i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == ' ') {
                if (i - lastSpace > 5) {
                    System.out.println(i);
                    reverse(builder, lastSpace + 1, i - 1);
                }
                lastSpace = i;
            }
        }
        return builder.deleteCharAt(builder.length() - 1).toString();
    }

    private void reverse(StringBuilder builder, int start, int end) {
        char head;
        for (; start < end; start++, end--) {
            head = builder.charAt(start);
            builder.setCharAt(start, builder.charAt(end));
            builder.setCharAt(end, head);
        }
    }

}
