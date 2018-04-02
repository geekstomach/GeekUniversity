package Lesson3;

import java.util.Random;
import java.util.Scanner;

public class guessTheWord {
    private static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
            "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
            "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
            "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {

        System.out.println("Сыграем в игру угодай слово на английском?");

            compare(words[random(words.length)]);
        }




    public static int random(int length) {
        Random random = new Random();
        return random.nextInt(length);
    }

    public static void compare(String wordGuess) {
        Scanner sc = new Scanner(System.in);
        String wordThink = sc.next();
        do {
            String gessedLetter = "";
            for (int i = 0; i < wordGuess.length(); i++) {
                for (int j = i; j < wordThink.length(); j++) {
                    if ((i == j) && (wordGuess.charAt(i) == wordThink.charAt(j))) {
                        gessedLetter = gessedLetter + wordGuess.charAt(i);
                        break;
                    } else {
                        if ((i == j) && (wordGuess.charAt(i) != wordThink.charAt(j)))
                            gessedLetter = gessedLetter + "#";
                    }
                }
            }
            gessedLetter = gessedLetter + "##############";
            System.out.println("Слово не угадано( возможно некоторые буквы стоят на своих местах?\n"+gessedLetter+"\nПопробуй снова! ");
        wordThink = sc.next();
        } while (!wordGuess.equals(wordThink));
        System.out.println("Ну вот Вы и угадали");
    }

}
