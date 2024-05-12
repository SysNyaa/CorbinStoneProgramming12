package com.module2.point4;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Word {
    public static void main(String[] args) throws IOException {
        String filePath = "./resource/illiad.txt";

        Set<String> snowflakeWords = new HashSet<>();

        try (FileReader fileReader = new FileReader(filePath)) {
            Scanner scanner = new Scanner(fileReader);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Split the line into words
                String[] words = line.split("\\s+");

                // Process each word
                for (String word : words) {
                    // Remove punctuation and convert to lowercase
                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

                    // Add the cleansed word to the set no demon words here as they have been cleansed
                    if (!word.isEmpty()) {
                        snowflakeWords.add(word);
                    }
                }
            }
        }

        // Print the number of unique little snowflake words
        System.out.println("Number of snowflake words: " + snowflakeWords.size());
    }
}
