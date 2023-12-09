import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Wordcounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter text or provide a file to count the words:");
        String inputText = scanner.nextLine();

        // Split the input text into an array of words using space or punctuation as delimiters
        String[] words = inputText.split("[\\s\\p{Punct}]+");

        // Initialize a counter variable to keep track of the number of words
        int wordCount = 0;

        // Create a map to store the frequency of each word
        Map<String, Integer> wordFrequency = new HashMap<>();

        // Define common stop words to ignore
        String[] stopWords = {"the", "and", "is", "in", "to", "of", "a", "for", "on"};

        // Iterate through the array of words
        for (String word : words) {
            // Increment the counter for each word encountered
            if (!isStopWord(word.toLowerCase(), stopWords)) {
                wordCount++;
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        // Display the total count of words
        System.out.println("Total number of words: " + wordCount);

        // Display the frequency of each word
        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }

    // Function to check if a word is a stop word
    private static boolean isStopWord(String word, String[] stopWords) {
        for (String stopWord : stopWords) {
            if (word.equals(stopWord)) {
                return true;
            }
        }
        return false;
    }
}
