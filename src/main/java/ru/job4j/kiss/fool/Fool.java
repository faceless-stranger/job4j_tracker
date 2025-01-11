package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {

    private int value = 1;

    public static void main(String[] args) {
        String user;
        Scanner sc = new Scanner(System.in);
        Fool fool = new Fool();
        System.out.println("Добро пожаловать в игру FizzBuzz, что бы начать игру нажми любую кнопку, "
                +  "\n для прочтения обучение нажми 1 ");
        if (sc.nextLine().equals("1")) {
            fool.gameInfo();
        }
        System.out.println("Началась игра FizzBuzz");
        while (fool.value < 100) {
            System.out.println("Компьютер: " + fool.getFizzBuzzAnswer());
            System.out.print("Ваш ход: ");
            user = sc.nextLine();
            if (!user.equals(fool.getFizzBuzzAnswer())) {
                System.out.println("Ошибка. Начинай снова.");
                fool.value = 1;
            }
        }
        System.out.println("Поздравляю с победой игрок");
    }

    public String getFizzBuzzAnswer() {
        String result = (value % 15 == 0) ? "FizzBuzz"
                : (value % 3 == 0)  ? "Fizz"
                : (value % 5 == 0)  ? "Buzz"
                : String.valueOf(value);
        value++;
        return result;
    }

    public void gameInfo() {
        System.out.println(
                "Правила игры FizzBuzz:\n"
                        + "1. Игроки по очереди называют числа по порядку, начиная с 1.\n"
                        + "2. Если число кратно 3, нужно сказать 'Fizz',\n"
                        + "   если число кратно 5, нужно сказать 'Buzz',\n"
                        + "   а если число кратно и 3, и 5 – 'FizzBuzz'.\n"
                        + "3. В остальных случаях нужно просто назвать текущее число.\n"
                        + "4. Если игрок ошибается, игра начинается заново с 1.\n"
        );
    }

}