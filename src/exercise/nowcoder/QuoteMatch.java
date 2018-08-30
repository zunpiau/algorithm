package exercise.nowcoder;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * https://www.nowcoder.com/questionTerminal/98d6fa0bd6184b03a503febcee1b1082
 */
public class QuoteMatch {

    public static void main(String[] args) {
        String[] lines = new String[]{"()", "(()", ")()"};
        int n = lines.length;
        int count = 0;
        Integer[] stacks = new Integer[n];
        for (int i = 0; i < n; i++) {
            stacks[i] = match(lines[i]);
            if (stacks[i] != null && stacks[i] == 0)
                count++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && stacks[i] != null && stacks[j] != null && stacks[i] <= 0 && stacks[i] + stacks[j] == 0)
                    count++;
            }
        }
        System.out.println(count);
    }

    private static Integer match(String s) {
        LinkedBlockingDeque<Character> stack = new LinkedBlockingDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                stack.push('(');
            else if (stack.isEmpty() || stack.peek() != '(')
                stack.push(')');
            else
                stack.pop();
        }
        boolean hasLeft = stack.contains('(');
        if (hasLeft && stack.contains(')')) return null;
        return stack.size() * (hasLeft ? -1 : 1);
    }

}
