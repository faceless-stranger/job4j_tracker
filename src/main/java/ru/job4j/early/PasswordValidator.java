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
        if (isNotDigital(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (isNotSymbol(password)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (validPassword(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }

        return password;
    }

    public static boolean isNotDigital(String password) {
        boolean rsl = true;
        char[] array = password.toCharArray();
        for (int i = 0; i < array.length; i++) {
           if (Character.isDigit(array[i])) {
              rsl = false;
              break;
           }
        }
        return rsl;
    }

    public static boolean isNotSymbol(String password) {
        boolean rsl = true;
        char[] array = password.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char ch = array[i];
            if (!Character.isDigit(array[i]) && !Character.isLetter(array[i])) {
                rsl = false;
                break;
            }
        }
        return rsl;
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