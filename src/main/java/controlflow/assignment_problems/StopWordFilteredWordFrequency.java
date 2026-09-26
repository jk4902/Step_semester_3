package controlflow.assignment_problems;

import java.util.HashMap;
import java.util.Map;

public class StopWordFilteredWordFrequency {

    static void printFilteredWordFrequency(String feedback) {

        String[] stopWords = {
                "the", "was", "and", "a", "is", "of", "in"
        };

        String cleanedText = feedback
                .toLowerCase()
                .replace(".", "")
                .replace(",", "");

        String[] words = cleanedText.split("\\s+");

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            boolean isStopWord = false;

            for (String stopWord : stopWords) {

                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord) {

                frequency.put(
                        word,
                        frequency.getOrDefault(word, 0) + 1
                );
            }
        }

        frequency.entrySet()
                .stream()
                .sorted(
                        (entry1, entry2) ->
                                entry2.getValue()
                                        .compareTo(entry1.getValue())
                )
                .forEach(
                        entry -> System.out.println(
                                entry.getKey() + ": " +
                                entry.getValue()
                        )
                );
    }

    public static void main(String[] args) {

        String feedback =
                "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}
