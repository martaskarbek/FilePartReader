package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {

    FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        List<String> orderedAlphabetically = new ArrayList<>();
        String toCut = filePartReader.readLines("src/main/java/org/example/test.txt", 1, 8);
        String[] slicedString = toCut.split(" ");
        String[] propertWords = wordsWithoutUnneccessarySigns(slicedString);
        for (String string : propertWords) {
            orderedAlphabetically.add(string);
        }
        Collections.sort(orderedAlphabetically);
        return orderedAlphabetically;
    }

    public  List<String> getWordsContainingSubstring (String subString) throws IOException {
        List<String> containingSubstring = new ArrayList<>();
        String toCut = filePartReader.readLines("src/main/java/org/example/test.txt", 1, 5);
        String[] slicedString = toCut.split(" ");
        String[] propertWords = wordsWithoutUnneccessarySigns(slicedString);
        for (String string : propertWords) {
            if (string.contains(subString)) {
                containingSubstring.add(string);
            }
        }
        return containingSubstring;
    }

    public List<String> getStringsWhichPalindromes () throws IOException {
        List<String> palindromes = new ArrayList<>();
        String toCut = filePartReader.readLines("src/main/java/org/example/test.txt", 3, 7);
        String[] slicedString = toCut.split(" ");
        String[] propertWords = wordsWithoutUnneccessarySigns(slicedString);
        for (String string : propertWords) {
            StringBuffer finalPalindrome = new StringBuffer();
            char[] strAsCharArray = string.toCharArray();
            char[] result = new char[strAsCharArray.length];
            for (int i = 0; i < strAsCharArray.length; i++) {
                result[i] = strAsCharArray[strAsCharArray.length - i - 1];
                finalPalindrome.append(result[i]);
            }
            palindromes.add(finalPalindrome.toString());
        }
        return palindromes;
    }

    public String[] wordsWithoutUnneccessarySigns(String[] slicedString) {
        List<String> words = new ArrayList<>();
        int i = 0;
        for (; i < slicedString.length; i++) {
            char[] wordChars = slicedString[i].toCharArray();
            StringBuilder newWord = new StringBuilder();
            for (int y = 0; y < wordChars.length; y++) {
                if (Character.isLetter(wordChars[y])) {
                    newWord.append(wordChars[y]);
                }
                else if (!Character.isLetter(wordChars[y])) {
                    continue;
                }
            }
            if (!newWord.toString().equals("")) {
                words.add(newWord.toString());
            }
        }
        String[] changedWords = new String[words.size()];
        for (int z = 0; z <  words.size(); z++) {
            changedWords[z] = words.get(z);
        }
        return changedWords;
    }

}
