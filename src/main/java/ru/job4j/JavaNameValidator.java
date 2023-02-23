package ru.job4j;

public class JavaNameValidator {
    public static boolean isNameValid(String name) {
        if (name.isEmpty() || !Character.isLowerCase(name.charAt(0))) {
            System.out.println("first if");
            return false;
        }
        for (int index = 1; index < name.length(); index++) {
            System.out.println(index);
            int code = name.codePointAt(index);
            System.out.println(code);
            if (!(isSpecialSymbol(code) || isUpperLatinLetter(code)
                || isLowerLatinLetter(code) || Character.isDigit(name.charAt(index)))) {
                System.out.println("because of " + index);
                return false;
            }
        }
        return true;
    }

    public static boolean isSpecialSymbol(int code) {
        return code == 36 || code == 95;
    }

    public static boolean isUpperLatinLetter(int code) {
        return code >= 65 && code <= 90;
    }

    public static boolean isLowerLatinLetter(int code) {
        return code >= 97 && code <= 122;
    }

    public static void main(String[] args) {
        System.out.println(isNameValid("fIRST"));
    }
}
