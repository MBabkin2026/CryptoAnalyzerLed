package com.javarush.babkin;

import java.util.Map;
import java.util.Set;

public class Cryptoway {
    public static char[] incrypt(char[] input, int keyKrypt) {

        int key = keyKrypt;
        String scrText = "";

        for (char symb : input) {
            if (Dictionary.DICTIONARY.containsKey(symb)) {

                int value = (Dictionary.DICTIONARY.get(symb) + key) % Dictionary.getLengthCharSymbols();
                char scryptText = getKeyToValue(Dictionary.DICTIONARY, value);
                scrText = scrText + scryptText;
            } else {
                scrText = scrText + symb;
            }
        }
        char[] outCharArray = scrText.toCharArray();
        return outCharArray;

    }

    public static char[] dicrypt(char[] input, int keyKrypt) {

        int key = keyKrypt;
        String scrText = "";

        for (char symb : input) {
            if (Dictionary.DICTIONARY.containsKey(symb)) {

                int value = (Dictionary.DICTIONARY.get(symb) - key) % Dictionary.getLengthCharSymbols();
                char scryptText = getKeyToValue(Dictionary.DICTIONARY, value);
                scrText = scrText + scryptText;
            } else {
                scrText = scrText + symb;
            }
        }
        char[] outCharArray = scrText.toCharArray();
        return outCharArray;

    }



    public static Character getKeyToValue (Map map, Integer value){
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for(Map.Entry<Character, Integer> pair : entries) {
            if (pair.getValue().equals(value)) {
                return pair.getKey();
            }
        }
        return null;
    }
}
