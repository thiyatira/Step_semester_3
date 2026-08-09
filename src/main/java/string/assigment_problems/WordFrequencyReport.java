package string.assigment_problems;

import java.util.*;

// Question 5: Stop word filtered frequency report
public class WordFrequencyReport {

    // small list of common filler words to ignore
    private static final Set<String> STOP_WORDS = new HashSet<>(
            Arrays.asList("the", "was", "and", "a", "is", "of", "in")
    );

    public static void printFilteredWordFrequency(String feedback) {
        if(feedback == null || feedback.trim().isEmpty()) {
            System.out.println("No words to process.");
            return;
        }

        // remove basic punctuation
        String clean = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "")
                .replace("!", "")
                .replace("?", "")
                .replace(";", "")
                .replace(":", "");

        String[] words = clean.trim().split("\\s+");
        Map<String, Integer> map = new HashMap<>();

        for(String w : words) {
            if(w.isEmpty() || STOP_WORDS.contains(w)) {
                continue;
            }
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        // sort by frequency descending
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            int cmp = b.getValue().compareTo(a.getValue());
            if(cmp != 0) return cmp;
            return a.getKey().compareTo(b.getKey());
        });

        for(Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String feedback = "The mentor was great, the session was great and clear.";
        System.out.println("Feedback: \"" + feedback + "\"\n");
        printFilteredWordFrequency(feedback);
    }
}
