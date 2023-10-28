package Challanges;

import java.util.concurrent.ThreadLocalRandom;


public class CyperChallange extends Challange{

    @Override
    public void run() {
        Window frame = new Window(500,500, "Spooky Puzzle - Cyper", this);

        String[] words = new String[]{"String","StringTwo"};
        String word = words[0];
        char[]wordarray = word.toCharArray();
        //frame.addLabel(word);

        StringBuilder result = new StringBuilder();
        int offset = ThreadLocalRandom.current().nextInt(1, 5);
        for (char character : wordarray){
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
                System.out.println(newCharacter + " " +  character);
            } else {
                result.append(character);
            }
        }
        String resultString = result.toString();
        frame.addLabel(resultString);
    }
}
