package codewars;

public class ConvertStringToCamelCase {

    public static void main(String[] args) {
        System.out.println(ConvertStringToCamelCase.toCamelCase("the-stealth-warrior"));
        System.out.println(ConvertStringToCamelCase.toCamelCase("The_Stealth_Warrior"));
    }

    static String toCamelCase(String s) {
        StringBuilder builder = new StringBuilder(s.trim());
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == '-' || builder.charAt(i) == '_') {
                builder.setCharAt(i + 1, Character.toUpperCase(builder.charAt(i + 1)));
                builder.deleteCharAt(i--);
            }
        }
        return builder.toString();
    }

}
