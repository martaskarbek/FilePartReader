package org.example;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        System.out.println(fileWordAnalyzer.getWordsOrderedAlphabetically());
        System.out.println(fileWordAnalyzer.getWordsContainingSubstring("li"));
        System.out.println(fileWordAnalyzer.getStringsWhichPalindromes());
    }

}
