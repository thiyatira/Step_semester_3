package arrays.assigment_problems;

// Question 5: Movie Review Word Length Profiler
// short: 1-4, medium: 5-8, long: 9+
public class MovieReviewProfiler {

    public static void classifyWordLengths(String review) {
        if(review == null || review.trim().length() == 0) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        // split words by space
        String[] words = review.trim().split("\\s+");

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for(String w : words) {
            // strip any punctuation attached to word
            String clean = w.replaceAll("[^a-zA-Z]", "");
            int len = clean.isEmpty() ? w.length() : clean.length();

            if(len >= 1 && len <= 4) {
                shortCount++;
            } else if(len >= 5 && len <= 8) {
                mediumCount++;
            } else if(len >= 9) {
                longCount++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        String review = "This movie was absolutely fantastic and thrilling";
        System.out.println("Review: \"" + review + "\"");
        classifyWordLengths(review);
    }
}
