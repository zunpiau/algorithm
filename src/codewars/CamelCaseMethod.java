package codewars;

public class CamelCaseMethod {

    public static void main(String[] args) {
        CamelCaseMethod.camelCase("ab  c");
    }

    public static String camelCase(String str) {
        str = str.trim();
        if (str.equals("")) return "";
        StringBuilder builder = new StringBuilder(str);
        toUpperCaseAt(builder, 0);
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == ' ') {
                toUpperCaseAt(builder, i + 1);
                builder.deleteCharAt(i--);
            }
        }
        return builder.toString();
    }

    private static void toUpperCaseAt(StringBuilder builder, int i) {
        builder.setCharAt(i, Character.toUpperCase(builder.charAt(i)));
    }

}
