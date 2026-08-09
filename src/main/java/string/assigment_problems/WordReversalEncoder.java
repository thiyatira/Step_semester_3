package string.assigment_problems;

// Question 2: Word reversal encoder
// reverses each word individually but keeps word order same
public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {
        if(sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < words.length; i++) {
            String w = words[i];
            StringBuilder rev = new StringBuilder();
            // loop backwards to reverse this word
            for(int j = w.length() - 1; j >= 0; j--) {
                rev.append(w.charAt(j));
            }
            res.append(rev);
            if(i < words.length - 1) {
                res.append(" ");
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String input = "hello club";
        String output = reverseEachWord(input);
        System.out.println("Input:  \"" + input + "\"");
        System.out.println("Output: \"" + output + "\"");
    }
}
