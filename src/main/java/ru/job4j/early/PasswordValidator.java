package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (password.equals(password.toLowerCase())) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (password.equals(password.toUpperCase())) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }

        boolean isNotDigital = false;
        boolean isNotSymbol = false;
        char[] arrayChar = password.toCharArray();
        for (char index: arrayChar) {
            if (Character.isDigit(index)) {
                isNotDigital = true;
            }
            if (!Character.isDigit(index) && !Character.isLetter(index)) {
                isNotSymbol = true;
            }
        }
        if (!isNotDigital) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!isNotSymbol) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (validPassword(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }

        return password;
    }

    public static boolean validPassword(String password) {
        String[] dictionary = new String[]{"qwerty", "12345", "password", "admin", "user"};
        for (String index: dictionary) {
            if (password.toLowerCase().contains(index)) {
                return true;
            }
        }
        return false;
    }
}