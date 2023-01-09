package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book potter = new Book("potter", 400);
        Book bible = new Book("bible", 1100);
        Book craft = new Book("craft", 300);
        Book cleanCode = new Book("Clean code", 350);
        Book[] books = new Book[4];
        books[0] = potter;
        books[1] = bible;
        books[2] = craft;
        books[3] = cleanCode;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println(bk.getName() + " - " + bk.getPages());
        }
        Book ref = books[0];
        books[0] = books[3];
        books[3] = ref;
        System.out.println("");
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println(bk.getName() + " - " + bk.getPages());
        }
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            if ("Clean code" == bk.name) {
                System.out.println(bk.name);
            }
        }
    }
}
