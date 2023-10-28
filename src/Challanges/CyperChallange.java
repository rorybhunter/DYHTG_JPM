package Challanges;

import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

public class CyperChallange extends Challange {

    protected Window frame = new Window(500, 500, "Spooky Puzzle - Cyper", this, new Color(232, 167, 63));


    @Override
    public boolean run() {

        String[] words = new String[] { "String", "StringTwo" };
        String word = words[0];
        char[] wordarray = word.toCharArray();
        frame.addLabel("Can you guess the Halloween Phrase", 10, 10);

        StringBuilder result = new StringBuilder();
        int offset = ThreadLocalRandom.current().nextInt(1, 5);
        for (char character : wordarray) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
                System.out.println(newCharacter + " " + character);
            } else {
                result.append(character);
            }
        }
        String resultString = result.toString();
        frame.addLabel(resultString, 10, 50);
        try {
            boolean answer = frame.getAnswer("", word);
            return answer;
        } catch (InterruptedException e) {
            System.out.println("ERROR: Timeout");
        }
        return false;
    }

    public void exit(){
        frame.exit();
    }
}
